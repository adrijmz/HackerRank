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
     * Complete the 'isBalanced' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String isBalanced(String s) {
    // Write your code here
        
        //odd length
        if(s.length()%2 != 0 || s.length()==0 || s==null) return "NO";
        
        // [ ( ( { } ) ) ] ( )
        
        Queue<Character> myQ = Collections.asLifoQueue(new LinkedList<>());
        //Queue = [ ( ( { }
        
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='(' || s.charAt(i)=='[' || s.charAt(i)=='{'){
                myQ.add(s.charAt(i));
            }
            else{
                if(myQ.isEmpty()) return "NO";
                //tail of the queue
                Character myC = myQ.remove();
                
                if((s.charAt(i)==')' && myC=='(') || (s.charAt(i)=='}' && myC=='{') || 
                                (s.charAt(i)==']' && myC=='['))
                {
                    continue;
                }
                else return "NO";
            }
        }
        if(myQ.isEmpty()) return "YES";
        
        else return "NO";
    }

}

public class BalancedBracket {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String s = bufferedReader.readLine();

                String result = Result.isBalanced(s);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
