package com.djharper.challenges
import math.pow

object ChallengeOne extends Application with ScalaPythonChallenge {
  def run = println("Result of 2^38 = " + pow(2,38).toLong)
}
