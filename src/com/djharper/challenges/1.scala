package com.djharper.challenges
import math.pow

object ChallengeOne extends ScalaPythonChallenge {
  def run = println("Result of 2^38 = " + pow(2,38).toLong)
}
