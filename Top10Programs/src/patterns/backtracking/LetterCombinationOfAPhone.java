package patterns.backtracking;

import java.util.*;
/*
	https://leetcode.com/problems/letter-combinations-of-a-phone-number/
	https://www.youtube.com/watch?v=8orpUBZZ9l0&t=759s
 */
public class LetterCombinationOfAPhone {

	public static void main(String[] args) {
		System.out.println(letterCombinations("23"));//[ad, ae, af, bd, be, bf, cd, ce, cf]
	}
	
	 public static  List<String> letterCombinations(String digits) {
	      
	        List<String> result = new ArrayList();
	        if(digits.length()==0)return result;
	        
	        HashMap<String,String> map = new HashMap();
	        map.put("2","abc"); map.put("3","def"); map.put("4","ghi");
	        map.put("5","jkl"); map.put("6","mno"); map.put("7","pqrs");
	        map.put("8","tuv"); map.put("9","wxyz");
	        
	        Deque<String> deque = new ArrayDeque();
	        deque.add("");   
	        
	        for(int i=0;i<digits.length();i++){//2   3      4
	        	//System.out.println(i+" "+(i+1));
	            String d = digits.substring(i,i+1); //2   3
	            String fromMap = map.get(d); //"abc"   "def"
	            int n = deque.size();
	            for(int j=0;j<n;j++){
	                String pull = deque.pollFirst(); //[a]        [b][c]   
	                for(int k=0;k<fromMap.length();k++){
	                    String temp = pull.concat(fromMap.charAt(k)+"");//[ad] [ae] [ai]
	                    deque.add(temp);//[ad] [ae] [ai]
	                }
	            }
	        }
	        
	        while(!deque.isEmpty()){
	            result.add(deque.poll());
	        }
	        return result;
	    }
}
