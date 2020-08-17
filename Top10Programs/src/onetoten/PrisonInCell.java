package onetoten;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PrisonInCell {

	public static void main(String[] args) {
		int[] cells={0,1,0,1,1,0,0,1};
		System.out.println(prisonCell(cells, 7));
	}
	
	private static int[] prisonCell(int[] cells,int N) {
		Map<String,Integer> map=new HashMap();
		
		for (int i = 0; i < N; i++) {
			String key=Arrays.toString(cells);
			if(map.containsKey(key)) {
				int loopLength=i-map.get(key);
				int remainingLength=(N-i)%loopLength;
				return prisonCell(cells, remainingLength);
			}else {
				map.put(key, i);
				int prev=cells[0];
				for (int j = 1; j < 7; j++) {
					int next=cells[j+1];
					int current=cells[j];
					cells[j]=prev==next?1:0;
					prev=current;
					
				}
			}
			cells[0]=0;
			cells[7]=0;
		}
		return cells;
	}

}
