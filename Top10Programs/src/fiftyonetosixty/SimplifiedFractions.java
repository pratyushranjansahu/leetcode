package fiftyonetosixty;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SimplifiedFractions {

	public static void main(String[] args) {
		int n=2;
		System.out.println(simplifiedFractions(n));

	}
	public static  List<String> simplifiedFractions(int n) {
		List<String> result=new ArrayList<>();
		Set<Float> set=new HashSet<>();
		for(int i=1;i<n;i++) {
			for(int j=i+1;j<=n;j++) {
				float fraction=(float) i/j;
				if(!set.contains(fraction)) {
					result.add(i+"/"+j);
					set.add(fraction);
				}
			}
		}
		return result;
	}

}
