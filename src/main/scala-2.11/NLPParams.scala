import org.apache.spark.ml.param.{Params, Param, IntParam, ParamMap}

/**
  * Created by gardneli on 10/1/16.
  */
trait NLPParams extends Params{
  val inputCol = new Param[String](this, "inputCol", "input column")
  val outputCol = new Param[String](this, "outputCol", "output column")
  val vecSize = new IntParam(this, "vecSize", "maximum sparse vector size")

  def pvals(paramMap: ParamMap) = (
    // this code can be cleaner in versions of Spark after 1.3
    paramMap.get(inputCol).getOrElse("topicSet"),
    paramMap.get(outputCol).getOrElse("features"),
    paramMap.get(vecSize).getOrElse(128)
    )
}
