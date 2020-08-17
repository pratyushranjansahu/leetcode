package eleventotwenty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListIntervalIntersection {

	public static void main(String[] args) {
		int[][] A= {{0,2},{5,10},{13,23},{24,25}};
		int[][] B= {{1,5},{8,12},{15,24},{25,26}};
		listIntersection(A,B);

	}
	 
	private static int[][] listIntersection(int[][] A,int[][]B){
		List<int[]> result=new ArrayList<>();
		int i=0;
		int j=0;
		
		while(i<A.length && j<B.length) {
			int[] a=A[i];
			int[] b=B[j];
			if(a[1]<b[0])
				i++;
			else if(b[1]<a[0])
				j++;
			else {
				//over lap
				int start=Math.max(a[0], b[0]);
				int end=Math.min(a[1], b[1]);
				result.add(new int[] {start,end});
				if(a[1]<b[1])i++;
				else if(b[1]<a[1])j++;
				else {
					i++;
					j++;
				}
			}
		}
		return result.toArray(new int[result.size()][2]);
	}

}
