package practiceinorder.p_91;

import java.util.Arrays;

public class BoatsToSavePeople {

	public static void main(String[] args) {
		int[] people = {1,2}; int limit = 3;
		System.out.println(numRescueBoats(people, limit));

	}
	
	public static int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int i = 0, j = people.length - 1;
        int boats = 0;
        
        while(i <= j){
            if(people[i] + people[j] <= limit)
                i++;
            j--;
            boats++;
        }
        return boats;
    }

}
