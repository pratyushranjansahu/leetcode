package practiceinorder.p_51;

public class GasStation {

	public static void main(String[] args) {
		int[] gas= {1,2,3,4,5};
		int[] cost= {3,4,5,1,2};
		
		System.out.println(canCompleteCircuit(gas,cost));

	}
	 public static int canCompleteCircuit(int[] gas, int[] cost) {
	        int n = gas.length;
	        int total_surplus = 0;
	        int surplus = 0;
	        int S = 0;
	        
	        for(int i = 0; i < n; ++i){
	            total_surplus += gas[i] - cost[i];
	            surplus += gas[i] - cost[i];
	            if(surplus < 0){
	                surplus = 0;
	                S = i+1;
	            }
	        }
	        return (total_surplus < 0) ? -1 : S;
	    }

}
