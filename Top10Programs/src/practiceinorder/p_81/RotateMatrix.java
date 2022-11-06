package practiceinorder.p_81;

public class RotateMatrix {

	public static void main(String[] args) {
		int[][] matrix= {{1,2,3},{4,5,6},{7,8,9}};
		rotateMatrix(matrix);

	}
	
	private static void rotateMatrix(int[][] matrix) {
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
