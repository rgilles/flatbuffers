/*
 * Copyright 2014 Google Inc. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.flatbuffers;

import static com.google.flatbuffers.Constants.*;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;

/// @cond FLATBUFFERS_INTERNAL

/**
 * All tables in the generated code derive from this class, and add their own accessors.
 */
public class Table {
  private final static ThreadLocal<CharsetDecoder> UTF8_DECODER = new ThreadLocal<CharsetDecoder>() {
    @Override
    protected CharsetDecoder initialValue() {
      return Charset.forName("UTF-8").newDecoder();
    }
  };
  protected final static ThreadLocal<Charset> UTF8_CHARSET = new ThreadLocal<Charset>() {
    @Override
    protected Charset initialValue() {
      return Charset.forName("UTF-8");
    }
  };
  private final static ThreadLocal<CharBuffer> CHAR_BUFFER = new ThreadLocal<CharBuffer>();
  /** Used to hold the position of the `bb` buffer. */
  protected int bb_pos;
  /** The underlying ByteBuffer to hold the data of the Table. */
  protected ByteBuffer bb;

  /**
   * Get the underlying ByteBuffer.
   *
   * @return Returns the Table's ByteBuffer.
   */
  public ByteBuffer getByteBuffer() { return bb; }

  /**
   * Initialized this {@link Table} to the given position for the giver {@code ByteBuffer}.
   *
   * @param position position of this {@link Table} in the {@code ByteBuffer}.
   * @param bb the {@code ByteBuffer} whose contains this {@link Table}.
   */
  public void __init(int position, ByteBuffer bb) {
    bb_pos = position; this.bb = bb;
  }

  /**
   * Look up a field in the vtable.
   *
   * @param vtable_offset An `int` offset to the vtable in the Table's ByteBuffer.
   * @return Returns an offset into the object, or `0` if the field is not present.
   */
  protected int __offset(int vtable_offset) {
    int vtable = bb_pos - bb.getInt(bb_pos);
    return vtable_offset < bb.getShort(vtable) ? bb.getShort(vtable + vtable_offset) : 0;
  }

  /**
   * Look up a field in the vtable.
   * Sames as new Table(table_offset, bb).__offset( vtable_offset )
   * @param vtable_offset An `int` offset to the vtable in the Table's ByteBuffer.
   * @param table_offset Offset of the table in bb (same as bb_pos field in Table).
   * @param bb the {@code ByteBuffer} whose contains this {@link Table}.
   * @return Returns an offset into the object, or `0` if the field is not present.
   */
  protected static int __offset(int vtable_offset, int table_offset, ByteBuffer bb) {
    int vtable = table_offset - bb.getInt(table_offset);
    return vtable_offset < bb.getShort(vtable) ? bb.getShort(vtable + vtable_offset) : 0;
  }

  /**
   * Retrieve a relative offset.
   *
   * @param offset An `int` index into the Table's ByteBuffer containing the relative offset.
   * @return Returns the relative offset stored at `offset`.
   */
  protected int __indirect(int offset) {
    return offset + bb.getInt(offset);
  }

  protected static int __indirect(int offset, ByteBuffer bb) {
    return offset + bb.getInt(offset);
  }

  /**
   * Create a Java `String` from UTF-8 data stored inside the FlatBuffer.
   *
   * This allocates a new string and converts to wide chars upon each access,
   * which is not very efficient. Instead, each FlatBuffer string also comes with an
   * accessor based on __vector_as_bytebuffer below, which is much more efficient,
   * assuming your Java program can handle UTF-8 data directly.
   *
   * @param offset An `int` index into the Table's ByteBuffer.
   * @return Returns a `String` from the data stored inside the FlatBuffer at `offset`.
   */
  protected String __string(int offset) {
    CharsetDecoder decoder = UTF8_DECODER.get();
    decoder.reset();

    offset += bb.getInt(offset);
    ByteBuffer src = bb.duplicate().order(ByteOrder.LITTLE_ENDIAN);
    int length = src.getInt(offset);
    src.position(offset + SIZEOF_INT);
    src.limit(offset + SIZEOF_INT + length);

    int required = (int)((float)length * decoder.maxCharsPerByte());
    CharBuffer dst = CHAR_BUFFER.get();
    if (dst == null || dst.capacity() < required) {
      dst = CharBuffer.allocate(required);
      CHAR_BUFFER.set(dst);
    }

    dst.clear();

    try {
      CoderResult cr = decoder.decode(src, dst, true);
      if (!cr.isUnderflow()) {
        cr.throwException();
      }
    } catch (CharacterCodingException x) {
      throw new Error(x);
    }

    return dst.flip().toString();
  }

