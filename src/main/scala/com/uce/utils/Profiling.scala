package com.uce.utils

object Profiling {

  /**
   * Measures run time of profiled function in nanoseconds
   * @param block function to profile
   * @return return value of wrapped function
   */
  def timed[R](block: => R): R = {
    val t0 = System.nanoTime()
    val result = block
    val t1 = System.nanoTime()
    println(s"Elapsed time: ${t1 - t0}ns")
    result
  }

  /**
   * Executes profiled function n times and prints elapsed time in nanoseconds
   * @param noRepeats how many times should profiled function be executed
   * @param block function to profile
   */
  def timedRepeat[R](noRepeats: Int, block: => R): Unit = {
    val t0 = System.nanoTime()
    1 to noRepeats foreach { _ => block }
    val t1 = System.nanoTime()
    println(s"Elapsed time: ${t1 - t0}ns")
  }
}
