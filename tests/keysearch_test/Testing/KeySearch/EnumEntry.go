// automatically generated by the FlatBuffers compiler, do not modify

package KeySearch

import (
	flatbuffers "github.com/google/flatbuffers/go"
)

type EnumEntry struct {
	_tab flatbuffers.Table
}

func GetRootAsEnumEntry(buf []byte, offset flatbuffers.UOffsetT) *EnumEntry {
	n := flatbuffers.GetUOffsetT(buf[offset:])
	x := &EnumEntry{}
	x.Init(buf, n+offset)
	return x
}

func (rcv *EnumEntry) Init(buf []byte, i flatbuffers.UOffsetT) {
	rcv._tab.Bytes = buf
	rcv._tab.Pos = i
}

func (rcv *EnumEntry) Table() flatbuffers.Table {
	return rcv._tab
}

func (rcv *EnumEntry) Key() int32 {
	o := flatbuffers.UOffsetT(rcv._tab.Offset(4))
	if o != 0 {
		return rcv._tab.GetInt32(o + rcv._tab.Pos)
	}
	return 0
}

func (rcv *EnumEntry) MutateKey(n int32) bool {
	return rcv._tab.MutateInt32Slot(4, n)
}

func (rcv *EnumEntry) Value() int32 {
	o := flatbuffers.UOffsetT(rcv._tab.Offset(6))
	if o != 0 {
		return rcv._tab.GetInt32(o + rcv._tab.Pos)
	}
	return 7412
}

func (rcv *EnumEntry) MutateValue(n int32) bool {
	return rcv._tab.MutateInt32Slot(6, n)
}

func EnumEntryStart(builder *flatbuffers.Builder) {
	builder.StartObject(2)
}
func EnumEntryAddKey(builder *flatbuffers.Builder, key int32) {
	builder.PrependInt32Slot(0, key, 0)
}
func EnumEntryAddValue(builder *flatbuffers.Builder, value int32) {
	builder.PrependInt32Slot(1, value, 7412)
}
func EnumEntryEnd(builder *flatbuffers.Builder) flatbuffers.UOffsetT {
	return builder.EndObject()
}
