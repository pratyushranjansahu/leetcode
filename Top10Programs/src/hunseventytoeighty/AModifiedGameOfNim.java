package hunseventytoeighty;
/*
    https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-interview-prep/game-theory/a-modified-game-of-nim-official/ojquestion
    https://www.youtube.com/watch?v=PPX8PNVjb24
 */
public class AModifiedGameOfNim {
    public static void main(String[] args) {
        int[] arr = {3,6,9,15,60,10,20};
        System.out.println(getWinner(arr, arr.length));// ALICE
    }
    private static String getWinner(int[] arr, int n) {
        int count3 = 0;
        int count5 = 0;
        int commonCount = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] % 5 == 0 && arr[i] % 3 == 0) {
                commonCount++;
            }else if (arr[i] % 5 == 0) {
                count5++;
            }else if (arr[i] % 3 == 0) {
                count3++;
            }
        }
        if (commonCount == 0) {
            if (count3 > count5) {
                return "ALICE";
            }else {
                return "BOB";
            }
        }else {
            if (count3 >= count5) {
                return "ALICE";
            }else {
                return "BOB";
            }
        }
    }
}
