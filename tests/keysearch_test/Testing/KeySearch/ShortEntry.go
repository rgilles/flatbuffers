// automatically generated by the FlatBuffers compiler, do not modify

package KeySearch

import (
	flatbuffers "github.com/google/flatbuffers/go"
)

type ShortEntry struct {
	_tab flatbuffers.Table
}

func GetRootAsShortEntry(buf []byte, offset flatbuffers.UOffsetT) *ShortEntry {
	n := flatbuffers.GetUOffsetT(buf[offset:])
	x := &ShortEntry{}
	x.Init(buf, n+offset)
	return x
}

func (rcv *ShortEntry) Init(buf []byte, i flatbuffers.UOffsetT) {
	rcv._tab.Bytes = buf
	rcv._tab.Pos = i
}

func (rcv *ShortEntry) Key() int16 {
	o := flatbuffers.UOffsetT(rcv._tab.Offset(4))
	if o != 0 {
		return rcv._tab.GetInt16(o + rcv._tab.Pos)
	}
	return -32768
}

func (rcv *ShortEntry) MutateKey(n int16) bool {
	return rcv._tab.MutateInt16Slot(4, n)
}

func (rcv *ShortEntry) Value() int16 {
	o := flatbuffers.UOffsetT(rcv._tab.Offset(6))
	if o != 0 {
		return rcv._tab.GetInt16(o + rcv._tab.Pos)
	}
	return -32768
}

func (rcv *ShortEntry) MutateValue(n int16) bool {
	return rcv._tab.MutateInt16Slot(6, n)
}

func ShortEntryStart(builder *flatbuffers.Builder) {
	builder.StartObject(2)
}
func ShortEntryAddKey(builder *flatbuffers.Builder, key int16) {
	builder.PrependInt16Slot(0, key, -32768)
}
func ShortEntryAddValue(builder *flatbuffers.Builder, value int16) {
	builder.PrependInt16Slot(1, value, -32768)
}
func ShortEntryEnd(builder *flatbuffers.Builder) flatbuffers.UOffsetT {
	return builder.EndObject()
}