import java.io.IOException
import java.io.PrintStream
import java.nio.charset.Charset
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import java.util.Arrays
import java.util.List
import org.tensorflow.DataType
import org.tensorflow.Graph
import org.tensorflow.Output
import org.tensorflow.Session
import org.tensorflow.Tensor
import org.tensorflow.TensorFlow
import org.tensorflow.types._
// import org.tensorflow.types.TUInt8

import collection.JavaConverters._

/** Port of TensorFlow Java example program
  * https://github.com/tensorflow/tensorflow/blob/master/tensorflow/java/src/main/java/org/tensorflow/examples/LabelImage.java
  */
object LabelImage {

  def printUsage(): Unit = {
    val url =
      "https://storage.googleapis.com/download.tensorflow.org/models/inception5h.zip"
    println(
      "Java program that uses a pre-trained Inception model (http://arxiv.org/abs/1512.00567)"
    )
    println("to label JPEG images.")
    println("TensorFlow version: " + TensorFlow.version())
    println()
    println("Usage: label_image <model dir> <image file>")
    println()
    println("Where:")
    println(
      "<model dir> is a directory containing the unzipped contents of the inception model"
    )
    println("            (from " + url + ")")
    println("<image file> is the path to a JPEG image file")
  }

  def maxIndex(probabilities: Array[Float]): Int = {
    probabilities.view.zipWithIndex.maxBy(pair => pair._1)._2
  }

  def readAllBytesOrExit(path: Path): Array[Byte] = {
    try {
      Files.readAllBytes(path)
    } catch {
      case e: Throwable => {
        System.err.println("Failed to read [" + path + "]: " + e.getMessage());
        System.exit(1)
        null
      }
    }
  }

  def readAllLinesOrExit(path: Path) = {
    try {
      Files.readAllLines(path, Charset.forName("UTF-8")).asScala
    } catch {
      case e => {
        System.err.println("Failed to read [" + path + "]: " + e.getMessage());
        System.exit(0);
        null
      }
    }
  }

  def main(args: Array[String]): Unit = {
    printUsage()
  }
}
