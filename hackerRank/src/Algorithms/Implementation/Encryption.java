package Algorithms.Implementation;

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
     * Complete the 'encryption' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String encryption(String s) {
    // Write your code here
    s.replace(" ", "");
    int textLength = s.length();
    double square = Math.sqrt(textLength)+0.5;
    
    double row = Math.floor(square);
    double column = row;
    if(row*column<textLength) column++;
    
    Character[][] myArr = new Character[(int)row][(int)column];
    int index = 0;
    int actualRow = 0;
    int actualColumn = 0;
    String res = "";
    while(index<textLength){
        myArr[actualRow][actualColumn] = s.charAt(index);
        index++;
        actualColumn++;
        if(actualColumn==column){
            actualColumn = 0;
            actualRow++;
        }
    }
    actualColumn = 0;
    actualRow = 0;
    index = 0;
    while(index<textLength){
    if(myArr[actualRow][actualColumn]!=null){
        res+= myArr[actualRow][actualColumn];
        index++;
        }
        actualRow++;
        if(actualRow==row){
            actualRow = 0;
            actualColumn++;
            res+=" ";
        }
    }
    
    return res;
    }

}

public class Encryption {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.encryption(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
