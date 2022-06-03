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
    
        Map<Integer,Integer> myMap = new HashMap<>(n+1);
        int aNewValue = 0;
        int bNewValue = 0;
        
        for(long i=0; i<queries.size(); i++){
            //for each query
            List<Integer> actualArr = queries.get((int)i);
            int a = actualArr.get(0);
            int b = actualArr.get(1);
            int k = actualArr.get(2);
            
            //if myMap already have that key
            if(myMap.containsKey(a)){
                aNewValue = myMap.get(a) + k;   
            }
            //if not
            else aNewValue = k;
            myMap.put(a, aNewValue);
            
            if(myMap.containsKey(b+1)){
                bNewValue = myMap.get(b+1) - k;   
            }
            else bNewValue = -k;
            myMap.put(b+1, bNewValue);
        }     
        return getMaxSum(myMap); 
    }
    
    private static long getMaxSum(Map<Integer,Integer> myMap){
        /*
            5 3
            1 2 100
            2 5 100
            3 4 100
            
            [1=100, 2=100, 3=0, 5=-100, 6=-100]
            
            100 <- maxSum
            100+100 = 200 <- maxSum
            100+100-100 = 100
            100+100-100-100 = 0
        */
        long actualSum = 0;
        long maxSum = Integer.MIN_VALUE;
        System.out.println(myMap.toString());
        for(int i=1; i<=myMap.size(); i++){
            if(myMap.containsKey(i)){
                actualSum += myMap.get(i);
                if(actualSum>maxSum) maxSum = actualSum;
            }
        }
        return maxSum;
    }

}

public class ArrayManipulation2 {
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
