package Strings;

import java.util.*;

public class StringTokensProblem {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        // Write your code here.
        String[] str = s.trim().split("[ !,?.\\_'@]+");
        if(s.trim().length()==0) System.out.println(0);
        else{
            System.out.println(str.length);
            for(String string : str){
                System.out.println(string);
            }
        }
        
        scan.close();
    }
}

