object ChallengeFour extends Application {
    val text = io.Source.fromURL("http://www.pythonchallenge.com/pc/def/equality.html").getLines.slice(22,1271).mkString
    val reg = "[^A-Z][A-Z]{3}([a-z])[A-Z]{3}[^A-Z]".r
    reg.findAllIn(text).foreach(arg => print(arg.charAt(4)))
    println
}

