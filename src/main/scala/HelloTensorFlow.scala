import org.tensorflow.ConcreteFunction
import org.tensorflow.Signature
import org.tensorflow.Tensor
import org.tensorflow.TensorFlow
import org.tensorflow.op.Ops
import org.tensorflow.op.core.Placeholder
import org.tensorflow.op.math.Add
import org.tensorflow.types.TInt32


/**
 * This is a port of a Hello World app for TensorFlow
 * https://www.tensorflow.org/install/lang_java
 */
object HelloTensorFlow {

  def doublerInt32Tensor(tf: Ops): Signature = {
    val x = tf.placeholder(TInt32.DTYPE).asInstanceOf[Placeholder[TInt32]]
    val dblX = tf.math.add(x, x)
    Signature.builder().input("x", x).output("dbl", dblX).build()
  }

  /**
   * Take input as Int and create a tensor that is a scalar of type Int32
   */
  def doubleInt(input: Int): Int = {
    val dbl = ConcreteFunction.create(doublerInt32Tensor)
    val x = TInt32.scalarOf(10)
    val xInt = x.getInt()
    val dblX = dbl.call(x)
    dblX.asInstanceOf[TInt32].getInt()
  }

  def main(args: Array[String]): Unit = {
    println("Hello TensorFlow " + TensorFlow.version())
    val dbl = ConcreteFunction.create(doublerInt32Tensor)
    val x = 10
    val x2 = doubleInt(x)
    println(s"x: ${x}, doubled is ${x2}")
  }
}
