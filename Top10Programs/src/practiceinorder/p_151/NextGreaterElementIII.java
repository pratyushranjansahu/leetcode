package practiceinorder.p_151;
/*
    https://leetcode.com/problems/next-greater-element-iii/
    https://github.com/Sunchit/Coding-Decoded/blob/master/December2020/NextGreaterElementIII.java
    https://www.youtube.com/watch?v=nU5UUAyRFH4
 */
public class NextGreaterElementIII {

    public static void main(String[] args) {
        int n = 12;
        System.out.println(nextGreaterElement(n)); //632145
    }

    public static int nextGreaterElement(int n) {
        char[] arr = (n+"").toCharArray();

        int i = arr.length-2;

        while (i >= 0 && arr[i] >= arr[i+1]) {
            i--;
        }
        if (i == -1) {
            return -1;
        }

        //find just greater than ith index element
        int k = arr.length-1;
        while (arr[i] >= arr[k]) {
            k--;
        }
        //swap from i & k
        char temp = arr[i];
        arr[i] = arr[k];
        arr[k] = temp;

        // swapping at the point of deflection
        reverseChar(arr, i);
        Long no = Long.parseLong(new String(arr));
        if(no<=Integer.MAX_VALUE){
            return no.intValue();
        } else{
            return -1;
        }

    }

    private static void reverseChar(char[] str, int i){
        int start = i+1;
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
