package practiceinorder.p_171;
/*
    https://leetcode.com/problems/maximize-the-confusion-of-an-exam/description/
     https://www.youtube.com/watch?v=VJ3ZpqD4Evk&t=445s
 */
public class MaximizeTheConfusionOfAnExam {
    public static void main(String[] args) {
        String answerKey = "TFFT";
        int k = 1;
        System.out.println(maxConsecutiveAnswers(answerKey,k));//3
    }

    private static int maxConsecutiveAnswers(String answerKey, int k) {
        return Math.max(helper(answerKey, k, 'T'),helper(answerKey, k, 'F'));
    }

    private static int helper(String s, int k, char ch){
        int sp = 0;
        int ep = 0;
        int ans = 0;
        for(char c : s.toCharArray()){
            if (c != ch){
                k--;
            }
            while(k < 0){
                if(ch == s.charAt(sp)){
                    sp++;
                }else{
                    sp++;
                    k++;
                }
            }
            ans = Math.max(ans,ep - sp +1);
            ep++;
        }
        return ans;
    }
}
