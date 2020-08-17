package twentyOnetothirty;

import java.util.ArrayList;
import java.util.List;

public class StringShift {

	public static void main(String[] args) {
		//String s="";
		//List<List<Integer>> list=new ArrayList<>();
		String str="abcdefg";
		List<List<Integer>> list=new ArrayList<>();
		List<Integer> l1=new ArrayList<>();
		l1.add(1);
		l1.add(1);
		list.add(l1);
		
		List<Integer>  l2=new ArrayList<>();
		l2.add(1);
		l2.add(1);
		list.add(l2);
		
		List<Integer>  l3=new ArrayList<>();
		l3.add(0);
		//l3.add(5);
		l3.add(8);
		//l3.add(2);
		list.add(l3);
		
		List<Integer>  l4=new ArrayList<>();
		l4.add(1);
		l4.add(3);
		list.add(l4);
		System.out.println(shift(str,list));

	}
	
	private static String shift(String s,List<List<Integer>> list) {
		int leftShift=0;
		int rightShift=0;
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i).get(0)==0)
				leftShift+=list.get(i).get(1);
			else {
				rightShift+=list.get(i).get(1);
			}
		}
		
		System.out.println("Left Shift : "+leftShift+" Right Shift : "+rightShift);
		if(rightShift>leftShift) {
			int count=rightShift-leftShift;
			int right=count%s.length();
			String s1=s.substring(0,s.length()-right);
			String s2=s.substring(s.length()-right);
			return s2+s1;
		}
		if(leftShift>rightShift) {
			int count=leftShift-rightShift;
			int left=count%s.length();
			String s1=s.substring(0,left);
			String s2=s.substring(left);
			return s2+s1;
		}
	return s;
	}

}
