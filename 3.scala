object ChallengeThree extends Application {
  val reg = "[a-zA-Z]".r
  val text = scala.io.Source.fromURL("http://www.pythonchallenge.com/pc/def/ocr.html").getLines.slice(38,1259).mkString
  println(reg.findAllIn(text).mkString)
}
