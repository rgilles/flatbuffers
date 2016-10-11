<?php
// automatically generated by the FlatBuffers compiler, do not modify

namespace Testing\KeySearch;

use \Google\FlatBuffers\Struct;
use \Google\FlatBuffers\Table;
use \Google\FlatBuffers\ByteBuffer;
use \Google\FlatBuffers\FlatBufferBuilder;

class MasterDict extends Table
{
    /**
     * @param ByteBuffer $bb
     * @return MasterDict
     */
    public static function getRootAsMasterDict(ByteBuffer $bb)
    {
        $obj = new MasterDict();
        return ($obj->init($bb->getInt($bb->getPosition()) + $bb->getPosition(), $bb));
    }

    public static function MasterDictIdentifier()
    {
        return "FBMD";
    }

    public static function MasterDictBufferHasIdentifier(ByteBuffer $buf)
    {
        return self::__has_identifier($buf, self::MasterDictIdentifier());
    }

    public static function MasterDictExtension()
    {
        return "mdict";
    }

    /**
     * @param int $_i offset
     * @param ByteBuffer $_bb
     * @return MasterDict
     **/
    public function init($_i, ByteBuffer $_bb)
    {
        $this->bb_pos = $_i;
        $this->bb = $_bb;
        return $this;
    }

    /**
     * @returnVectorOffset
     */
    public function getUbytesEntries($j)
    {
        $o = $this->__offset(4);
        $obj = new UByteEntry();
        return $o != 0 ? $obj->init($this->__indirect($this->__vector($o) + $j * 4), $this->bb) : null;
    }

    /**
     * @return int
     */
    public function getUbytesEntriesLength()
    {
        $o = $this->__offset(4);
        return $o != 0 ? $this->__vector_len($o) : 0;
    }

    /**
     * @returnVectorOffset
     */
    public function getBytesEntries($j)
    {
        $o = $this->__offset(6);
        $obj = new ByteEntry();
        return $o != 0 ? $obj->init($this->__indirect($this->__vector($o) + $j * 4), $this->bb) : null;
    }

    /**
     * @return int
     */
    public function getBytesEntriesLength()
    {
        $o = $this->__offset(6);
        return $o != 0 ? $this->__vector_len($o) : 0;
    }

    /**
     * @returnVectorOffset
     */
    public function getBoolEntries($j)
    {
        $o = $this->__offset(8);
        $obj = new BoolEntry();
        return $o != 0 ? $obj->init($this->__indirect($this->__vector($o) + $j * 4), $this->bb) : null;
    }

    /**
     * @return int
     */
    public function getBoolEntriesLength()
    {
        $o = $this->__offset(8);
        return $o != 0 ? $this->__vector_len($o) : 0;
    }

    /**
     * @returnVectorOffset
     */
    public function getShortEntries($j)
    {
        $o = $this->__offset(10);
        $obj = new ShortEntry();
        return $o != 0 ? $obj->init($this->__indirect($this->__vector($o) + $j * 4), $this->bb) : null;
    }

    /**
     * @return int
     */
    public function getShortEntriesLength()
    {
        $o = $this->__offset(10);
        return $o != 0 ? $this->__vector_len($o) : 0;
    }

    /**
     * @returnVectorOffset
     */
    public function getUshortEntries($j)
    {
        $o = $this->__offset(12);
        $obj = new UShortEntry();
        return $o != 0 ? $obj->init($this->__indirect($this->__vector($o) + $j * 4), $this->bb) : null;
    }

    /**
     * @return int
     */
    public function getUshortEntriesLength()
    {
        $o = $this->__offset(12);
        return $o != 0 ? $this->__vector_len($o) : 0;
    }

    /**
     * @returnVectorOffset
     */
    public function getIntEntries($j)
    {
        $o = $this->__offset(14);
        $obj = new IntEntry();
        return $o != 0 ? $obj->init($this->__indirect($this->__vector($o) + $j * 4), $this->bb) : null;
    }

