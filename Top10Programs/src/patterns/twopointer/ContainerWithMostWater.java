package patterns.twopointer;
/*
    https://leetcode.com/problems/container-with-most-water/
    https://www.youtube.com/watch?v=rkPxSTBwwvo
 */
public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height)); // 49
    }
    public static int maxArea(int[] height) {
        int i = 0, j = height.length - 1, maxArea = 0;
        while (i < j) {
            maxArea = Math.max(maxArea, (j - i) * Math.min(height[i], height[j]));
            if (height[i] < height[j])
                i++;
            else
                j--;
        }
        return maxArea;
    }
}
