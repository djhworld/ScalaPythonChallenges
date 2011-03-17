import sbt._

class ScalaPythonChallenges(info: ProjectInfo) extends DefaultProject(info)
{
  val dispatch = "net.databinder" %% "dispatch" % "0.7.8"
  val commonsio = "commons-io" % "commons-io" % "2.0.1"
}


// vim: set ts=2 sw=2 et:
