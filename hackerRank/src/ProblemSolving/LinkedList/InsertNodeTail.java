import java.io.*;
import java.util.*;

public class InsertNodeTail {

    public static void insertNodeAtTail(LinkedList<Integer> myList, int data){
        myList.add(data);
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int sizeOfLinkedList = scan.nextInt();
        LinkedList<Integer> myList = new LinkedList<Integer>();
        for(int i=0; i<sizeOfLinkedList; i++){
            int valueToPut = scan.nextInt();
            insertNodeAtTail(myList, valueToPut);
            System.out.println(myList.get(i));
        }
        scan.close();
    }
}