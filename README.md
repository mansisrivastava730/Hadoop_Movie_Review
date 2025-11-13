# Hadoop_Movie_Review
Project Overview

The Hadoop Movie Review Analysis project demonstrates how to use Hadoop MapReduce to perform sentiment analysis on textual data.
It classifies each movie review as Positive, Negative, or Neutral based on the occurrence of predefined sentiment words.

This project is a beginner-friendly demonstration of:

Reading and processing large text data using HDFS

Implementing the Mapper and Reducer phases in Java

Running and managing MapReduce jobs on Hadoop

It helps understand how data is distributed, processed, and aggregated across multiple nodes in a big data environment.

⚙️ Workflow / Architecture

The workflow of this Hadoop MapReduce program can be summarized in five main steps:

🧩 1. Input Stage

Input data is stored in the input/reviews.txt file.

Each line of the file represents a movie review.

Example:

The movie was fantastic and full of suspense
It was a boring movie

🗺️ 2. Mapper Phase (ReviewMapper.java)

The Mapper reads each review line by line.

It checks each word against two lists:

Positive words list (e.g., good, fantastic, wonderful, amazing…)

Negative words list (e.g., bad, boring, terrible, dull…)

It counts the number of positive and negative words.

Then emits one of the following key-value pairs:

Key (Text)	Value (IntWritable)
Positive	1
Negative	1
Neutral	1

Example:
Input: The movie was fantastic and amazing
Mapper Output: (Positive, 1)

🧮 3. Shuffle and Sort Phase

Hadoop automatically groups all identical keys from different Mappers together.

For example, all (Positive, 1) pairs go to one Reducer.

This phase ensures that all values for a single sentiment are processed by the same Reducer.

🧾 4. Reducer Phase (ReviewReducer.java)

The Reducer receives grouped keys and their list of values.

It sums all the values for each sentiment category.

Example Input to Reducer:

Positive → [1, 1, 1, 1]
Negative → [1, 1]
Neutral → []


Reducer Output:

Positive    4
Negative    2
Neutral     0

📤 5. Output Stage

The final sentiment counts are written to the Hadoop output folder (output/).

You can view the result using:

hdfs dfs -cat output/part-r-00000
cat output/part-r-00000
