package practiceinorder.p_101;

import java.util.Stack;

public class BackSpaceString {

	public static void main(String[] args) {
	//	String s1="";
		//String s2="";
		String s1="ab#c";
		String s2="ad#c";
		System.out.println(stringBackSpace(s1, s2));
		
	}

	private static boolean stringBackSpace(String s1, String s2) {
		Stack<Character> st1=new Stack();
		Stack<Character> st2=new Stack();
		
		for(char c : s1.toCharArray()) {
			if(c !='#')
				st1.push(c);
			else {
				if(!st1.isEmpty())
					st1.pop();
			}
		}
		for(char c : s2.toCharArray()) {
			if(c !='#')
				st2.push(c);
			else {
				if(!st2.isEmpty())
					st2.pop();
			}
		}
		
		while(!st1.isEmpty() && !st2.isEmpty()) {
			char c1=st1.peek();
			st1.pop();
			char c2=st2.peek();
			st2.pop();
			
			if(c1!=c2)
				return false;
		}
		if(!st1.isEmpty() || !st2.isEmpty())
			return false;
		
		
			
		return true;
	}

}
