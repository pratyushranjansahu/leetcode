package practiceinorder.p_51;

import java.util.*;

public class GroupAnagrams {

	public static void main(String[] args) {
		String[] arr= {"eat","bat","ate","tae"};
		System.out.println(groupAnagrams(arr));

	}
	
	private static List<List<String>> groupAnagrams(String[] arr){
		if(arr.length==0)return new ArrayList<>();
		//List<List<String>> result=new ArrayList<>();
		Map<String, List<String>> map=new HashMap<>();
		for(String s: arr) {
			char[] charray=s.toCharArray();
			Arrays.sort(charray);
			String key=String.valueOf(charray);
			if(map.containsKey(key)) {
				List<String> list=map.get(key);
				list.add(s);
				map.put(key, list);
			}else {
				List<String> list=new ArrayList<>();
				list.add(s);
				map.put(key, list);
			}
		}
		
		return new ArrayList<>(map.values());
				
	}

}
