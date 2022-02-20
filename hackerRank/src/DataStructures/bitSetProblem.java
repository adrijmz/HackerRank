package DataStructures;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class bitSetProblem {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);

        int lenSet=scan.nextInt();
        int operations=scan.nextInt();
        
        BitSet b1 = new BitSet(lenSet);
        BitSet b2 = new BitSet(lenSet);
        
        BitSet[] myArr = new BitSet[3];

        myArr[1]=b1;
        myArr[2]=b2;

        for(int i=0; i<operations; i++){
            String actualOperation = scan.next();
            int first=scan.nextInt();
            int second=scan.nextInt();
            switch(actualOperation){
                case "AND":                                      
                    myArr[first].and(myArr[second]);
                    break;
                case "SET":
                    myArr[first].set(second);
                    break;
                case "FLIP":
                    myArr[first].flip(second);
                    break;
                case "OR":
                    myArr[first].or(myArr[second]);
                    break;
                case "XOR":
                    myArr[first].xor(myArr[second]);
                    break;
            }
            System.out.println(myArr[1].cardinality() + " " + myArr[2].cardinality());
        }
        scan.close();
    }
}
