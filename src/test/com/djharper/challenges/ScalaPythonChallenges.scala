import com.djharper.challenges._
import org.scalatest.FunSuite

class ScalaPythonChallenges extends FunSuite {

  def skip = println("\nskipped")

  test("Challenge 1") {
    ChallengeOne.run
  }

  test("Challenge 2") {
    ChallengeTwo.run
  }

  test("Challenge 3") {
    ChallengeThree.run
  }

  test("Challenge 4") {
    ChallengeFour.run
  }

  test("Challenge 5") {
//    print("Do you want to run this test? [y/n]")
//    val answer = io.Source.stdin
//    answer.next match {
//      case 'y' => ChallengeFive.run
//      case 'n' => skip
//      case _ => skip
//    }
  }

  test("Challenge 6") {
    ChallengeSix.run
  }

  test("Challenge 7") {
    ChallengeSeven.run
  }

  test("Challenge 8") {
    ChallengeEight.run
  }

  test("Challenge 9") {
    ChallengeNine.run
  }

  test("Challenge 10") {
    ChallengeTen.run
  }

  test("Challenge 11") {
    ChallengeEleven.run
  }

  test("Challenge 12") {
    ChallengeEleven.run
  }

  test("Challenge 13") {
    ChallengeThirteen.run
  }
}
//import co.uk.djharper.urlify._
//
//class UrlifyTest extends FunSuite {
//  test("Should return bit ly object") {
//    val url = "http://bit.ly/abc123"
//    val item = Urlify(url)
//    assert(item != None)
//    assert(item.get == BitLyUrl(url))
//  }
//
//  test("Should return None if input unknown") {
//    val url= "http://m.au/123"
//    val item = Urlify(url)
//    assert(item == None)
//  }
//
//}
//
//// vim: set ts=2 sw=2 et:
