package practices;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.RestoreAction;

public class ReverseBits {

	public static void main(String[] args) {
		reverse(5);
		

	}
	private static int reverse(int n) {
		int res=0;
		while(n>0) {
			res<<=1;
			if((n&1)>0)
				res++;
			n>>=1;
		}
		return res;
	}

}
