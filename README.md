# spark-kinesis-integration

## Introduction
This is a simple time series analysis stream processing job written in Scala for the spark-streaming cluster computing platform, processing JSON events from [Amazon Kinesis] kinesis and writing aggregates to [Amazon DynamoDB] dynamodb.

## Overview
This is implemention of a super-simple analytics-on-write stream processing job using Spark Streaming. Our Spark Streaming job reads a Kinesis stream containing events in a JSON format:


```json
{
  "timestamp": "2015-06-05T12:54:43.064528",
  "type": "Green",
  "id": "4ec80fb1-0963-4e35-8f54-ce760499d974"
}
```

The job counts the events by type and aggregates these counts into 1 minute buckets. The job then takes these aggregates and saves them into a table in DynamoDB

## AWS Kinesis

```bash
$ inv describe_kinesis_stream default my-stream
{
    "StreamDescription": {
        "StreamStatus": "ACTIVE",
        "StreamName": "my-stream",
        "StreamARN": "arn:aws:kinesis:us-east-1:719197435995:stream/my-stream",
        "Shards": [
            {
                "ShardId": "shardId-000000000000",
                "HashKeyRange": {
                    "EndingHashKey": "340282366920938463463374607431768211455",
                    "StartingHashKey": "0"
                },
                "SequenceNumberRange": {
                    "StartingSequenceNumber": "49551350243544458458477304430170758137221526998466166786"
                }
            }
        ]
    }
}
```


## Vagrant
```bash
 host$ vagrant up && vagrant ssh
guest$ cd /vagrant
guest$ sbt compile
```


## BUILD

```bash
$ inv build_spark
...
[INFO] Spark Kinesis Integration ......................... SUCCESS [1:11.115s]
...
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 1:29:00.686s
[INFO] Finished at: Sun Jun 07 00:32:09 UTC 2015
[INFO] Final Memory: 94M/665M
[INFO] ------------------------------------------------------------------------
```

