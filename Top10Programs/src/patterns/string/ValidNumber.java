package patterns.string;
/*
    https://leetcode.com/problems/valid-number/description/
    https://www.youtube.com/watch?v=dmDFL14hlOU
 */
public class ValidNumber {
    public static void main(String[] args) {
        String s = "0";
        System.out.println(isNumber(s));//true
        String schar = "c";
        System.out.println(isNumber(schar));//false
    }
    public static boolean isNumber(String s) {
        int exponentPlace = s.indexOf('e');
        if (exponentPlace == -1)
            exponentPlace = s.indexOf('E');

        int endIndexOfFirstPart = exponentPlace == -1 ? s.length() - 1 : exponentPlace - 1;
        boolean firstPartValid = validateInteger(s,0,endIndexOfFirstPart)
                || validateDecimal(s,0,endIndexOfFirstPart);
        boolean secondPartValid = exponentPlace == -1
                || validateInteger(s, exponentPlace + 1,s.length() -1);
        return firstPartValid && secondPartValid;
    }


    private static boolean validateDecimal(String s, int start, int end) {
        if (start > end)
            return false;
        if (s.charAt(start) == '+' || s.charAt(start) == '-'){
            start++;
        }
        if (start > end)
            return false;
        int dotIndex = s.indexOf('.');
        if (dotIndex == -1) {
            return false;
        }
        boolean atleastOneSetOfDigits = false;
        if (dotIndex > start) {
            if (!validateDigits(s, start,dotIndex - 1)) {
                return false;
            }
            atleastOneSetOfDigits = true;
        }
        if (dotIndex < end) {
            if (!validateDigits(s, dotIndex + 1, end)) {
                return false;
            }
            atleastOneSetOfDigits = true;

        }
        return atleastOneSetOfDigits;
    }
    private static boolean validateInteger(String s, int start, int end) {
        if (start > end)
            return false;
        if (s.charAt(start) == '+' || s.charAt(start) == '-'){
            start++;
        }
        if (start > end)
            return false;
        return validateDigits(s,start,end);
    }

    private static boolean validateDigits(String s, int start, int end) {
        if (start > end)
            return false;
        for(int i = start; i <= end; i++) {
            if (!Character.isDigit(s.charAt(i))){
                return false;
            }
        }
        return true;
    }
}
