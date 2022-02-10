package DataStructures;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class sumSubArray {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int len = scan.nextInt();
        int arr[] = new int[len];
        int counter = 0;
        for(int i=0;i<len;i++){
            arr[i]=scan.nextInt();
            if(arr[i]<0) counter++;
        }
        scan.close();
        for(int i=0;i<len;i++){
            int actualSum=arr[i];
            for(int j=0;j<len;j++){
                if(i<j){
                    actualSum+=arr[j];
                    if(actualSum<0) counter++;
                }
            }
        }
        System.out.println(counter);
    }
}