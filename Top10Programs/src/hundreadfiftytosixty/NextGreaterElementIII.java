package hundreadfiftytosixty;
/*
    556. Next Greater Element III (slightly different with integer i/p)
    https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/arrays-and-strings/next-greater-element-iii/ojquestion
    https://www.youtube.com/watch?v=eAfJJyaAmes
 */
public class NextGreaterElementIII {
    public static void main(String[] args) {
        String s = "12";
        System.out.println(nextGreaterElement(s)); //21
    }
    private static String nextGreaterElement (String s) {
        char[] arr = s.toCharArray();
        int i = arr.length-2;
        while (i >= 0 && arr[i] >= arr[i+1]) {
            i--;
        }
        if (i == -1) {
            return "-1";
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

        //concatenate from 0 to index
        String res = "";
        for (int j = 0; j <= i; j++) {
            res += arr[j];
        }
        //conctenate k to i+1 index (reverse order)
        for (int j = arr.length-1; j > i; j--) {
            res += arr[j];
        }
        return res;
    }
}
