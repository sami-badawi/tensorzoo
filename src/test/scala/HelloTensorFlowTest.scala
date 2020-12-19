
import org.junit.Test
import org.junit.Assert._

class HelloTensorFlowTest {
  @Test def t1(): Unit = {
    assertEquals(20, HelloTensorFlow.doubleInt(10))
  }
}