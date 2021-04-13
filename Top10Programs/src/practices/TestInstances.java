package practices;

import java.util.Arrays;
import java.util.Comparator;

class A{
	
}
class B extends A{
	
}class C extends B{
	
}
public class TestInstances {

	public static void main(String[] args) {
		B b=new B();
		System.out.println(b instanceof B);
		System.out.println((b instanceof B) && (!(b instanceof A)));
		System.out.println((b instanceof B) && (!(b instanceof C)));
		 int x=5;int y=0;
		 //int iVal= y != 0 & x/y>0 ? 1:0;
		 //System.out.println(iVal);
		 
		 
		 String[] citi= {"Bangalore","Pune","San Francisco","New York City"};
		 MyShort m=new MyShort();
		 
		 Arrays.sort(citi, m);
		 System.out.println(Arrays.binarySearch(citi, "New York City"));
	}

	static class MyShort implements Comparator<String>{

		@Override
		public int compare(String o1, String o2) {
			// TODO Auto-generated method stub
			return o2.compareTo(o1);
		}
		
	}
}

