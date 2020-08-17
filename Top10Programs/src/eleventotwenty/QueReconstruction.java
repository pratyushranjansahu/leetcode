package eleventotwenty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QueReconstruction {

	public static void main(String[] args) {
		int[][] people = new int[5][4];
		reconstructQueue(people);

	}

	private static int[][] reconstructQueue(int[][] people) {
		List<int[]> result = new ArrayList<>();
		Arrays.sort(people,(a,b) -> {
			return a[0]==b[0] ? a[1]-b[1] : b[0]-a[0];
		});
		for(int[] x :people)
			result.add(x[1],x);
		return result.toArray(new int[result.size()][2]);
	}

}
