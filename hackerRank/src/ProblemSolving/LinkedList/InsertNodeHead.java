package ProblemSolving.LinkedList;

import java.io.*;
import java.util.*;

public class InsertNodeHead {

    public static void insertNodeAtHead(LinkedList<Integer> myList, int data){
        myList.add(0, data);
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int sizeOfLinkedList = scan.nextInt();
        LinkedList<Integer> myList = new LinkedList<Integer>();
        for(int i=0; i<sizeOfLinkedList; i++){
            int valueToPut = scan.nextInt();
            insertNodeAtHead(myList, valueToPut);
        }
        for(Integer num: myList) System.out.println(num);
        scan.close();
    }
}