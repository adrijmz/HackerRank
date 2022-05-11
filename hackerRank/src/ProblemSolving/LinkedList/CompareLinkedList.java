package ProblemSolving.LinkedList;

import java.io.*;
import java.util.*;

public class CompareLinkedList {

    private static int getMaxSize(LinkedList<Integer> firstList, LinkedList<Integer> secondList){
        int sizeFirst = firstList.size();
        int sizeSecond = secondList.size();
        return Math.max(sizeFirst, sizeSecond);
    }

    public static int compare_lists(LinkedList<Integer> firstList, LinkedList<Integer> secondList){
        int cursor = 0;
        boolean stillEqual = true;
       
        int maxSize = getMaxSize(firstList, secondList);

        while(cursor<maxSize && stillEqual){
            int dataFirst;
            int dataSecond;
            try {
                dataFirst = firstList.get(cursor);
                dataSecond = secondList.get(cursor);
            } catch (Exception e) {
                //TODO: handle exception
                return 0;
            }
            if(dataFirst==dataSecond) cursor++;
            else{
                stillEqual = false;
                return 0;
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int testCases = scan.nextInt();
        
        for(int i=0; i<testCases; i++){
            LinkedList<Integer> firstLinkedList = new LinkedList<>();
            LinkedList<Integer> secondLinkedList = new LinkedList<>();
           
            int sizeFirstLinkedList = scan.nextInt();
            for(int j=0; j<sizeFirstLinkedList; j++){
                int numToAdd = scan.nextInt();
                firstLinkedList.add(numToAdd);
            }
           
            int sizeSecondLinkedList = scan.nextInt();
            for(int k=0; k<sizeSecondLinkedList; k++){
                int numToAdd = scan.nextInt();
                secondLinkedList.add(numToAdd);
            }
            System.out.println(compare_lists(firstLinkedList, secondLinkedList));

        }
        scan.close();
    }
}