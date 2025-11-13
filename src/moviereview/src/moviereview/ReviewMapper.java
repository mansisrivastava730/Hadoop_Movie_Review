package moviereview;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class ReviewMapper extends Mapper<LongWritable, Text, Text, IntWritable> {
    private static final List<String> positiveWords = Arrays.asList("good","great","fantastic","amazing","wonderful","love","loved","excellent");
    private static final List<String> negativeWords = Arrays.asList("bad","boring","terrible","poor","dull","weak","predictable","worst");
    private Text category = new Text();
    private final static IntWritable one = new IntWritable(1);

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String review = value.toString().toLowerCase();
        int posCount = 0, negCount = 0;

        for (String word : review.split("\\s+")) {
            if (positiveWords.contains(word)) posCount++;
            if (negativeWords.contains(word)) negCount++;
        }

        if (posCount > negCount) category.set("Positive");
        else if (negCount > posCount) category.set("Negative");
        else category.set("Neutral");

        context.write(category, one);
    }
}
