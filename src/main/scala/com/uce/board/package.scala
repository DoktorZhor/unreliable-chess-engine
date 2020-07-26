package com.uce

package object board {

  /**
   * Prints provided array as chessboard to console. Assumes each array element has the same length, otherwise
   * the result might be skewed.
   * @param b array representing the board
   * @param squareLength number of characters in each element, used to adjust file notation
   */
  def printBoard(b: Array[String], squareLength: Int = 1): Unit = {

    val f: Array[String] = Array("a", "b", "c", "d", "e", "f", "g", "h").map(_.padTo(squareLength, ' '))

    println(
      s"""
         |     ${f(0)}  ${f(1)}  ${f(2)}  ${f(3)}  ${f(4)}  ${f(5)}  ${f(6)}  ${f(7)}
         |
         | 8   ${b(56)}  ${b(57)}  ${b(58)}  ${b(59)}  ${b(60)}  ${b(61)}  ${b(62)}  ${b(63)}    8
         | 7   ${b(48)}  ${b(49)}  ${b(50)}  ${b(51)}  ${b(52)}  ${b(53)}  ${b(54)}  ${b(55)}    7
         | 6   ${b(40)}  ${b(41)}  ${b(42)}  ${b(43)}  ${b(44)}  ${b(45)}  ${b(46)}  ${b(47)}    6
         | 5   ${b(32)}  ${b(33)}  ${b(34)}  ${b(35)}  ${b(36)}  ${b(37)}  ${b(38)}  ${b(39)}    5
         | 4   ${b(24)}  ${b(25)}  ${b(26)}  ${b(27)}  ${b(28)}  ${b(29)}  ${b(30)}  ${b(31)}    4
         | 3   ${b(16)}  ${b(17)}  ${b(18)}  ${b(19)}  ${b(20)}  ${b(21)}  ${b(22)}  ${b(23)}    3
         | 2   ${b(8 )}  ${b(9 )}  ${b(10)}  ${b(11)}  ${b(12)}  ${b(13)}  ${b(14)}  ${b(15)}    2
         | 1   ${b(0)}  ${b(1)}  ${b(2)}  ${b(3)}  ${b(4)}  ${b(5)}  ${b(6)}  ${b(7)}    1
         |
         |     ${f(0)}  ${f(1)}  ${f(2)}  ${f(3)}  ${f(4)}  ${f(5)}  ${f(6)}  ${f(7)}
         |""".stripMargin
    )
  }
}
