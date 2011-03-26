import javax.imageio.ImageIO
import java.io.File
import java.awt.image.BufferedImage

object ChallengeEleven extends Application {
  def even = { x:Int => x % 2 == 0 }
  def odd = { x:Int => x % 2 != 0 }


  /* Take items at every step of a collection
  so for example slicestep([1,2,3,4,5,6],0,2) would
  return [1,3,5] */
  def slicestep[T](input: IndexedSeq[T], start: Int, step: Int) = for(dataIndex <- (start to input.size-1 by step)) yield input(dataIndex)

  /* take all items in 'even' positions */
  def evenItems[T](input: IndexedSeq[T]) = slicestep(input, 0, 2)

  /* take all items in 'odd' positions */
  def oddItems[T](input: IndexedSeq[T]) = slicestep(input, 1, 2)

  def getRow(image: BufferedImage, y: Int): Array[Int] = (for(x <- 0 until image.getWidth) yield image.getRGB(x, y)).toArray

  /* Convert image into a list of arrays. Each array represents a row of the image, containing the colours of each pixel */
  @annotation.tailrec
  def explodeImage(image :BufferedImage, row: Int, imageColours :List[Array[Int]] = List()) :List[Array[Int]] = {
    row match {
      case 0                                => imageColours
      case r:Int if(row < 0)                => imageColours
      case r:Int if(row > image.getHeight)  => imageColours
      case r:Int if(row == image.getHeight) => explodeImage(image, row - 2, getRow(image, row - 1) :: imageColours)
      case r:Int                            => explodeImage(image, row - 1, getRow(image, row) :: imageColours)
    }
  }


  /* Construct a new image based on an input */
  def buildImage(colours :List[Array[Int]]) = {
    val width = colours.head.size
    val height = colours.size
    val newImage = new  BufferedImage(width, height, BufferedImage.TYPE_INT_RGB )
    colours.foreach { row => newImage.setRGB(0, colours.indexOf(row), row.size, 1, row, 0, 0)}
    newImage
  }

  def readImage(filename :String) :BufferedImage = {
    println("Reading " + filename);
    ImageIO.read(new File(filename))
  }

  def writeImage(filename: String, format: String, image: BufferedImage) :Unit = {
    println("Writing " + filename);
    ImageIO.write(image, format, new File(filename))
  }

  def getEvenOrOddPixelsBasedOnRow(row: Array[Int], y: Int) :Array[Int] = {
    y match {
      case i:Int if(even(i)) => oddItems(row).toArray
      case o:Int if(odd(o)) => evenItems(row).toArray
    }
  }

  def solve(inputFilename: String, outputFilename: String) = {
    val image = readImage(inputFilename)
    val explodedImage = explodeImage(image, image.getHeight)
    val filteredColours = explodedImage.map { row => getEvenOrOddPixelsBasedOnRow(row, explodedImage.indexOf(row)) }
    writeImage(outputFilename, "jpg", buildImage(filteredColours))
  }
  solve("images/cave.jpg", "images/challenge11-result.jpg")
}
