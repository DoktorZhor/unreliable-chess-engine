package com.uce.test

import com.uce.board.{Chessboard, Constants, PieceType}
import com.uce.board.PieceType.PieceType
import com.uce.utils.Profiling

object Main {
  def main(args: Array[String]): Unit = {

    val z = new Chessboard()
    z.prettyPrint()

    println("toBinaryArr:")
    Profiling.timedRepeat(1000000, Constants.darkSquares.toBinaryArr)

    val x: PieceType = PieceType.WP
    println(x)

    Constants.fileA.prettyPrint()
    Constants.rank1.prettyPrint()
    Constants.darkSquares.prettyPrint()
  }
}
