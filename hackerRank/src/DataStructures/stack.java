package DataStructures;

import java.util.*;

class stack{
	
	public static void main(String []argh)
	{
		Scanner sc = new Scanner(System.in);
        boolean status = true;
        Stack<Character> myStack = new Stack<Character>();
		
		while (sc.hasNext()) {
			String input=sc.next();
            //Complete the code
            if((input.length()%2)!=0 || 
                (input.charAt(0)==']' || input.charAt(0)=='}' || 
                    input.charAt(0)==')')){ 
                        System.out.println("false");
                        continue;
                    }
            for(int i=0;i<input.length();i++){
                if(!myStack.isEmpty()){
                    switch(input.charAt(i)){
                        case ')' : if(myStack.peek().equals('(')) {
                            myStack.pop();
                        }
                        break;
                        case '}' : if(myStack.peek().equals('{')) {
                                    myStack.pop();
                                    }break;
                        case ']' : if(myStack.peek().equals('[')) {
                                    myStack.pop();
                                    }break;
                        default: myStack.push(input.charAt(i));
                    }
                }
                else myStack.push(input.charAt(i));                
            }
            System.out.println(myStack.isEmpty());
            myStack.clear();
        }
		
	}
}



