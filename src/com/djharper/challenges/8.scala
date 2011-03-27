package com.djharper.challenges
import java.io.{ByteArrayInputStream}
import org.apache.tools.bzip2.{CBZip2InputStream}
import org.apache.commons.io.{IOUtils}

object ChallengeEight extends ScalaPythonChallenge {

  def bunzip2(inputStr: String) :String = {
    val is = new ByteArrayInputStream( inputStr.getBytes("ISO-8859-1") ) //convert string to inputstream and skip first 2 bytes
    is.skip(2) //skip first two bytes
    val bzipInputStream = new CBZip2InputStream(is)
    IOUtils.toString(bzipInputStream, "UTF-8");
  }

  def run() = {
    val inputs = Map( 'username -> "BZh91AY&SYA\u00af\u0082\r\u0000\u0000\u0001\u0001\u0080\u0002\u00c0\u0002\u0000 \u0000!\u009ah3M\u0007<]\u00c9\u0014\u00e1BA\u0006\u00be\u00084",
                      'password -> "BZh91AY&SY\u0094$|\u000e\u0000\u0000\u0000\u0081\u0000\u0003$ \u0000!\u009ah3M\u0013<]\u00c9\u0014\u00e1BBP\u0091\u00f08")
    inputs.foreach { x => println(x._1.name + " -> " + bunzip2(x._2)) }
  }
}
