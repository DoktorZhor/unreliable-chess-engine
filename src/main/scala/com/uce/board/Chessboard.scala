package com.uce.board

import com.uce.board.Bitboard.Bitboard
import com.uce.board.PieceType.PieceType

class Chessboard(val pieces: Map[PieceType, Bitboard]) {

  /**
   * Parameterless constructor used to initialise chessboard in starting position
   */
  def this() = {
    this(Map(
      PieceType.WP -> Constants.wpInit,
      PieceType.WR -> Constants.wrInit,
      PieceType.WN -> Constants.wnInit,
      PieceType.WB -> Constants.wbInit,
      PieceType.WQ -> Constants.wqInit,
      PieceType.WK -> Constants.wkInit,
      PieceType.BP -> Constants.bpInit,
      PieceType.BR -> Constants.brInit,
      PieceType.BN -> Constants.bnInit,
      PieceType.BB -> Constants.bbInit,
      PieceType.BQ -> Constants.bqInit,
      PieceType.BK -> Constants.bkInit
    ))

  }

  /**
   * Prints the chessboard to console in human readable format for debugging
   */
  def prettyPrint(): Unit = {
    val mergedBoard = pieces
      .map { case (k, v) => v.toBinaryArr.map(c => if(c == '1') k.toString else "00") }
      .toArray
      .transpose
      .flatMap(_.distinct.sorted.takeRight(1))

    printBoard(mergedBoard, 2)
  }
}
