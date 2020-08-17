package sixtyonetoseventy;

public class FindAPairWithMaximumProductInArrayOfIntegers {

	public static void main(String[] args) {
		int[] arr= {6,5,3,-1,8,-12,9,-9};
		System.out.println(findMAxProduct(arr));

	}
	
	private static int findMAxProduct(int[] arr) {
		int result=0;
		int nga=Integer.MIN_VALUE;
		int ngb=Integer.MIN_VALUE;
		int psa=Integer.MIN_VALUE;
		int psb=Integer.MIN_VALUE;
		for(int i=0;i<arr.length;i++) {
			if(psa<arr[i]) {
				psb=psa;
				psa=arr[i];
				
			}else if(psb<arr[i]) {
				psb=arr[i];
			}
			if(arr[i]<0 && Math.abs(nga)<Math.abs(arr[i])) {
				ngb=nga;
				nga=arr[i];
			}else if(arr[i] < 0 &&  Math.abs(arr[i])  
                    > Math.abs(ngb)){
				ngb=arr[i];
			}
			
		}
		//System.out.println(nga +" : "+ngb+" : "+psa+" : "+psb);
		int negProd=nga*ngb;
		int posProd=psa*psb;
		result=Math.max(negProd, posProd);
		return result;
	}

}
