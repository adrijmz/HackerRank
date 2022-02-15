package DataStructures;

//Complete this code or write your own from scratch
import java.util.*;
import java.io.*;


class MapProblem{
	public static void main(String []argh)
	{
        Map<String,Integer> myMap = new HashMap<String,Integer>();
		Scanner scan = new Scanner(System.in);
		int entries = scan.nextInt();
		scan.nextLine();
		for(int i=0;i<entries;i++){
			 String name = scan.nextLine();
			 int number = scan.nextInt();
			 myMap.put(name, number);
			 scan.nextLine();
		}
		while(scan.hasNext()){
			String actualName = scan.nextLine();
			if(myMap.get(actualName)!=null) System.out.println(actualName + "=" + myMap.get(actualName));
			else System.out.println("Not found");
		}
		scan.close();
	}
}



