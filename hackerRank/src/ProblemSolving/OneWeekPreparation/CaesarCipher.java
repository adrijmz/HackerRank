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
     * Complete the 'caesarCipher' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. INTEGER k
     */

    public static String caesarCipher(String s, int k) {
    // Write your code here
        String lowerLetters = "abcdefghijklmnopqrstuvwxyz";
        String upperLetters = lowerLetters.toUpperCase();
        k%=lowerLetters.length();
        String newS = "";
        
        for(int i=0; i<s.length(); i++){
            Character myC = s.charAt(i);
            //case lower letter
            if(s.charAt(i)>='a' && s.charAt(i)<='z'){
                int myIndex = lowerLetters.indexOf((Character) myC);
                if(myIndex+k>=lowerLetters.length()){
                    myC = lowerLetters.charAt(myIndex+k-lowerLetters.length());
                    newS+=myC;
                }
                else newS+=lowerLetters.charAt(myIndex+k);
            }
            else if(s.charAt(i)>='A' && s.charAt(i)<='Z'){
                //case upper letters
                int myIndex = upperLetters.indexOf((Character) myC);
                if(myIndex+k>=upperLetters.length()){
                    myC = upperLetters.charAt(myIndex+k-upperLetters.length());
                    newS+=myC;
                }
                else newS+=upperLetters.charAt(myIndex+k);
            }
            else newS+=s.charAt(i);
        }
        
        return newS;
        
        
    }

}

public class CaesarCipher {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String s = bufferedReader.readLine();

        int k = Integer.parseInt(bufferedReader.readLine().trim());

        String result = Result.caesarCipher(s, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
