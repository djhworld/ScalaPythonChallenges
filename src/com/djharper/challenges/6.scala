import java.util.zip.{ZipFile}

object ChallengeSix extends Application {
  def processZip(startingValue:String, zipFileName:String) {
    val zip = new ZipFile(zipFileName)
    var collectedComments:List[String] = List[String]() //list to collect comments
    def traverse(inputText:String) {
      val regEx = """^[0-9]+$""".r
      val lastItem = inputText.split(" ").last.replaceAll(".txt","")

      regEx.findFirstIn(lastItem) match {
        case Some(v) =>
          println("Nothing = (" + lastItem + ")")
          val zipFileEntry = zip.getEntry(lastItem + ".txt")
          val fileComment = zipFileEntry.getComment
          val nextNothing = io.Source.fromInputStream(zip.getInputStream(zipFileEntry)).mkString
          collectedComments = fileComment :: collectedComments
          traverse(nextNothing)
        case None =>
          println("Finished, could not find any more nothings. Response text was:   \"" + inputText + "\"")
      }
    }
    traverse(startingValue)
    collectedComments.reverse.foreach { x => print(x) } // print out contents of list (collected comments)
  }
  processZip("90052.txt","files/inputs/channel.zip")
}
