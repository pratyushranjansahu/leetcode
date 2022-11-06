package practiceinorder.p_141;

import java.util.Random;
/*
 * https://leetcode.com/problems/shuffle-an-array/
 * https://www.youtube.com/watch?v=NhVMsP9ibuE
 * https://www.youtube.com/watch?v=NCpXQshJEk4
 */
public class ShuffleAnArray {
    int[] A;
    public static void main(String[] args) {

    }
    public ShuffleAnArray(int[] nums) {
        A = nums;
    }

    public int[] reset() {
        return A;
    }

    public int[] shuffle() {
        int[] shuffle = A.clone();
        for (int i = shuffle.length - 1; i >= 0; i--) {
            int index = new Random().nextInt(i + 1);
            int temp = shuffle[i];
            shuffle[i] = shuffle[index];
            shuffle[index] = temp;
        }

        return shuffle;
    }
}
