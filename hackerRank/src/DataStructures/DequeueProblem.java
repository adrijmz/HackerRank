package DataStructures;

import java.util.*;

public class DequeueProblem {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Deque<Integer> deque = new ArrayDeque<>();
        HashSet<Integer> set = new HashSet<>();
        int length = scan.nextInt();
        int subArrayLength = scan.nextInt();
        
        int max=Integer.MIN_VALUE;

        for (int i = 0; i < length; i++) {
            int num = scan.nextInt();
            deque.push(num);
            set.add(num);

            if(deque.size()==subArrayLength){
                if(set.size()>max) max=set.size();
                Integer removed = deque.removeLast();
                if(!deque.contains(removed))set.remove(removed);
            }
        }
        System.out.println(max);
        scan.close();

    }
}



