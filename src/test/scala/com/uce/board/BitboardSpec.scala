package com.uce.board

import com.uce.board.Bitboard.Bitboard
import org.scalatest.flatspec.AnyFlatSpec

class BitboardSpec extends AnyFlatSpec {

  "Forward bitScan" should "return None for empty bitboard" in {
    assert(new Bitboard(0L).bitScanForward === None)
  }

  "Forward bitScan" should "return indices of LS1b" in {
    assert(Constants.fileA.bitScanForward === Some(0))
    assert(Constants.fileH.bitScanForward === Some(7))
    assert(Constants.rank1.bitScanForward === Some(0))
    assert(Constants.rank8.bitScanForward === Some(56))
    assert(Constants.lightSquares.bitScanForward === Some(1))
    assert(Constants.darkSquares.bitScanForward === Some(0))
  }

  "Bitboard serialization" should "return list with indices of active bits" in {
    assert(new Bitboard(0L).serialize === List.empty)
    assert(Constants.fileA.serialize === List(0, 8, 16, 24, 32, 40, 48, 56))
    assert(Constants.fileH.serialize === List(7, 15, 23, 31, 39, 47, 55, 63))
    assert(Constants.rank1.serialize === List(0, 1, 2, 3, 4, 5, 6, 7))
    assert(Constants.rank8.serialize === List(56, 57, 58, 59, 60, 61, 62, 63))
  }

  "Conversion to binary array" should "always add leading zeros to total length of 64 elements" in {
    // Since toBinaryString omits leading zeros, we first check that padding is required
    assert(Constants.fileA.value.toBinaryString.length != 64)
    assert(Constants.rank1.value.toBinaryString.length != 64)
    assert(Constants.lightSquares.value.toBinaryString.length != 64)
    // Then we check that arrays are padded to correct length
    assert(Constants.fileA.toBinaryArr.length === 64)
    assert(Constants.rank1.toBinaryArr.length === 64)
    assert(Constants.lightSquares.toBinaryArr.length === 64)
  }

}
