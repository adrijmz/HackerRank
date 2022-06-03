package ProblemSolving.OneWeekPreparation;

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
     * Complete the 'superDigit' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. STRING n
     *  2. INTEGER k
     */

    public static int superDigit(String n, int k) {
    // Write your code here
        
        long sum = calculateSum(n,k);
                
        String res = auxFunction(sum);
        
        return Integer.parseInt(res);
        
    }
    
    private static long calculateSum(String n, int k){
        long sum = 0;
        String[] nSplit = n.split("");
        for(String data : nSplit){
            sum+=Integer.parseInt(data);
        }
        //
        sum *= k;
        return sum;
    }
    
    public static String auxFunction(long sum){
        
        String sumToStr = sum+"";
        if(sumToStr.length()==1){
            return sumToStr;
        }
        long newCalculateSum = 0;
        
        String[] aux = sumToStr.split("");
        for(String data : aux){
            newCalculateSum+=Integer.parseInt(data);
        }
        
        return auxFunction(newCalculateSum);            
        
    }

}

public class RecursiveDigitSum {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        String n = firstMultipleInput[0];

        int k = Integer.parseInt(firstMultipleInput[1]);

        int result = Result.superDigit(n, k);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
