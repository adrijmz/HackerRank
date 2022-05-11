package ProblemSolving.Arrays;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'arrayManipulation' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. 2D_INTEGER_ARRAY queries
     */

    public static long arrayManipulation(int n, List<List<Integer>> queries) {
    // Write your code here
        List<Integer> myArr = new ArrayList<>(Collections.nCopies(n+1, 0));
        for(int i=0; i<queries.size(); i++){
            List<Integer> actualArr = queries.get(i);
            int a = actualArr.get(0);
            int b = actualArr.get(1);
            int k = actualArr.get(2);
            
            int aPreviousValue = myArr.get(a-1);
            int aNewValue = aPreviousValue + k;
            myArr.set(a-1, aNewValue);
            int bPreviousValue = myArr.get(b);
            int bNewValue = bPreviousValue - k;
            myArr.set(b, bNewValue);
        }
        System.out.println(myArr);
        long actualValue = 0;
        long maxValue = Integer.MIN_VALUE;
        for(int i=0; i<myArr.size()-1; i++) {
            actualValue+=myArr.get(i);
            if(actualValue>maxValue) maxValue = actualValue;
        }
        return maxValue;    
    }

}

public class ArrayManipulation {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<List<Integer>> queries = new ArrayList<>();

        IntStream.range(0, m).forEach(i -> {
            try {
                queries.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        long result = Result.arrayManipulation(n, queries);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
