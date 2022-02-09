package DataStructures;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class arrList {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int rows = scan.nextInt();
        ArrayList<ArrayList<Integer>> list = new ArrayList<>(rows);
        for(int i=0;i<rows;i++){
            int columns = scan.nextInt();
            ArrayList<Integer> toPut = new ArrayList<>(columns);
            for(int j=0;j<columns;j++){
                toPut.add(scan.nextInt());
            }
            list.add(toPut);;
        }
        int querys = scan.nextInt();
        for(int i=0;i<querys;i++){
            int x=scan.nextInt();
            int y=scan.nextInt();
            if(y<=list.get(x-1).size()) System.out.println(list.get(x-1).get(y-1));
            else System.out.println("ERROR!");
        }
        scan.close();
    }
}