package hundreadtwintyonetothirty;
//https://www.youtube.com/watch?v=Eo_d1dKQuqM
public class MinimumNumberOfOperationsToMoveAllBallsToEachBox {

	public static void main(String[] args) {
		//String boxes="110";
		String boxes="1110";
		minOperations(boxes);
	}
	public static int[] minOperations(String boxes) {
        int n = boxes.length();
           char[] ch = boxes.toCharArray();

           int[] left = new int[n];
           int count = ch[0] - '0';
           for (int i = 1; i < n; i++) {
               left[i] = left[i - 1] + count;
               count += ch[i] - '0';
           }

           int[] right = new int[n];
           count = ch[n - 1] - '0';
           for (int i = n - 2; i >= 0; i--) {
               right[i] = right[i + 1] + count;
               count += ch[i] - '0';
           }

           int[] answer = new int[n];
           for (int i = 0; i < n; i++) {
               answer[i] = left[i] + right[i];
           }

           return answer;
   }

}
