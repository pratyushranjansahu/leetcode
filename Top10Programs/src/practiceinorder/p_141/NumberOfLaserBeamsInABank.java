package practiceinorder.p_141;
/*
 * https://leetcode.com/problems/number-of-laser-beams-in-a-bank/
 * https://www.youtube.com/watch?v=2I_yrv-t3Uo
 */
public class NumberOfLaserBeamsInABank {
    public static void main(String[] args) {
        String[] bank = {"011001","000000","010100","001000"};
        System.out.println(numberOfBeams(bank));//8
    }
    public static int numberOfBeams(String[] bank) {
        int poc = 0;
        int ans = 0;
        for (String s : bank) {
            int coc = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '1') {
                    coc += 1;
                }
            }
            if (coc > 0) {
                ans += coc * poc;
                poc = coc;
            }
        }
        return ans;
    }
}
