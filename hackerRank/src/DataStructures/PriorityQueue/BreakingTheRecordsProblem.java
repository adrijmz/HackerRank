package DataStructures.PriorityQueue;

import java.io.*;
import java.math.*;
import java.security.*;
import java.security.spec.ECField;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'breakingRecords' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY scores as parameter.
     */

    public static List<Integer> breakingRecords(List<Integer> scores) {
    // Write your code here
    int minValue=Integer.MAX_VALUE;
    int maxValue=Integer.MIN_VALUE;
    int leastCounter=-1;
    int mostCounter=-1;
    for (Integer integer : scores) {
        if(integer<minValue){
            minValue=integer;
            leastCounter++;    
        }
        if(integer>maxValue){
            maxValue=integer;
            mostCounter++;    
        }
    }
    List<Integer> res = new ArrayList<>();
    res.add(mostCounter);
    res.add(leastCounter);
    return res;
    }

}

public class BreakingTheRecordsProblem {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String[] scoresTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> scores = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int scoresItem = Integer.parseInt(scoresTemp[i]);
            scores.add(scoresItem);
        }

        List<Integer> result = Result.breakingRecords(scores);

        for (int i = 0; i < result.size(); i++) {
            bufferedWriter.write(String.valueOf(result.get(i)));

            if (i != result.size() - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
