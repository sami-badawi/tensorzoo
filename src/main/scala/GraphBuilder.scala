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
import org.tensorflow.types.TFloat16
import org.tensorflow.types.family._
import org.tensorflow.GraphOperationBuilder

class GraphBuilder(val g: Graph) {

    def div[T <: TType](x: Output[T], y: Output[T]): Output[T] = {
      binaryOp("Div", x, y)
    }

    def div16(x: Output[TFloat16], y: Output[TFloat16]): Output[TFloat16] = {
      binaryOp("Div", x, y)
    }

    def sub[T <: TType](x: Output[T], y: Output[T]): Output[T] = {
      binaryOp("Sub", x, y)
    }

    // def constant[T](name: String, value: Any, typ: Class[T]): Output[T] = {
      // val t = Tensor.create[T](value, typ)
      // g.opBuilder("Const", name)
      //     .setAttr("dtype", DataType.fromClass(typ))
      //     .setAttr("value", t)
      //     .build()
      //     .output(0)
    //   null
    // }

    // def constant32(name: String, value: Float): Output[TFloat32] = {
    //   this.constant(name, value, classOf[Float])
    // }

    def binaryOp[T <: TType](typ: String, in1: Output[T], in2: Output[T]): Output[T] = {
      val builder: GraphOperationBuilder = g.opBuilder(typ, typ)
      val res = builder.addInput(in1).addInput(in2).build().output
      res.asInstanceOf[Output[T]]
      // null
    }
}