    /**
     * @return int
     */
    public function getIntEntriesLength()
    {
        $o = $this->__offset(14);
        return $o != 0 ? $this->__vector_len($o) : 0;
    }

    /**
     * @returnVectorOffset
     */
    public function getUintEntries($j)
    {
        $o = $this->__offset(16);
        $obj = new UIntEntry();
        return $o != 0 ? $obj->init($this->__indirect($this->__vector($o) + $j * 4), $this->bb) : null;
    }

    /**
     * @return int
     */
    public function getUintEntriesLength()
    {
        $o = $this->__offset(16);
        return $o != 0 ? $this->__vector_len($o) : 0;
    }

    /**
     * @returnVectorOffset
     */
    public function getFloatEntries($j)
    {
        $o = $this->__offset(18);
        $obj = new FloatEntry();
        return $o != 0 ? $obj->init($this->__indirect($this->__vector($o) + $j * 4), $this->bb) : null;
    }

    /**
     * @return int
     */
    public function getFloatEntriesLength()
    {
        $o = $this->__offset(18);
        return $o != 0 ? $this->__vector_len($o) : 0;
    }

    /**
     * @returnVectorOffset
     */
    public function getLongEntries($j)
    {
        $o = $this->__offset(20);
        $obj = new LongEntry();
        return $o != 0 ? $obj->init($this->__indirect($this->__vector($o) + $j * 4), $this->bb) : null;
    }

    /**
     * @return int
     */
    public function getLongEntriesLength()
    {
        $o = $this->__offset(20);
        return $o != 0 ? $this->__vector_len($o) : 0;
    }

    /**
     * @returnVectorOffset
     */
    public function getUlongEntries($j)
    {
        $o = $this->__offset(22);
        $obj = new ULongEntry();
        return $o != 0 ? $obj->init($this->__indirect($this->__vector($o) + $j * 4), $this->bb) : null;
    }

    /**
     * @return int
     */
    public function getUlongEntriesLength()
    {
        $o = $this->__offset(22);
        return $o != 0 ? $this->__vector_len($o) : 0;
    }

    /**
     * @returnVectorOffset
     */
    public function getDoubleEntries($j)
    {
        $o = $this->__offset(24);
        $obj = new DoubleEntry();
        return $o != 0 ? $obj->init($this->__indirect($this->__vector($o) + $j * 4), $this->bb) : null;
    }

    /**
     * @return int
     */
    public function getDoubleEntriesLength()
    {
        $o = $this->__offset(24);
        return $o != 0 ? $this->__vector_len($o) : 0;
    }

    /**
     * @returnVectorOffset
     */
    public function getStringEntries($j)
    {
        $o = $this->__offset(26);
        $obj = new StringEntry();
        return $o != 0 ? $obj->init($this->__indirect($this->__vector($o) + $j * 4), $this->bb) : null;
    }

    /**
     * @return int
     */
    public function getStringEntriesLength()
    {
        $o = $this->__offset(26);
        return $o != 0 ? $this->__vector_len($o) : 0;
    }

    /**
     * @param FlatBufferBuilder $builder
     * @return void
     */
    public static function startMasterDict(FlatBufferBuilder $builder)
    {
        $builder->StartObject(12);
    }

    /**
     * @param FlatBufferBuilder $builder
     * @return MasterDict
     */
    public static function createMasterDict(FlatBufferBuilder $builder, $ubytesEntries, $bytesEntries, $boolEntries, $shortEntries, $ushortEntries, $intEntries, $uintEntries, $floatEntries, $longEntries, $ulongEntries, $doubleEntries, $stringEntries)
    {
        $builder->startObject(12);
        self::addUbytesEntries($builder, $ubytesEntries);
        self::addBytesEntries($builder, $bytesEntries);
        self::addBoolEntries($builder, $boolEntries);
        self::addShortEntries($builder, $shortEntries);
        self::addUshortEntries($builder, $ushortEntries);
        self::addIntEntries($builder, $intEntries);
        self::addUintEntries($builder, $uintEntries);
        self::addFloatEntries($builder, $floatEntries);
        self::addLongEntries($builder, $longEntries);
        self::addUlongEntries($builder, $ulongEntries);
        self::addDoubleEntries($builder, $doubleEntries);
        self::addStringEntries($builder, $stringEntries);
        $o = $builder->endObject();
        return $o;
    }

