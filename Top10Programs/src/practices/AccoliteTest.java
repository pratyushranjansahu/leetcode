package practices;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccoliteTest {

	public static void main(String[] args) {
		List<Integer> list=new ArrayList<>();
		Map<Integer,Boolean> map=new HashMap();
		int[] arr={1, 4, 5, 7, 9, 50, 34, 7};
		List<Integer> givenList=new ArrayList<Integer>();
		
		for(int n : arr) {
			//map.put(n, true);
		  givenList.add(n);
		}
		
		
		
		
		for(int i=1;i<=100;i++) {
			if(givenList.contains(i))continue;
			else {
			list.add(i);	
			}
		}
		System.out.println(list);
	}

}
