object ChallengeTwo extends Application {
  val textInput = "g fmnc wms bgblr rpylqjyrc gr zw fylb. rfyrq ufyr amknsrcpq ypc dmp. bmgle gr gl zw fylb gq glcddgagclr ylb rfyr'q ufw rfgq rcvr gq qm jmle. sqgle qrpgle.kyicrpylq() gq pcamkkclbcb. lmu ynnjw ml rfc spj."
  val cipher = ('a' to 'z').zip(('c' to 'z') ++ ('a' to 'b')).map { t => (t._1,t._2) }.toMap
  for(ch <- textInput.toCharArray) print(cipher.get(ch).getOrElse(' '))
    println
}

