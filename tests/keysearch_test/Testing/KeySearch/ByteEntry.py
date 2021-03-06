# automatically generated by the FlatBuffers compiler, do not modify

# namespace: KeySearch

import flatbuffers

class ByteEntry(object):
    __slots__ = ['_tab']

    @classmethod
    def GetRootAsByteEntry(cls, buf, offset):
        n = flatbuffers.encode.Get(flatbuffers.packer.uoffset, buf, offset)
        x = ByteEntry()
        x.Init(buf, n + offset)
        return x

    # ByteEntry
    def Init(self, buf, pos):
        self._tab = flatbuffers.table.Table(buf, pos)

    # ByteEntry
    def Key(self):
        o = flatbuffers.number_types.UOffsetTFlags.py_type(self._tab.Offset(4))
        if o != 0:
            return self._tab.Get(flatbuffers.number_types.Int8Flags, o + self._tab.Pos)
        return -128

    # ByteEntry
    def Value(self):
        o = flatbuffers.number_types.UOffsetTFlags.py_type(self._tab.Offset(6))
        if o != 0:
            return self._tab.Get(flatbuffers.number_types.Int8Flags, o + self._tab.Pos)
        return -128

def ByteEntryStart(builder): builder.StartObject(2)
def ByteEntryAddKey(builder, key): builder.PrependInt8Slot(0, key, -128)
def ByteEntryAddValue(builder, value): builder.PrependInt8Slot(1, value, -128)
def ByteEntryEnd(builder): return builder.EndObject()
