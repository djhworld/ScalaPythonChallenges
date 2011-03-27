package com.djharper.challenges
import javax.imageio.{ImageIO}
import java.io.{File}

object ChallengeSeven extends Application with ScalaPythonChallenge {
    def isGreyScale(c: java.awt.Color) :Boolean = {
        if(c.getRed == c.getGreen && c.getRed == c.getBlue && c.getGreen == c.getBlue) {
            return true
        }
        false
    }

    def decodeFromColor(color :Int) :Option[Char] = {
        val c = new java.awt.Color(color)
            if(isGreyScale(c)) {
            return Some(c.getRed.toChar)
        }
        return None
    }


    def run() = {
        val image = ImageIO.read(new File("images/inputs/oxygen.png"))
        val subImage = image.getSubimage(0,43,608,9)
        val colorSamplePoints = scala.List.range(0, subImage.getWidth, 7)
        val result = colorSamplePoints.map { pointX => decodeFromColor( subImage.getRGB(pointX, 0) ).getOrElse(' ') }.mkString
        println("Result of analysis: " + result)
        val bracketsRegEx =  "(\\[.*?\\])".r
        val nextLevelStrArray = bracketsRegEx.findFirstIn(result).get.replaceAll("(\\[)|(\\])","").split(",")
        val answer = nextLevelStrArray.map { item => item.trim.toInt.toChar }
        println("Answer = " + answer.mkString)
    }
}

// vim: set ts=4 sw=4 et:
