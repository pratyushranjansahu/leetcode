package hunsixtytoseventy;

import java.util.PriorityQueue;
/*
    https://leetcode.com/problems/trapping-rain-water-ii/
    https://www.youtube.com/watch?v=fywyCy6Fyoo&t=1178s
 */
public class TrappingRainWaterII {
    public static void main(String[] args) {
        int[][] heightMap = {{1,4,3,1,3,2},{3,2,1,3,2,4},{2,3,3,2,3,1}};
        System.out.println(trapRainWater(heightMap)); // 4
    }
    public static int trapRainWater(int[][] heightMap) {
        int m = heightMap.length;
        int n = heightMap[0].length;
        PriorityQueue<Pair> priorityQueue = new PriorityQueue<>();
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0 || i == m-1 || j == n-1) {
                    priorityQueue.add(new Pair(i, j, heightMap[i][j]));
                    visited[i][j] = true;
                }
            }
        }

        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        int water = 0;
        while (!priorityQueue.isEmpty()) {
            Pair rem = priorityQueue.remove();
            for (int[] dir : dirs) {
                int rowDash = rem.row + dir[0];
                int colDash = rem.column + dir[1];
                if (rowDash >= 0 && rowDash < m && colDash >=0 && colDash < n && visited[rowDash][colDash] == false) {
                    visited[rowDash][colDash] = true;
                    water += Math.max(0, rem.height - heightMap[rowDash][colDash]);
                    if (heightMap[rowDash][colDash] > rem.height) {
                        priorityQueue.add(new Pair(rowDash,colDash,heightMap[rowDash][colDash]));
                    } else {
                        priorityQueue.add(new Pair(rowDash,colDash, rem.height));
                    }
                }
            }
        }
        return water;
    }
    public static class Pair implements Comparable<Pair> {
        int row;
        int column;
        int height;

        public Pair(int row, int column, int height) {
            this.row = row;
            this.column = column;
            this.height = height;
        }

        @Override
        public int compareTo(Pair pair) {
            return this.height - pair.height;
        }
    }
}
