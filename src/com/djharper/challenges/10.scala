package com.djharper.challenges
object ChallengeTen extends ScalaPythonChallenge {
  @annotation.tailrec
  private def groupIntoChunks(input: String, result: List[String] = Nil): List[String] = {
    if(input.size == 0) {
      result.reverse
    }
    else {
      val (leftChunk, rightRemaining) = input.span(_ == input(0))
      groupIntoChunks(rightRemaining, leftChunk :: result)
    }
  }

  def describe(str: String): String = {
    str.length + "" + str.head
  }

  @annotation.tailrec
  def execute(input: String, counter: Int) :String = {
    counter match {
      case 0 => input
      case _ => execute(groupIntoChunks(input).map { describe }.mkString, counter - 1)
    }
  }

  def run() = {
    val startingVal = "1"
    val numberOfTimes = 30
    val result = execute(startingVal, numberOfTimes)
    println("a[" + numberOfTimes + "] length = " + result.length)
  }
}
