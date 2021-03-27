package practices;

public class SortBinaryArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {1,0,1,1,1,1,1,0,0,0};
		for(int a : sortArray(arr)){
			System.out.print(a+" ");
		}
	}
	
	static int[] sortArray(int[] a) {
		int k=0;
		
		for(int i=0;i<a.length;i++) {
			if(a[i]==0) {
				int temp=a[k];
				a[k]=a[i];
				a[i]=temp;
				k++;
				
			}
			
			
		}
		
		
		return a;
	}
	

}
