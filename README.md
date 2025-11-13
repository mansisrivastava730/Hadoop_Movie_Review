# Hadoop_Movie_Review

A simple Hadoop MapReduce project that classifies movie reviews as **Positive**, **Negative**, or **Neutral**.

---

## 🧠 How It Works

1. Each line in `input/reviews.txt` is treated as one movie review.
2. The **Mapper** counts positive/negative words.
3. The **Reducer** sums up results by sentiment category.

---

## 🗂 Folder Structure

Hadoop-MovieReview-Analysis/
├── input/
│ └── reviews.txt
├── src/moviereview/
│ ├── ReviewMapper.java
│ ├── ReviewReducer.java
│ └── MovieReviewDriver.java
├── run.sh
└── README.md



Expected output:
Positive    4
Negative    2
Neutral     0

🧰 Technologies Used

Hadoop 3.x

Java 8+

MapReduce
HDFS

Author
Made by Mansi
