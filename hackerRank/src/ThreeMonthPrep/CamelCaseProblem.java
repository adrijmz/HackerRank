package ThreeMonthPrep;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class CamelCaseProblem {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            String actual = scan.nextLine();
            if(actual.charAt(0)=='S') splitMethod(actual);
            else combineMethod(actual);
        }
        scan.close();
    }
    public static void splitMethod(String str){
       
            String newString = str.substring(4);
            String res="";
            for(int i=0;i<newString.length();i++){
                char charAt = newString.charAt(i);
                if(i==0 && charAt>='A' && charAt<='Z'){
                    res+=charAt;
                    continue;
                }
                 if(charAt>='a' && charAt<='z') res+=charAt;
                 if(charAt>='A' && charAt<='Z') res+=" "+charAt;
            }
            System.out.println(res.toLowerCase());
    }
    
    public static void combineMethod(String str){
        switch (str.charAt(2)) {
            case 'V':
                String newSring = str.substring(4);
                String res = "";
                for(int i=0;i<newSring.length();i++){
                    char charAt=newSring.charAt(i);
                    if(charAt>='a' && charAt<='z') res+=charAt;
                    if(charAt==' '){
                        String toPutInUpperCase = newSring.substring(i+1, i+2);
                        res+=toPutInUpperCase.toUpperCase();
                        i=i+2;
                    }
                }
                System.out.println(res);
                break;
            case 'M':
                String newSring2 = str.substring(4);
                String res2 = "";
                for(int i=0;i<newSring2.length();i++){
                    char charAt=newSring2.charAt(i);
                    if(charAt>='a' && charAt<='z') res2+=charAt;
                    if(charAt==' '){
                        String toPutInUpperCase = newSring2.substring(i+1, i+2);
                        res2+=toPutInUpperCase.toUpperCase();
                        i=i+1;
                    }
                }
                res2+="()";
                System.out.println(res2);
                break;
            case 'C':
                String newSring3 = str.substring(4);
                String res3 = "";
                for(int i=0;i<newSring3.length();i++){
                    char charAt=newSring3.charAt(i);
                    if(i==0){
                        String toPutInUpperCase = newSring3.substring(0, 1);
                        res3+=toPutInUpperCase.toUpperCase();
                        continue;
                    }
                    if(charAt>='a' && charAt<='z') res3+=charAt;
                    if(charAt==' '){
                        String toPutInUpperCase = newSring3.substring(i+1, i+2);
                        res3+=toPutInUpperCase.toUpperCase();
                        i=i+1;
                    }
                }
                System.out.println(res3);
                break;
        }
    }
}