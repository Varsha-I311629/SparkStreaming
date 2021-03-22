package com.demovar.spark.streaming

import com.amazonaws.services.kinesis.clientlibrary.lib.worker.InitialPositionInStream
import org.apache.spark.storage.StrorageLevel
import org.apache.spark.streaming.Duration

case class StreamingCountsConfig (
      region: String,
      streamName:         String,
      checkpointInterval: Duration,
      initialPosition:    InitialPositionInStream,
      storageLevel:       StorageLevel,
      appName:            String,
      master:             String,
      batchInterval:      Duration,
      tableName:          String,
      awsProfile:         String

) {

  /**
   * The Kinesis endpoint from the region.
   */
  val endpointUrl = s"https://kinesis.${region}.amazonaws.com"

}
