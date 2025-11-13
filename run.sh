#!/bin/bash
# Compile and run Hadoop job
hadoop com.sun.tools.javac.Main src/moviereview/*.java
jar cf MovieReview.jar -C src/ .
hadoop fs -rm -r -f output || rm -rf output
hadoop jar MovieReview.jar moviereview.MovieReviewDriver input output
hdfs dfs -cat output/part-r-00000 || cat output/part-r-00000
