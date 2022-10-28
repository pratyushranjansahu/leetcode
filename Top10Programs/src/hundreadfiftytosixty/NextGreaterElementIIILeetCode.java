package hundreadfiftytosixty;
/*
    https://leetcode.com/problems/next-greater-element-iii/
    https://github.com/Sunchit/Coding-Decoded/blob/master/December2020/NextGreaterElementIII.java
    https://www.youtube.com/watch?v=nU5UUAyRFH4
 */
public class NextGreaterElementIIILeetCode {
    public static void main(String[] args) {
        String s = "12";
        int n = 12;
        System.out.println(nextGreaterElement(n)); //21
    }
    public static int nextGreaterElement(int n) {
        char[] str = (n+"").toCharArray();

        int deflectionPoint = str.length-1;

        while(deflectionPoint>0){
            if(str[deflectionPoint] > str[deflectionPoint-1]) {
                break;
            }
            deflectionPoint--;
        }
        if(deflectionPoint == 0){
            return -1;
        }

        int firstSwappingIndex = deflectionPoint -1;

        int secondSwappingIndex = str.length -1;
        while(secondSwappingIndex>=firstSwappingIndex){
            if(str[firstSwappingIndex] < str[secondSwappingIndex]) {
                break;
            }
            secondSwappingIndex--;
        }

        // swap

        char temp = str[firstSwappingIndex];
        str[firstSwappingIndex] = str[secondSwappingIndex];
        str[secondSwappingIndex] = temp;

        // swapping at the point of deflection

        reverseChar(str, deflectionPoint);
        Long no = Long.parseLong(new String(str));
        if(no<=Integer.MAX_VALUE){
            return no.intValue();
        } else{
            return -1;
        }

    }

    private static void reverseChar(char[] str, int i){
        int start = i;
        int end =str.length-1;
        while(end>=start){
            char temp = str[start];
            str[start] = str[end];
            str[end] = temp;
            end--;
            start++;

        }
    }

}
