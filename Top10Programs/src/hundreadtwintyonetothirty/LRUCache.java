package hundreadtwintyonetothirty;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

	static int capacity=5;
	static Map<Integer,Integer>  map=new HashMap();
	
	public static void main(String[] args) {
		// TODO Auto-generated method 

	}
	
	private int  get(int k) {
		if(map.containsKey(k)) {
			int val=map.get(k);
			map.remove(k);
			map.put(k, val);
			return val;
		}
		return -1;
	}
	
	private void set(int key,int value) {
		if(map.containsKey(key)) {
			map.remove(key);
		}else if(map.size()==capacity) {
			map.remove(map.keySet().iterator().next());
		}
		map.put(key, value);
	}

}
