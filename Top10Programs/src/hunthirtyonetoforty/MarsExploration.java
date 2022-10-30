package hunthirtyonetoforty;

//https://www.youtube.com/watch?v=v5l9zs6j86g
public class MarsExploration {

	public static void main(String[] args) {
		String s = "SOSSPSSQSSOR";
		System.out.println(marsExploration(s));

	}

	public static int marsExploration(String s) {
		int count = 0;
		for (int i = 0; i < s.length(); i += 3) {
			if (s.charAt(i) != 'S')
				count++;
			if (s.charAt(i + 1) != 'O')
				count++;
			if (s.charAt(i + 2) != 'S')
				count++;
		}
		return count;
	}

}
