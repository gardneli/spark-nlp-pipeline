import edu.emory.mathcs.nlp.decode.NLPDecoder
import org.apache.log4j.Logger
import org.apache.spark.sql.SparkSession

import scala.collection.JavaConverters._

object Main extends App {
  val logger = Logger.getLogger(getClass)
  val spark = SparkSession
    .builder()
    .appName("Spark SQL basic example")
    .config("spark.some.config.option", "some-value")
    .getOrCreate()
  import spark.implicits._
  println("Hi!")
  case class Person(uid: Long, name: String, age: Long)
  val configurationFile = "config-decode-en.xml"
  val str1 = "The quick Mr. Fox jumped over that lazy dog. What a crazy dog!"
  val str2 = "Mobile devices or client devices are quite maddening!  What in the world!"
  val decoder = new NLPDecoder(getClass.getResource(configurationFile).openStream())
  println("Done initializing.")

  val nodes = decoder.decodeDocument(str1).asScala
  println(nodes)
  nodes.foreach(node => println(decoder.toString(node)))

  val upper = new UpperTransformer
  val caseClassDS = Seq(Person(0L, "Andy", 32), Person(1L, "Jon", 50)).toDS()
  caseClassDS.show()
  upper.setInputCol("name").transform(caseClassDS).show
  //nodes.foreach(println(node => decoder.toString(node)))
  //val lemmas = nodes.map(_.getLemma)
  //lemmas.foreach(println)
  //val nodes2 = decoder.decode(str2)
  //println(decoder.toString(nodes2))


  //val tokenizer = new EnglishTokenizer
  //val tokens = tokenizer.segmentize(str1)
  //val joinedTokens = Joiner.join(tokens, " ")
  //println(tokens)
  //println(joinedTokens)
  //val configFile = "config-decode-en.xml"
  //val decoder = new NLPDecoder(IOUtils.createFileInputStream(configFile))
  //val tagged = decoder.decode(str1)
  //println(tagged)
}
