package practiceinorder.p_151;
/*
 * https://leetcode.com/problems/multiply-strings/
 * https://www.youtube.com/watch?v=5NdhK3tZViQ
 */
public class MultiplyStrings {
    public static void main(String[] args) {
        String number1 = "123", number2 = "456";
        System.out.println(multiplication(number1, number2));// 56088
    }
    private static String multiplication (String number1, String number2) {
        if (number1.equals("0") || number2.equals("0"))
            return "0";
        int l1 = number1.length();
        int l2 = number2.length();
        int[] res = new int[l1+l2];
        int i = l2-1;
        int powerFactor = 0;
        while (i >= 0) {
            int ival = number2.charAt(i)-'0';
            i--;
            int j = l1-1;
            int k = res.length-1-powerFactor;
            int carry = 0;
            while (j >= 0 || carry != 0) {
                int jval = j >= 0 ? number1.charAt(j)-'0' : 0;
                j--;
                int product = ival * jval + carry + res[k];
                res[k] = product % 10;
                carry = product / 10;
                k--;
            }
            powerFactor++;
        }
        String str = "";
        boolean flag = false;
        for (int val : res) {
            if (val == 0 && flag == false) {
                continue;
            }else {
                flag = true;
                str +=val;
            }
        }
        return str;
    }
}