  /**
   * Get the length of a vector.
   *
   * @param offset An `int` index into the Table's ByteBuffer.
   * @return Returns the length of the vector whose offset is stored at `offset`.
   */
  protected int __vector_len(int offset) {
    offset += bb_pos;
    offset += bb.getInt(offset);
    return bb.getInt(offset);
  }

  /**
   * Get the start data of a vector.
   *
   * @param offset An `int` index into the Table's ByteBuffer.
   * @return Returns the start of the vector data whose offset is stored at `offset`.
   */
  protected int __vector(int offset) {
    offset += bb_pos;
    return offset + bb.getInt(offset) + SIZEOF_INT;  // data starts after the length
  }

  /**
   * Get a whole vector as a ByteBuffer.
   *
   * This is efficient, since it only allocates a new {@link ByteBuffer} object,
   * but does not actually copy the data, it still refers to the same bytes
   * as the original ByteBuffer. Also useful with nested FlatBuffers, etc.
   *
   * @param vector_offset The position of the vector in the byte buffer
   * @param elem_size The size of each element in the array
   * @return The {@link ByteBuffer} for the array
   */
  protected ByteBuffer __vector_as_bytebuffer(int vector_offset, int elem_size) {
    int o = __offset(vector_offset);
    if (o == 0) return null;
    ByteBuffer bb = this.bb.duplicate().order(ByteOrder.LITTLE_ENDIAN);
    int vectorstart = __vector(o);
    bb.position(vectorstart);
    bb.limit(vectorstart + __vector_len(o) * elem_size);
    return bb;
  }

  /**
   * Initialize any Table-derived type to point to the union at the given `offset`.
   *
   * @param t A `Table`-derived type that should point to the union at `offset`.
   * @param offset An `int` index into the Table's ByteBuffer.
   * @return Returns the Table that points to the union at `offset`.
   */
  protected Table __union(Table t, int offset) {
    offset += bb_pos;
    t.bb_pos = offset + bb.getInt(offset);
    t.bb = bb;
    return t;
  }

  /**
   * Check if a {@link ByteBuffer} contains a file identifier.
   *
   * @param bb A {@code ByteBuffer} to check if it contains the identifier
   * `ident`.
   * @param ident A `String` identifier of the FlatBuffer file.
   * @return True if the buffer contains the file identifier
   */
  protected static boolean __has_identifier(ByteBuffer bb, String ident) {
    if (ident.length() != FILE_IDENTIFIER_LENGTH)
        throw new AssertionError("FlatBuffers: file identifier must be length " +
                                 FILE_IDENTIFIER_LENGTH);
    for (int i = 0; i < FILE_IDENTIFIER_LENGTH; i++) {
      if (ident.charAt(i) != (char)bb.get(bb.position() + SIZEOF_INT + i)) return false;
    }
    return true;
  }

  /**
   * Sort tables by the key.
   *
   * @param offsets An 'int' indexes of the tables into the bb.
   * @param bb A {@code ByteBuffer} to get the tables.
   */
  protected void sortTables(int[] offsets, final ByteBuffer bb) {
    Integer[] off = new Integer[offsets.length];
    final int bufferSize = bb.array().length;
    for (int i = 0; i < offsets.length; i++) off[i] = offsets[i];
    java.util.Arrays.sort(off, new java.util.Comparator<Integer>() {
      public int compare(Integer o1, Integer o2) {
        // createSortedVectorOfTables() is called with offset relative to the end of the bufer,
        // we adjust them for keysCompare() that expect offset relative to the start of the buffer
        return keysCompare(bufferSize-o1, bufferSize-o2, bb);
      }
    });
    for (int i = 0; i < offsets.length; i++) offsets[i] = off[i];
  }

