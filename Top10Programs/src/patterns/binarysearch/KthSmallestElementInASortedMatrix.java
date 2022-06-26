package patterns.binarysearch;
/*
    https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
    https://www.youtube.com/watch?v=LkrsdWa69_Q
 */
public class KthSmallestElementInASortedMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1,5,9},{10,11,13},{12,13,15}};
        int  k = 8;
        System.out.println(kthSmallest(matrix, k));//13
    }
    public static int kthSmallest(int[][] matrix, int k) {
        if(matrix==null) return 0;
        int r=matrix.length;
        int c=matrix[0].length;
        int startVal=matrix[0][0],endVal=matrix[r-1][c-1],midVal;
        while(startVal<=endVal)
        {
            midVal=(endVal+startVal)/2;
            int ans=0;
            for(int i=0;i<r;i++)
            {
                int l=0,h=c-1;
                while(l<=h)
                {
                    int m=l+(h-l)/2;
                    if(matrix[i][m]<=midVal) l=m+1;
                    else h=m-1;
                }
                ans+=l;
            }
            if(ans<k) startVal=midVal+1;
            else endVal=midVal-1;
        }
        return startVal;
    }
}
