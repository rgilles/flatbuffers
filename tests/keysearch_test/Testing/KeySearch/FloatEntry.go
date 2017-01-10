// automatically generated by the FlatBuffers compiler, do not modify

package KeySearch

import (
	flatbuffers "github.com/google/flatbuffers/go"
)

type FloatEntry struct {
	_tab flatbuffers.Table
}

func GetRootAsFloatEntry(buf []byte, offset flatbuffers.UOffsetT) *FloatEntry {
	n := flatbuffers.GetUOffsetT(buf[offset:])
	x := &FloatEntry{}
	x.Init(buf, n+offset)
	return x
}

func (rcv *FloatEntry) Init(buf []byte, i flatbuffers.UOffsetT) {
	rcv._tab.Bytes = buf
	rcv._tab.Pos = i
}

func (rcv *FloatEntry) Table() flatbuffers.Table {
	return rcv._tab
}

func (rcv *FloatEntry) Key() float32 {
	o := flatbuffers.UOffsetT(rcv._tab.Offset(4))
	if o != 0 {
		return rcv._tab.GetFloat32(o + rcv._tab.Pos)
	}
	return 0.0
}

func (rcv *FloatEntry) MutateKey(n float32) bool {
	return rcv._tab.MutateFloat32Slot(4, n)
}

func (rcv *FloatEntry) Value() float32 {
	o := flatbuffers.UOffsetT(rcv._tab.Offset(6))
	if o != 0 {
		return rcv._tab.GetFloat32(o + rcv._tab.Pos)
	}
	return 1234.0
}

func (rcv *FloatEntry) MutateValue(n float32) bool {
	return rcv._tab.MutateFloat32Slot(6, n)
}

func FloatEntryStart(builder *flatbuffers.Builder) {
	builder.StartObject(2)
}
func FloatEntryAddKey(builder *flatbuffers.Builder, key float32) {
	builder.PrependFloat32Slot(0, key, 0.0)
}
func FloatEntryAddValue(builder *flatbuffers.Builder, value float32) {
	builder.PrependFloat32Slot(1, value, 1234.0)
}
func FloatEntryEnd(builder *flatbuffers.Builder) flatbuffers.UOffsetT {
	return builder.EndObject()
}