  /**
   * Compare two tables by the key.
   *
   * @param o1 An 'Integer' index of the first key into the bb.
   * @param o2 An 'Integer' index of the second key into the bb.
   * @param bb A {@code ByteBuffer} to get the keys.
   */
  protected int keysCompare(Integer o1, Integer o2, ByteBuffer bb) { return 0; }

  /**
   * Compare two strings in the buffer.
   *
   * @param offset_1 An 'int' index of the first string into the bb.
   * @param offset_2 An 'int' index of the second string into the bb.
   * @param bb A {@code ByteBuffer} to get the strings.
   */
  protected static int compareStrings(int offset_1, int offset_2, ByteBuffer bb) {
    offset_1 += bb.getInt(offset_1);
    offset_2 += bb.getInt(offset_2);
    int len_1 = bb.getInt(offset_1);
    int len_2 = bb.getInt(offset_2);
    int startPos_1 = offset_1 + SIZEOF_INT;
    int startPos_2 = offset_2 + SIZEOF_INT;
    int len = Math.min(len_1, len_2);
    byte[] bbArray = bb.array();
    for(int i = 0; i < len; i++) {
      if (bbArray[i + startPos_1] != bbArray[i + startPos_2])
        return bbArray[i + startPos_1] - bbArray[i + startPos_2];
    }
    return len_1 - len_2;
  }

  /**
   * Compare string from the buffer with the 'String' object.
   *
   * @param offset_1 An 'int' index of the first string into the bb.
   * @param key Second string as a byte array.
   * @param bb A {@code ByteBuffer} to get the first string.
   */
  protected static int compareStrings(int offset_1, byte[] key, ByteBuffer bb) {
    offset_1 += bb.getInt(offset_1);
    int len_1 = bb.getInt(offset_1);
    int len_2 = key.length;
    int startPos_1 = offset_1 + Constants.SIZEOF_INT;
    int len = Math.min(len_1, len_2);
    byte[] bbArray = bb.array();
    for (int i = 0; i < len; i++) {
      if (bbArray[i + startPos_1] != key[i])
        return bbArray[i + startPos_1] - key[i];
    }
    return len_1 - len_2;
  }

  protected int __lookupByBooleanKey(int vectorFieldOffset, int keyFieldOffset, boolean queryKey,
          boolean defaultValue ) {
    byte key = (byte)(queryKey ? 1 : 0);
    byte byteDefaultValue = (byte)(defaultValue ? 1 : 0);
    return __lookupByByteKey(vectorFieldOffset, keyFieldOffset, key, byteDefaultValue);
  }

  /// Returns the field at the given offset as a "comparable" integer
  interface FieldAsIntGetter {
    int getValue( ByteBuffer bb, int offsetInByteBuffer );
  }

  /// Returns the field at the given offset as a "comparable" integer
  interface FieldAsLongGetter {
    long getValue( ByteBuffer bb, int offsetInByteBuffer );
  }


  static FieldAsIntGetter BYTE_FIELD_GETTER = new FieldAsIntGetter() {
    @Override
    public int getValue(ByteBuffer bb, int offsetInByteBuffer) {
      return bb.get(offsetInByteBuffer);
    }
  };

  static FieldAsIntGetter UBYTE_FIELD_GETTER = new FieldAsIntGetter() {
    @Override
    public int getValue(ByteBuffer bb, int offsetInByteBuffer) {
      return Unsigneds.asComparable( bb.get(offsetInByteBuffer) );
    }
  };

  static FieldAsIntGetter SHORT_FIELD_GETTER = new FieldAsIntGetter() {
    @Override
    public int getValue(ByteBuffer bb, int offsetInByteBuffer) {
      return bb.getShort(offsetInByteBuffer);
    }
  };

