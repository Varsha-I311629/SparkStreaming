package com.demovar.spark.streaming

object StreamingCounts {

  private def setupSparkContext(config: StreamingCountsConfig): StreamingContext = {
    val streamingSparkContext = {
      val sparkConf = new SparkConf().setAppname(config.appName)
    }
  }
}
