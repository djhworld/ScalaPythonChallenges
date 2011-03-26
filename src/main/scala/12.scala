import scala.collection.mutable.ArrayBuffer
import org.apache.commons.io.{IOUtils,FileUtils}

object ChallengeTwelve extends Application {
  /* Take items at every step of a collection
  so for example slicestep([1,2,3,4,5,6],0,2) would
  return [1,3,5] */
  def slicestep[T](input: IndexedSeq[T], start: Int, step: Int) = for(dataIndex <- (start to input.size-1 by step)) yield input(dataIndex)

  def readBytesFromFile(fileName: String) :Array[Byte] = {
    println("Reading " + fileName + " into byte array")
    FileUtils.readFileToByteArray(new java.io.File(fileName))
  }

  def write(dataArr: Array[Array[Byte]], location: String, prefix:String = "") = {
    for(data <- dataArr) {
      val file = new java.io.File(location + "/" + prefix + dataArr.indexOf(data).toString + ".dat")
      println("Writing: " + file)
      IOUtils.write(data, new java.io.FileOutputStream(file))
    }
  }

  /* Take an array of bytes and unshuffle them according to a given step. For example
  unshuffle([0,1,0,1,0,1],2) would return [[0,0,0],[1,1,1]] */
  def unshuffle(input: Array[Byte], step: Int) :Array[Array[Byte]] = {
    val unshuffled = new ArrayBuffer[Array[Byte]]
    for(i <- (0 until step)) unshuffled += slicestep(input, i, step).toArray
    println("Unshuffled pile into " + unshuffled.size + " piles")
    unshuffled.toArray
  }

  val file = readBytesFromFile("files/inputs/evil2.gfx")
  write(unshuffle(file, 5), "images/outputs", "Challenge12-")
  println("Done!")

}
