package com.uce.board

import com.uce.board.Bitboard.Bitboard

object Constants {
  val fileA = new Bitboard(0x0101010101010101L)
  val fileH = new Bitboard(0x8080808080808080L)
  val rank1 = new Bitboard(0x00000000000000FFL)
  val rank8 = new Bitboard(0xFF00000000000000L)
  val lightSquares = new Bitboard(0x55AA55AA55AA55AAL)
  val darkSquares = new Bitboard(0xAA55AA55AA55AA55L)

  // Starting positions for pieces
  val wpInit = new Bitboard(0xFF000000000000L)
  val wrInit = new Bitboard(0x8100000000000000L)
  val wnInit = new Bitboard(0x4200000000000000L)
  val wbInit = new Bitboard(0x2400000000000000L)
  val wqInit = new Bitboard(0x1000000000000000L)
  val wkInit = new Bitboard(0x800000000000000L)

  val bpInit = new Bitboard(0xFF00L)
  val brInit = new Bitboard(0x81L)
  val bnInit = new Bitboard(0x42L)
  val bbInit = new Bitboard(0x24L)
  val bqInit = new Bitboard(0x10L)
  val bkInit = new Bitboard(0x8L)
}