    /**
     * @param FlatBufferBuilder $builder
     * @param VectorOffset
     * @return void
     */
    public static function addUbytesEntries(FlatBufferBuilder $builder, $ubytesEntries)
    {
        $builder->addOffsetX(0, $ubytesEntries, 0);
    }

    /**
     * @param FlatBufferBuilder $builder
     * @param array offset array
     * @return int vector offset
     */
    public static function createUbytesEntriesVector(FlatBufferBuilder $builder, array $data)
    {
        $builder->startVector(4, count($data), 4);
        for ($i = count($data) - 1; $i >= 0; $i--) {
            $builder->addOffset($data[$i]);
        }
        return $builder->endVector();
    }

    /**
     * @param FlatBufferBuilder $builder
     * @param int $numElems
     * @return void
     */
    public static function startUbytesEntriesVector(FlatBufferBuilder $builder, $numElems)
    {
        $builder->startVector(4, $numElems, 4);
    }

    /**
     * @param FlatBufferBuilder $builder
     * @param VectorOffset
     * @return void
     */
    public static function addBytesEntries(FlatBufferBuilder $builder, $bytesEntries)
    {
        $builder->addOffsetX(1, $bytesEntries, 0);
    }

    /**
     * @param FlatBufferBuilder $builder
     * @param array offset array
     * @return int vector offset
     */
    public static function createBytesEntriesVector(FlatBufferBuilder $builder, array $data)
    {
        $builder->startVector(4, count($data), 4);
        for ($i = count($data) - 1; $i >= 0; $i--) {
            $builder->addOffset($data[$i]);
        }
        return $builder->endVector();
    }

    /**
     * @param FlatBufferBuilder $builder
     * @param int $numElems
     * @return void
     */
    public static function startBytesEntriesVector(FlatBufferBuilder $builder, $numElems)
    {
        $builder->startVector(4, $numElems, 4);
    }

    /**
     * @param FlatBufferBuilder $builder
     * @param VectorOffset
     * @return void
     */
    public static function addBoolEntries(FlatBufferBuilder $builder, $boolEntries)
    {
        $builder->addOffsetX(2, $boolEntries, 0);
    }

    /**
     * @param FlatBufferBuilder $builder
     * @param array offset array
     * @return int vector offset
     */
    public static function createBoolEntriesVector(FlatBufferBuilder $builder, array $data)
    {
        $builder->startVector(4, count($data), 4);
        for ($i = count($data) - 1; $i >= 0; $i--) {
            $builder->addOffset($data[$i]);
        }
        return $builder->endVector();
    }

    /**
     * @param FlatBufferBuilder $builder
     * @param int $numElems
     * @return void
     */
    public static function startBoolEntriesVector(FlatBufferBuilder $builder, $numElems)
    {
        $builder->startVector(4, $numElems, 4);
    }

    /**
     * @param FlatBufferBuilder $builder
     * @param VectorOffset
     * @return void
     */
    public static function addShortEntries(FlatBufferBuilder $builder, $shortEntries)
    {
        $builder->addOffsetX(3, $shortEntries, 0);
    }

    /**
     * @param FlatBufferBuilder $builder
     * @param array offset array
     * @return int vector offset
     */
    public static function createShortEntriesVector(FlatBufferBuilder $builder, array $data)
    {
        $builder->startVector(4, count($data), 4);
        for ($i = count($data) - 1; $i >= 0; $i--) {
            $builder->addOffset($data[$i]);
        }
        return $builder->endVector();
    }

