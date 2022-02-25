package ThreeMonthPrep;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;


class Result {

    /*
     * Complete the 'timeConversion' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String timeConversion(String s) {
    // Write your code here
        if(s.contains("AM") && s.substring(0, 2).equals("12")){
            String hh="00";
            String mmss=s.substring(2,8);
            return hh+mmss;
        }
        if(s.contains("PM")&&(!s.substring(0, 2).equals("12"))){
            String hh=Integer.toString(Integer.parseInt(s.substring(0, 2))+12);
            String mmss=s.substring(2,8);
            return hh+mmss;
        }
        else {
            return s.substring(0, 8);
        }
    }

}

public class TimeConversionProblem {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.timeConversion(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
