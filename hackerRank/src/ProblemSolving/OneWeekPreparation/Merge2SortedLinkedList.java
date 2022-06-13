package ProblemSolving.OneWeekPreparation;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Merge2SortedLinkedList {

    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    static class SinglyLinkedList {
        public SinglyLinkedListNode head;
        public SinglyLinkedListNode tail;

        public SinglyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
            }

            this.tail = node;
        }
    }

    public static void printSinglyLinkedList(SinglyLinkedListNode node, String sep, BufferedWriter bufferedWriter) throws IOException {
        while (node != null) {
            bufferedWriter.write(String.valueOf(node.data));

            node = node.next;

            if (node != null) {
                bufferedWriter.write(sep);
            }
        }
    }

    // Complete the mergeLists function below.

    /*
     * For your reference:
     *
     * SinglyLinkedListNode {
     *     int data;
     *     SinglyLinkedListNode next;
     * }
     *
     */
    static SinglyLinkedListNode mergeLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        //1->3->5->7
        //2->4->NULL
        
        //1 -> 2 -> 3 -> 4 -> 5 -> 7
        if(head1==null && head2==null) return null;
        
        SinglyLinkedListNode newHead = null;
        SinglyLinkedListNode prevNode = null;
        
        if(head1.data<=head2.data || head2==null){
            newHead = head1;
            prevNode = head1;
            head1 = head1.next;
        }
        else if(head2.data<head1.data || head1==null){
            newHead = head2;
            prevNode = head2;
            head2 = head2.next;
        }
        
        while(head1!=null && head2!=null){
            if(head1.data<=head2.data){
                prevNode.next = head1;
                prevNode = head1;
                head1 = head1.next;
            }
            else{
                prevNode.next = head2;
                prevNode = head2;
                head2 = head2.next;
            }
        }
        
        if(head2==null){
            prevNode.next = head1;
        }
        else prevNode.next = head2;
        
        return newHead;

    }

    private static final Scanner scanner = new Scanner(System.in);