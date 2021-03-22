package com.demovar.spark.streaming

import storage.BucketingStrategy

import java.text.SimpleDateFormat
import java.util.Date

import org.json4s._
import org.json4s.jackson.JsonMethods._


object SimpleEvent {
  private val format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")

  def convertStringToDate(dateString: String):Date = format.parse(dateString)

  def fromJson(byteArray: Array[Byte]): SimpleEvent = {
    implicit val formats = DefaultFormats
    val newString = new String(byteArray, "UTF-8")
    val parsed = parse(newString)
    parsed.extract[SimpleEvent]
  }

}

/**
 * Simple Class demonstrating an EventType log consisting of:
 *   1. ISO 8601 DateTime Object that will be downsampled
 *      (see BucketingStrategy.scala file for more details)
 *   2. A simple model of colors for this EventType:
 *      'Red','Orange','Yellow','Green', or 'Blue'
 *   example log: {"timestamp": "2015-06-05T13:00:22.540374", "type": "Orange", "id": "018dd633-f4c3-4599-9b44-ebf71a1c519f"}
 */
case class SimpleEvent(id: String, timestamp: String, `type`:String){
  // Convert timestamp into Time Bucket using Bucketing Strategy
  val bucket = BucketingStrategy.bucket(SimpleEvent.convertStringToDate(timestamp))
}
