package patterns.arrays;
/*
	https://leetcode.com/problems/rotate-image/

 */
public class RotateImage {

	public static void main(String[] args) {
		int[][] matrix= {{1,2,3},{4,5,6},{7,8,9}};
		matrix = rotateMatrix(matrix);
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j]+" ");//[[7,4,1],[8,5,2],[9,6,3]]
			}
			System.out.println();
		}

	}
	
	private static int[][] rotateMatrix(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = i; j < matrix[0].length; j++) {
				int temp=matrix[i][j];
				matrix[i][j]=matrix[j][i];
				matrix[j][i]=temp;
			}
		}
		
		for (int i = 0; i < matrix.length; i++) {
			reverseArray(matrix[i]);
		}
		return matrix;
	}
	
	private static void reverseArray(int[] arr) {
		int l=0;
		int r=arr.length-1;
		while(l<r) {
			int temp=arr[l];
			arr[l]=arr[r];
			arr[r]=temp;
			l++;
			r--;
		}
	}

}
