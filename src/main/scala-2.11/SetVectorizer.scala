import org.apache.spark.annotation.DeveloperApi
import org.apache.spark.ml.Transformer
import org.apache.spark.ml.param.ParamMap
import org.apache.spark.sql.{DataFrame, Dataset}
import org.apache.spark.sql.types.StructType
import org.apache.spark.annotation.Since
/**
  * Created by gardneli on 10/1/16.
  */
@Since("2.0.0")
class SetVectorizer (@Since("1.4.0") override val uid: String) extends Transformer with NLPParams{

  override def transform(dataset: Dataset[_]): DataFrame = ???

  override def copy(extra: ParamMap): Transformer = ???

  @DeveloperApi
  override def transformSchema(schema: StructType): StructType = ???

}
