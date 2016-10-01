name := "SparkNLPPipeline"

version := "1.0"

scalaVersion := "2.11.8"

fork in run := true

// Note - the NLP4J library is a crazy memory hog - note 6G heap size below
javaOptions in run ++= Seq("-Xms256M", "-Xmx6G", "-XX:+UseConcMarkSweepGC")

libraryDependencies += "org.apache.spark" %% "spark-core" % "2.0.0"

libraryDependencies += "org.apache.spark" % "spark-mllib_2.11" % "2.0.0"

libraryDependencies += "edu.emory.mathcs.nlp" % "nlp4j-english" % "1.1.3"

libraryDependencies += "edu.emory.mathcs.nlp" % "nlp4j-api" % "1.1.3"

libraryDependencies += "org.slf4j" % "slf4j-log4j12" % "1.7.21"

libraryDependencies += "org.apache.logging.log4j" % "log4j-core" % "2.6.2"
    