    /**
     * @param FlatBufferBuilder $builder
     * @param int $numElems
     * @return void
     */
    public static function startShortEntriesVector(FlatBufferBuilder $builder, $numElems)
    {
        $builder->startVector(4, $numElems, 4);
    }

    /**
     * @param FlatBufferBuilder $builder
     * @param VectorOffset
     * @return void
     */
    public static function addUshortEntries(FlatBufferBuilder $builder, $ushortEntries)
    {
        $builder->addOffsetX(4, $ushortEntries, 0);
    }

    /**
     * @param FlatBufferBuilder $builder
     * @param array offset array
     * @return int vector offset
     */
    public static function createUshortEntriesVector(FlatBufferBuilder $builder, array $data)
    {
        $builder->startVector(4, count($data), 4);
        for ($i = count($data) - 1; $i >= 0; $i--) {
            $builder->addOffset($data[$i]);
        }
        return $builder->endVector();
    }

    /**
     * @param FlatBufferBuilder $builder
     * @param int $numElems
     * @return void
     */
    public static function startUshortEntriesVector(FlatBufferBuilder $builder, $numElems)
    {
        $builder->startVector(4, $numElems, 4);
    }

    /**
     * @param FlatBufferBuilder $builder
     * @param VectorOffset
     * @return void
     */
    public static function addIntEntries(FlatBufferBuilder $builder, $intEntries)
    {
        $builder->addOffsetX(5, $intEntries, 0);
    }

    /**
     * @param FlatBufferBuilder $builder
     * @param array offset array
     * @return int vector offset
     */
    public static function createIntEntriesVector(FlatBufferBuilder $builder, array $data)
    {
        $builder->startVector(4, count($data), 4);
        for ($i = count($data) - 1; $i >= 0; $i--) {
            $builder->addOffset($data[$i]);
        }
        return $builder->endVector();
    }

    /**
     * @param FlatBufferBuilder $builder
     * @param int $numElems
     * @return void
     */
    public static function startIntEntriesVector(FlatBufferBuilder $builder, $numElems)
    {
        $builder->startVector(4, $numElems, 4);
    }

    /**
     * @param FlatBufferBuilder $builder
     * @param VectorOffset
     * @return void
     */
    public static function addUintEntries(FlatBufferBuilder $builder, $uintEntries)
    {
        $builder->addOffsetX(6, $uintEntries, 0);
    }

    /**
     * @param FlatBufferBuilder $builder
     * @param array offset array
     * @return int vector offset
     */
    public static function createUintEntriesVector(FlatBufferBuilder $builder, array $data)
    {
        $builder->startVector(4, count($data), 4);
        for ($i = count($data) - 1; $i >= 0; $i--) {
            $builder->addOffset($data[$i]);
        }
        return $builder->endVector();
    }

    /**
     * @param FlatBufferBuilder $builder
     * @param int $numElems
     * @return void
     */
    public static function startUintEntriesVector(FlatBufferBuilder $builder, $numElems)
    {
        $builder->startVector(4, $numElems, 4);
    }

    /**
     * @param FlatBufferBuilder $builder
     * @param VectorOffset
     * @return void
     */
    public static function addFloatEntries(FlatBufferBuilder $builder, $floatEntries)
    {
        $builder->addOffsetX(7, $floatEntries, 0);
    }

    /**
     * @param FlatBufferBuilder $builder
     * @param array offset array
     * @return int vector offset
     */
    public static function createFloatEntriesVector(FlatBufferBuilder $builder, array $data)
    {
        $builder->startVector(4, count($data), 4);
        for ($i = count($data) - 1; $i >= 0; $i--) {
            $builder->addOffset($data[$i]);
        }
        return $builder->endVector();
    }

    /**
     * @param FlatBufferBuilder $builder
     * @param int $numElems
     * @return void
     */
    public static function startFloatEntriesVector(FlatBufferBuilder $builder, $numElems)
    {
        $builder->startVector(4, $numElems, 4);
    }