  static FieldAsIntGetter USHORT_FIELD_GETTER = new FieldAsIntGetter() {
    @Override
    public int getValue(ByteBuffer bb, int offsetInByteBuffer) {
      return Unsigneds.asComparable( bb.getShort(offsetInByteBuffer) );
    }
  };

  static FieldAsIntGetter INT_FIELD_GETTER = new FieldAsIntGetter() {
    @Override
    public int getValue(ByteBuffer bb, int offsetInByteBuffer) {
      return bb.getInt(offsetInByteBuffer);
    }
  };

  static FieldAsIntGetter UINT_FIELD_GETTER = new FieldAsIntGetter() {
    @Override
    public int getValue(ByteBuffer bb, int offsetInByteBuffer) {
      return Unsigneds.asComparable( bb.getInt(offsetInByteBuffer) );
    }
  };

  static FieldAsLongGetter LONG_FIELD_GETTER = new FieldAsLongGetter() {
    @Override
    public long getValue(ByteBuffer bb, int offsetInByteBuffer) {
      return bb.getLong(offsetInByteBuffer);
    }
  };

  static FieldAsLongGetter ULONG_FIELD_GETTER = new FieldAsLongGetter() {
    @Override
    public long getValue(ByteBuffer bb, int offsetInByteBuffer) {
      return Unsigneds.asComparable( bb.getLong(offsetInByteBuffer) );
    }
  };

  static FieldAsIntGetter FLOAT_FIELD_GETTER = new FieldAsIntGetter() {
    @Override
    public int getValue(ByteBuffer bb, int offsetInByteBuffer) {
      return Floats.asComparable( bb.getFloat(offsetInByteBuffer) );
    }
  };

  static FieldAsLongGetter DOUBLE_FIELD_GETTER = new FieldAsLongGetter() {
    @Override
    public long getValue(ByteBuffer bb, int offsetInByteBuffer) {
      return Floats.asComparable( bb.getDouble(offsetInByteBuffer) );
    }
  };


  private int __genericIntLookupByKey(int vectorFieldOffset, int keyFieldOffset, int key, int defaultValue,
                                      FieldAsIntGetter fieldGetter ) {
    int fieldDataOffset = __offset(vectorFieldOffset);
    if ( fieldDataOffset == 0 )
      return 0;
    int vectorLocation = __vector( fieldDataOffset );
    int span = bb.getInt(vectorLocation-SIZEOF_INT);
    int start = 0;
    while (span != 0) {
      int middle = span / 2;
      int tableOffset = __indirect(vectorLocation + SIZEOF_INT * (start + middle), bb);
      int keyValueOffset = __offset( keyFieldOffset, tableOffset, bb );
      int val = keyValueOffset != 0 ? fieldGetter.getValue(bb, tableOffset + keyValueOffset) : defaultValue;
      if (key < val) {
        span = middle;
      } else if (key > val) {
        middle++;
        start += middle;
        span -= middle;
      } else {
        return tableOffset;
      }
    }
    return 0;
  }


  private int __genericLongLookupByKey(int vectorFieldOffset, int keyFieldOffset, long key, long defaultValue,
                                      FieldAsLongGetter fieldGetter ) {
    int fieldDataOffset = __offset(vectorFieldOffset);
    if ( fieldDataOffset == 0 )
      return 0;
    int vectorLocation = __vector( fieldDataOffset );
    int span = bb.getInt(vectorLocation-SIZEOF_INT);
    int start = 0;
    while (span != 0) {
      int middle = span / 2;
      int tableOffset = __indirect(vectorLocation + SIZEOF_INT * (start + middle), bb);
      int keyValueOffset = __offset( keyFieldOffset, tableOffset, bb );
      long val = keyValueOffset != 0 ? fieldGetter.getValue(bb, tableOffset + keyValueOffset) : defaultValue;
      if (key < val) {
        span = middle;
      } else if (key > val) {
        middle++;
        start += middle;
        span -= middle;
      } else {
        return tableOffset;
      }
    }
    return 0;
  }


