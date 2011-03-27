package com.djharper.challenges
object ScalaPythonChallenges {
  def main(args: Array[String]) {
    print("What challenge do you want to run? > ")
    val input = Console.readLine
    println
    input match {
      case "1" => ChallengeOne.run
      case "2" => ChallengeTwo.run
      case "3" => ChallengeThree.run
      case "4" => ChallengeFour.run
      case "5" => ChallengeFive.run
      case "6" => ChallengeSix.run
      case "7" => ChallengeSeven.run
      case "8" => ChallengeEight.run
      case "9" => ChallengeNine.run
      case "10" => ChallengeTen.run
      case "11" => ChallengeEleven.run
      case "12" => ChallengeTwelve.run
      case "13" => ChallengeThirteen.run
      case _ => println("Challenge not found")
    }

  }
}

// vim: set ts=2 sw=2 et:
