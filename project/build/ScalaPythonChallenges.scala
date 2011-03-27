import sbt._

class ScalaPythonChallenges(info: ProjectInfo) extends DefaultProject(info)
{
  val commonsio = "commons-io" % "commons-io" % "2.0.1"
  val xmlrpc = "org.apache.xmlrpc" % "xmlrpc-client" % "3.1.3"
  val scalatest ="org.scalatest" % "scalatest" % "1.3"
  override def mainScalaSourcePath = "src"
  override def testScalaSourcePath = mainScalaSourcePath / "test"
}


// vim: set ts=2 sw=2 et:
