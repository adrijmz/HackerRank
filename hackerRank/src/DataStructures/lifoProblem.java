package DataStructures;

import java.util.*;

class lifoProblem{
	
	public static void main(String []argh)
	{
		Scanner scan = new Scanner(System.in);
		while (scan.hasNext()) {
			Stack<String> res = new Stack<>();
			String input=scan.next();
            //Complete the code
			String[] aux = input.split("");
			if(aux[0].equals("]") || aux[0].equals("}") || aux[0].equals(")")) {
				System.out.println("false");
			}
			else{
				for(String myChar: aux){
					if(myChar.equals("(") || myChar.equals("{") || myChar.equals("[")) res.push(myChar);
					else{
						String popped=res.pop();
						if(!(popped.equals("(") && myChar.equals(")") ||
							popped.equals("{") && myChar.equals("}") ||
							popped.equals("[") && myChar.equals("]"))){
							System.out.println("false");
						}	
					}
				}
				if(!res.isEmpty()) System.out.println("false");
				else System.out.println("true");
			}
						
		}
		scan.close();
	}
}