  protected int __lookupByByteKey(int vectorFieldOffset, int keyFieldOffset, int queryKey,
          int queryDefaultValue ) {
    return __genericIntLookupByKey( vectorFieldOffset, keyFieldOffset, queryKey, queryDefaultValue, BYTE_FIELD_GETTER );
  }

  protected int __lookupByUByteKey(int vectorFieldOffset, int keyFieldOffset, int key,
          int queryDefaultValue) {
    return __genericIntLookupByKey( vectorFieldOffset, keyFieldOffset, Unsigneds.asComparable((byte)key),
            Unsigneds.asComparable((byte)queryDefaultValue), UBYTE_FIELD_GETTER );
  }

  protected int __lookupByShortKey(int vectorFieldOffset, int keyFieldOffset, int key, int defaultValue) {
    return __genericIntLookupByKey( vectorFieldOffset, keyFieldOffset, key, defaultValue, SHORT_FIELD_GETTER );
  }

  protected int __lookupByUShortKey(int vectorFieldOffset, int keyFieldOffset, int key, int defaultValue) {
    return __genericIntLookupByKey( vectorFieldOffset, keyFieldOffset, Unsigneds.asComparable((short)key),
            Unsigneds.asComparable((short)defaultValue), USHORT_FIELD_GETTER );
  }

  protected int __lookupByIntKey(int vectorFieldOffset, int keyFieldOffset, int key, int defaultValue) {
    return __genericIntLookupByKey( vectorFieldOffset, keyFieldOffset, key,
            defaultValue, INT_FIELD_GETTER );
  }

  protected int __lookupByUIntKey(int vectorFieldOffset, int keyFieldOffset, long key,
          long defaultValue) {
    return __genericIntLookupByKey( vectorFieldOffset, keyFieldOffset, Unsigneds.asComparable((int)key),
            Unsigneds.asComparable((int)defaultValue), UINT_FIELD_GETTER );
  }

  protected int __lookupByLongKey(int vectorFieldOffset, int keyFieldOffset, long key, long defaultValue) {
    return __genericLongLookupByKey( vectorFieldOffset, keyFieldOffset, key, defaultValue, LONG_FIELD_GETTER );
  }

  protected int __lookupByULongKey(int vectorFieldOffset, int keyFieldOffset, long key, long defaultValue) {
    return __genericLongLookupByKey( vectorFieldOffset, keyFieldOffset, Unsigneds.asComparable(key),
            Unsigneds.asComparable(defaultValue), ULONG_FIELD_GETTER );
  }

  protected int __lookupByFloatKey(int vectorFieldOffset, int keyFieldOffset, float key,
          float defaultValue) {
    return __genericIntLookupByKey( vectorFieldOffset, keyFieldOffset, Floats.asComparable(key),
            Floats.asComparable(defaultValue), FLOAT_FIELD_GETTER);
  }

  protected int __lookupByDoubleKey(int vectorFieldOffset, int keyFieldOffset, double key,
          double defaultValue) {
    return __genericLongLookupByKey(vectorFieldOffset, keyFieldOffset, Floats.asComparable(key),
            Floats.asComparable(defaultValue), DOUBLE_FIELD_GETTER);
  }

  protected int __lookupByStringKey(int vectorFieldOffset, int keyFieldOffset, String key) {
    byte[] byteKey = key.getBytes(Table.UTF8_CHARSET.get());
    int fieldDataOffset = __offset(vectorFieldOffset);
    if ( fieldDataOffset == 0 )
      return 0;
    int vectorLocation = __vector( fieldDataOffset );
    int span = bb.getInt(vectorLocation-SIZEOF_INT);
    int start = 0;
    while (span != 0) {
      int middle = span / 2;
      int tableOffset = __indirect(vectorLocation + SIZEOF_INT * (start + middle), bb);
      int keyValueOffset = __offset( keyFieldOffset, tableOffset, bb );
      int comp = compareStrings(tableOffset + keyValueOffset, byteKey, bb);
      if (comp > 0) {
        span = middle;
      } else if (comp < 0) {
        middle++;
        start += middle;
        span -= middle;
      } else {
        return tableOffset;
      }
    }
    return 0;
  }

}

/// @endcond
