import java.net.URL
import org.apache.xmlrpc.client.{XmlRpcClient, XmlRpcClientConfigImpl}

object ChallengeThirteen extends Application {
  val url = new URL("http://www.pythonchallenge.com/pc/phonebook.php")
  val xmlrpcConfig = new XmlRpcClientConfigImpl
  xmlrpcConfig.setServerURL(url)
  val phone = new XmlRpcClient().execute(xmlrpcConfig, "phone", Array[AnyRef]("Bert"))
  println("Result = " + phone)
}

// vim: set ts=2 sw=2 et:
