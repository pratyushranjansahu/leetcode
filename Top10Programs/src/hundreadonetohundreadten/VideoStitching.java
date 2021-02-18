package hundreadonetohundreadten;

public class VideoStitching {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int videoStitching(int[][] clips, int T) {

		int min = 0;
		int max = 0;
		int total = 0;

		while (max < T) {

			for (int i = 0; i < clips.length; i++) {
				int l = clips[i][0];
				int r = clips[i][1];
				if (l <= min && r > max) {
					max = r;
				}
			}
			if (min == max)
				return -1;
			min = max;
			total++;
		}

		return total;
	}

}
