package hunfortytofifty;
/*
   https://www.geeksforgeeks.org/number-subsequences-form-ai-bj-ck/
   https://www.lintcode.com/problem/number-of-subsequences-of-form-ai-bj-ck/description
   Youtube : https://www.youtube.com/watch?v=IV9pbZsi5cc&t=758s
 */
public class CountSubsequenceOfAiBjCk {
    public static void main(String[] args) {
        System.out.println(countSubsequences("abbc"));//3
        System.out.println(countSubsequences("abcabc"));//7
    }

    public static int countSubsequences(String source) {
        int a = 0;
        int ab = 0;
        int abc = 0;
        for (int i = 0; i < source.length(); i++) {
            char ch = source.charAt(i);
            if(ch == 'a'){
                a = 2*a + 1;
            }else if (ch == 'b') {
                ab = 2 * ab + a;
            }else if (ch == 'c') {
                abc = 2 * abc + ab;
            }
        }
        return abc;
    }
}
