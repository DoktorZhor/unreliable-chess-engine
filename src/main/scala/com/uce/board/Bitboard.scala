package com.uce.board

object Bitboard {

  /**
   * This bitboard representation uses LERF (little endian rank-file) mapping:
   *
   *        a   b   c   d   e   f   g   e
   *
   *    8   56  57  58  59  60  61  62  63    8
   *    7   48  49  50  51  52  53  54  55    7
   *    6   40  41  42  43  44  45  46  47    6
   *    5   32  33  34  35  36  37  38  39    5
   *    4   24  25  26  27  28  29  30  31    4
   *    3   16  17  18  19  20  21  22  23    3
   *    2   8   9   10  11  12  13  14  15    2
   *    1   0   1   2   3   4   5   6   7     1
   *
   *        a   b   c   d   e   f   g   e
   *
   * @param value Long value representing the board
   */
  implicit class Bitboard(val value: Long) extends AnyVal {

    /**
     * Finds ls1b and returns it's index
     * @author Kim Walisch (2012)
     * @return index (0..63) of least significant one bit, None if bitboard is empty
     */
    def bitScanForward: Option[Int] =
      if(value != 0) Some(index64((((value ^ (value - 1)) * debruijn64) >>> 58).toInt)) else None

    /**
     * Creates list with indices of all active bits in bitboard
     * @return list with indices (0..63)
     */
    def serialize: List[Int] = bitScanForward match {
      case None => List.empty
      case Some(x) => x :: new Bitboard(value & (value - 1)).serialize
    }

    /**
     * Converts bitboard to array of characters. Unlike Scala's *toBinaryString* method,
     * which omits leading zeros, this method ensures resulting array contains all 64 bits.
     * @return bitboard as array with bits represented by characters '0' and '1'
     */
    def toBinaryArr: Array[Char] = {
      val convertedBB = value.toBinaryString.toCharArray
      val noMissingChars = 64 - convertedBB.length
      val leadingZeros = Array.fill[Char](noMissingChars)('0')
      leadingZeros ++ convertedBB
    }

    /**
     * Prints bitboard to console in human readable format
     */
    def prettyPrint(): Unit = {
      val bb = value.toBinaryArr.map(_.toString)

      printBoard(bb)
    }
  }

  // constants for bitScan

  val index64: Array[Int] = Array(
    0, 47,  1, 56, 48, 27,  2, 60,
    57, 49, 41, 37, 28, 16,  3, 61,
    54, 58, 35, 52, 50, 42, 21, 44,
    38, 32, 29, 23, 17, 11,  4, 62,
    46, 55, 26, 59, 40, 36, 15, 53,
    34, 51, 20, 43, 31, 22, 10, 45,
    25, 39, 14, 33, 19, 30,  9, 24,
    13, 18,  8, 12,  7,  6,  5, 63
  )

  val debruijn64: Long = 0x03f79d71b4cb0a89L

}
