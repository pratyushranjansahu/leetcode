package practiceinorder.p_21;
/*
    https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/arrays-and-strings/wiggle-sort-1/ojquestion
    https://www.youtube.com/watch?v=eOlp2q08EDU
 */
public class WiggleSortI {
    public static void main(String[] args) {

    }
    private static void wiggleSort(int[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            if(i%2 == 0) {
                if (arr[i] > arr[i+1]) {
                    swap(arr, i, i+1);
                }
            } else {
                if (arr[i] < arr[i+1]) {
                    swap(arr, i, i+1);
                }
            }
        }
    }
    private static void swap (int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
}
