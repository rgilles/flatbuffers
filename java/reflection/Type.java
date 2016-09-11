// automatically generated by the FlatBuffers compiler, do not modify

package reflection;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import com.google.flatbuffers.FlatBufferBuilder;
import com.google.flatbuffers.Table;

@SuppressWarnings("unused")
public final class Type extends Table {
  public static Type getRootAsType(ByteBuffer _bb) { return getRootAsType(_bb, new Type()); }
  public static Type getRootAsType(ByteBuffer _bb, Type obj) { _bb.order(ByteOrder.LITTLE_ENDIAN); return (obj.__init(_bb.getInt(_bb.position()) + _bb.position(), _bb)); }
  public Type __init(int _i, ByteBuffer _bb) { bb_pos = _i; bb = _bb; return this; }

  public byte baseType() { int o = __offset(4); return o != 0 ? bb.get(o + bb_pos) : 0; }
  public byte element() { int o = __offset(6); return o != 0 ? bb.get(o + bb_pos) : 0; }
  public int index() { int o = __offset(8); return o != 0 ? bb.getInt(o + bb_pos) : -1; }

  public static int createType(FlatBufferBuilder builder,
      byte base_type,
      byte element,
      int index) {
    builder.startObject(3);
    Type.addIndex(builder, index);
    Type.addElement(builder, element);
    Type.addBaseType(builder, base_type);
    return Type.endType(builder);
  }

  public static void startType(FlatBufferBuilder builder) { builder.startObject(3); }
  public static void addBaseType(FlatBufferBuilder builder, byte baseType) { builder.addByte(0, baseType, 0); }
  public static void addElement(FlatBufferBuilder builder, byte element) { builder.addByte(1, element, 0); }
  public static void addIndex(FlatBufferBuilder builder, int index) { builder.addInt(2, index, -1); }
  public static int endType(FlatBufferBuilder builder) {
    int o = builder.endObject();
    return o;
  }
}