    /**
     * @param FlatBufferBuilder $builder
     * @param VectorOffset
     * @return void
     */
    public static function addLongEntries(FlatBufferBuilder $builder, $longEntries)
    {
        $builder->addOffsetX(8, $longEntries, 0);
    }

    /**
     * @param FlatBufferBuilder $builder
     * @param array offset array
     * @return int vector offset
     */
    public static function createLongEntriesVector(FlatBufferBuilder $builder, array $data)
    {
        $builder->startVector(4, count($data), 4);
        for ($i = count($data) - 1; $i >= 0; $i--) {
            $builder->addOffset($data[$i]);
        }
        return $builder->endVector();
    }

    /**
     * @param FlatBufferBuilder $builder
     * @param int $numElems
     * @return void
     */
    public static function startLongEntriesVector(FlatBufferBuilder $builder, $numElems)
    {
        $builder->startVector(4, $numElems, 4);
    }

    /**
     * @param FlatBufferBuilder $builder
     * @param VectorOffset
     * @return void
     */
    public static function addUlongEntries(FlatBufferBuilder $builder, $ulongEntries)
    {
        $builder->addOffsetX(9, $ulongEntries, 0);
    }

    /**
     * @param FlatBufferBuilder $builder
     * @param array offset array
     * @return int vector offset
     */
    public static function createUlongEntriesVector(FlatBufferBuilder $builder, array $data)
    {
        $builder->startVector(4, count($data), 4);
        for ($i = count($data) - 1; $i >= 0; $i--) {
            $builder->addOffset($data[$i]);
        }
        return $builder->endVector();
    }

    /**
     * @param FlatBufferBuilder $builder
     * @param int $numElems
     * @return void
     */
    public static function startUlongEntriesVector(FlatBufferBuilder $builder, $numElems)
    {
        $builder->startVector(4, $numElems, 4);
    }

    /**
     * @param FlatBufferBuilder $builder
     * @param VectorOffset
     * @return void
     */
    public static function addDoubleEntries(FlatBufferBuilder $builder, $doubleEntries)
    {
        $builder->addOffsetX(10, $doubleEntries, 0);
    }

    /**
     * @param FlatBufferBuilder $builder
     * @param array offset array
     * @return int vector offset
     */
    public static function createDoubleEntriesVector(FlatBufferBuilder $builder, array $data)
    {
        $builder->startVector(4, count($data), 4);
        for ($i = count($data) - 1; $i >= 0; $i--) {
            $builder->addOffset($data[$i]);
        }
        return $builder->endVector();
    }

    /**
     * @param FlatBufferBuilder $builder
     * @param int $numElems
     * @return void
     */
    public static function startDoubleEntriesVector(FlatBufferBuilder $builder, $numElems)
    {
        $builder->startVector(4, $numElems, 4);
    }

    /**
     * @param FlatBufferBuilder $builder
     * @param VectorOffset
     * @return void
     */
    public static function addStringEntries(FlatBufferBuilder $builder, $stringEntries)
    {
        $builder->addOffsetX(11, $stringEntries, 0);
    }

    /**
     * @param FlatBufferBuilder $builder
     * @param array offset array
     * @return int vector offset
     */
    public static function createStringEntriesVector(FlatBufferBuilder $builder, array $data)
    {
        $builder->startVector(4, count($data), 4);
        for ($i = count($data) - 1; $i >= 0; $i--) {
            $builder->addOffset($data[$i]);
        }
        return $builder->endVector();
    }

    /**
     * @param FlatBufferBuilder $builder
     * @param int $numElems
     * @return void
     */
    public static function startStringEntriesVector(FlatBufferBuilder $builder, $numElems)
    {
        $builder->startVector(4, $numElems, 4);
    }

    /**
     * @param FlatBufferBuilder $builder
     * @return int table offset
     */
    public static function endMasterDict(FlatBufferBuilder $builder)
    {
        $o = $builder->endObject();
        return $o;
    }

    public static function finishMasterDictBuffer(FlatBufferBuilder $builder, $offset)
    {
        $builder->finish($offset, "FBMD");
    }
}