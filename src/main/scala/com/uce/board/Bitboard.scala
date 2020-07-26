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
     *
     * @author Kim Walisch (2012)
     * @return index (0..63) of least significant one bit, None if bitboard is empty
     */
    def bitScanForward: Option[Int] =
      if(value != 0) Some(index64((((value ^ (value - 1)) * debruijn64) >>> 58).toInt)) else None

    /**
     *
     * @return list with indices (0..63) of active bits
     */
    def serialize: List[Int] = bitScanForward match {
      case None => List.empty
      case Some(x) => x :: new Bitboard(value & (value - 1)).serialize
    }

    def prettyPrint() {
      val convertedBb = value.toBinaryString.toCharArray
      // toBinaryString omits leading zeroes
      val leadingZeroes = Array.fill[Char](64 - convertedBb.length)('0')
      val bb = leadingZeroes ++ convertedBb

      println(
        s"""
          |     a  b  c  d  e  f  g  e
          |
          | 8   ${bb(56)}  ${bb(57)}  ${bb(58)}  ${bb(59)}  ${bb(60)}  ${bb(61)}  ${bb(62)}  ${bb(63)}    8
          | 7   ${bb(48)}  ${bb(49)}  ${bb(50)}  ${bb(51)}  ${bb(52)}  ${bb(53)}  ${bb(54)}  ${bb(55)}    7
          | 6   ${bb(40)}  ${bb(41)}  ${bb(42)}  ${bb(43)}  ${bb(44)}  ${bb(45)}  ${bb(46)}  ${bb(47)}    6
          | 5   ${bb(32)}  ${bb(33)}  ${bb(34)}  ${bb(35)}  ${bb(36)}  ${bb(37)}  ${bb(38)}  ${bb(39)}    5
          | 4   ${bb(24)}  ${bb(25)}  ${bb(26)}  ${bb(27)}  ${bb(28)}  ${bb(29)}  ${bb(30)}  ${bb(31)}    4
          | 3   ${bb(16)}  ${bb(17)}  ${bb(18)}  ${bb(19)}  ${bb(20)}  ${bb(21)}  ${bb(22)}  ${bb(23)}    3
          | 2   ${bb(8 )}  ${bb(9 )}  ${bb(10)}  ${bb(11)}  ${bb(12)}  ${bb(13)}  ${bb(14)}  ${bb(15)}    2
          | 1   ${bb(0)}  ${bb(1)}  ${bb(2)}  ${bb(3)}  ${bb(4)}  ${bb(5)}  ${bb(6)}  ${bb(7)}    1
          |
          |     a  b  c  d  e  f  g  e
          |""".stripMargin
      )
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
