package com.uce.board

import com.uce.board.Bitboard.Bitboard

object Constants {
  val fileA = new Bitboard(0x0101010101010101L)
  val fileH = new Bitboard(0x8080808080808080L)
  val rank1 = new Bitboard(0x00000000000000FFL)
  val rank8 = new Bitboard(0xFF00000000000000L)
  val lightSquares = new Bitboard(0x55AA55AA55AA55AAL)
  val darkSquares = new Bitboard(0xAA55AA55AA55AA55L)
}
