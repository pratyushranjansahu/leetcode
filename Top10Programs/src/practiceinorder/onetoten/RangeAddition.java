package practiceinorder.onetoten;
/*
    https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/arrays-and-strings/range_addition/ojquestion
    https://www.youtube.com/watch?v=fBT0VKkqvtY
 */
public class RangeAddition {
    public static void main(String[] args) {
        int length = 5;
        int[][] updates = {
                {1,  3,  2},
                {2,  4,  3},
                {0,  2, -2}
        };
        int[] res = getModifiedArray(length, updates);

    }
    private static int[] getModifiedArray(int length, int[][] queries) {
        int[] res = new int[length];
        for (int q = 0; q < queries.length; q++) {
             int start = queries[q][0];
             int end = queries[q][1];
             int inc = queries[q][2];

             res[start] += inc;
             if (end+1 < length) {
                 res[end+1] -= inc;
             }
        }
        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum += res[i];
            res[i] = sum;
        }
        return  res;
    }
}
