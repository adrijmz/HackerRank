package ProblemSolving.LinkedList;

import java.io.*;
import java.util.*;

public class PrintElements {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int sizeOfLinkedList = scan.nextInt();
        LinkedList<Integer> myList = new LinkedList<Integer>();
        for(int i=0; i<sizeOfLinkedList; i++){
            int actualValue = scan.nextInt();
            myList.add(actualValue);
            System.out.println(myList.get(i));
        }
        scan.close();
        
    }
}