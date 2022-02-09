package DataStructures;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;



public class dosDArray {
    public static void main(String[] args) throws IOException {
        int arr[][] = new int[6][6];
        Scanner scan = new Scanner(System.in);
        for(int i=0; i<6;i++){
            for(int j=0;j<6;j++){
                arr[i][j]=scan.nextInt();
            }
        }
        scan.close();
        int max=Integer.MIN_VALUE;
        int actual=0;
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                actual=arr[i][j]+arr[i][j+1]+arr[i][j+2]+arr[i+1][j+1]+arr[i+2][j]+arr[i+2][j+1]+arr[i+2][j+2];
                max=Math.max(max, actual);
            }   
        }
        System.out.println(max);
    }
}
