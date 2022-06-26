package patterns.binarysearch;
/*
    https://leetcode.com/problems/find-smallest-letter-greater-than-target/
    https://www.youtube.com/watch?v=uZKCnU0ynNw
 */
public class FindSmallestLetterGreaterThanTarget {
    public static void main(String[] args) {
        char[] letters = {'c','f','j'};
        char target = 'a';
        System.out.println(nextGreatestLetter(letters, target)); // c
    }
    public static char nextGreatestLetter(char[] letters, char target) {
        int n = letters.length;
        int left = 0, right = n - 1;
        char res = letters[0];
        while(left <= right){
            int mid = (left + right) / 2;
            if(letters[mid] < target){
                left = mid + 1;
            }else if (letters[mid] == target){
                left = mid + 1;
            }else {
                res = letters[mid];
                right = mid - 1;
            }
        }
        return res;
    }
}
