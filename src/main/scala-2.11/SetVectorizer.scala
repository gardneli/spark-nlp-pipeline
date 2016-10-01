import org.apache.spark.annotation.DeveloperApi
import org.apache.spark.ml.Transformer
import org.apache.spark.ml.param.ParamMap
import org.apache.spark.sql.{DataFrame, Dataset, Column}
import org.apache.spark.sql.types.{StructField, StructType}
import org.apache.spark.annotation.Since
import org.apache.spark.mllib.linalg.{VectorUDT, Vectors}
/**
  * Created by gardneli on 10/1/16.
  */

class SetVectorizer (override val uid: String) extends Transformer with NLPParams{

  val VT = new VectorUDT

  override def transform(dataset: Dataset[_], paramMap: ParamMap): DataFrame = {
    val (inCol, outCol, maxSize) = pvals(paramMap)

    dataset.withColumn(outCol, callUDF({ a: Seq[Int] =>
      Vectors.sparse(maxSize, a.toArray, Array.fill(a.size)(1.0))
    }, VT, dataset(inCol)))
  }

  override def copy(extra: ParamMap): Transformer = ???

  @DeveloperApi
  def transformSchema(schema: StructType, paramMap: ParamMap): StructType = {
    val outc = paramMap.get(outputCol).getOrElse("features")
    StructType(schema.fields ++ Seq(StructField(outc, VT, true)))
  }

}
