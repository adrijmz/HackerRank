package DataStructures;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class list {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        List<Integer> res = new ArrayList<>();
        int len = scan.nextInt();
        for(int i=0;i<len;i++){
             res.add(scan.nextInt());
        }
        int querys = scan.nextInt();
        for(int i=0;i<querys;i++){
             if(scan.next().equals("Insert")){
                int pos = scan.nextInt();
                int digit = scan.nextInt();
                res.add(pos, digit);
             }
             else{
                res.remove(scan.nextInt());
             }
        }
        for(Integer num:res){
            System.out.print(num + " ");
        }
        scan.close();
    }
}