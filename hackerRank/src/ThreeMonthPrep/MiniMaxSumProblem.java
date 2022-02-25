package ThreeMonthPrep;

import java.io.*;
import java.util.*;

class Result {

    /*
     * Complete the 'miniMaxSum' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void miniMaxSum(List<Integer> arr) {
    // Write your code here
    long minValue = Long.MAX_VALUE;
    long maxValue = Long.MIN_VALUE;
    long actual=0;

    for (Integer integer : arr) {
        minValue=Math.min(integer, minValue);
        maxValue=Math.max(integer, maxValue);
        actual+=integer;
    }
    System.out.println((actual-maxValue) + " " + (actual-minValue));

    }

}

public class MiniMaxSumProblem {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] arrTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            int arrItem = Integer.parseInt(arrTemp[i]);
            arr.add(arrItem);
        }

        Result.miniMaxSum(arr);

        bufferedReader.close();
    }
}
