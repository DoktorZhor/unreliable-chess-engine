package com.uce.test

import com.uce.board.Constants

object Main {
  def main(args: Array[String]): Unit = {
    Constants.fileA.prettyPrint()
    Constants.rank1.prettyPrint()
    Constants.darkSquares.prettyPrint()
  }
}
