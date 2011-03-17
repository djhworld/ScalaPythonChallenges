object ChallengeFive extends Application {

  def traverse(inputText:String) :String = {
    val regEx = """^[0-9]+$""".r
    val lastItem = inputText.split(" ").last
    regEx.findFirstIn(lastItem) match {
      case Some(v) =>
        println("Nothing = (" + lastItem + ")")
        Thread.sleep(500)
        traverse(io.Source.fromURL("http://www.pythonchallenge.com/pc/def/linkedlist.php?nothing=" + lastItem).mkString)
      case None =>
        "Finished, could not find any more nothings. Response text was:   \"" + inputText + "\""
    }
  }
  traverse("12345")
}
