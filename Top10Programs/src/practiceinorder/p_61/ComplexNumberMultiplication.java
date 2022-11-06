package practiceinorder.p_61;
/*
 * https://leetcode.com/problems/complex-number-multiplication/
 * https://www.youtube.com/watch?v=6rqL05qqIJ0
 */
public class ComplexNumberMultiplication {
    public static void main(String[] args) {
        String num1 = "1+1i", num2 = "1+1i";
        System.out.println(complexNumberMultiply(num1, num2)); //0+2i
    }
    public static String complexNumberMultiply(String num1, String num2) {
        // n1 = a + bi
        // n2 = c + di
        // res = (a * c) - (b * d) + (a * d)+ (c * d)i
        int a = Integer.parseInt(num1.substring(0, num1.indexOf('+')));
        int b = Integer.parseInt(num1.substring(num1.indexOf('+')+1, num1.length()-1));
        int c = Integer.parseInt(num2.substring(0, num2.indexOf('+')));
        int d = Integer.parseInt(num2.substring(num2.indexOf('+')+1, num2.length()-1));

        return ""+(a * c - b * d) + "+" + (a *d + c * b)+ "i";
    }
}
