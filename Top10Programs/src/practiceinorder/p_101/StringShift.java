package practiceinorder.p_101;

/*
	https://www.youtube.com/watch?v=7XiNDRJk9Pk
 */
public class StringShift {

	public static void main(String[] args) {
		//String s="";
		//List<List<Integer>> list=new ArrayList<>();
		/*String str="abcdefg";
		List<List<Integer>> list=new ArrayList<>();
		List<Integer> l1=new ArrayList<>();
		l1.add(1);
		l1.add(1);
		list.add(l1);
		
		List<Integer>  l2=new ArrayList<>();
		l2.add(1);
		l2.add(1);
		list.add(l2);
		
		List<Integer>  l3=new ArrayList<>();
		l3.add(0);
		//l3.add(5);
		l3.add(8);
		//l3.add(2);
		list.add(l3);
		
		List<Integer>  l4=new ArrayList<>();
		l4.add(1);
		l4.add(3);
		list.add(l4);
		System.out.println(shift(str,list));*/

		/*String s1 = "abc";
		int[][] l = {{0,1},{1,2}};
		System.out.println(shift(s1,l));*/


		String s1 = "abcdefg";
		int[][] l = {{1,1},{1,1},{0,2},{1,3}};
		System.out.println(shift(s1,l));
	}
	
	private static String shift(String s,int[][] shift) {
		int n = s.length();
		String tmp = "";
		for (int i = 0; i < shift.length; i++) {
			tmp = "";
			if (shift[i][0] == 1){
				tmp = tmp + s.substring(n - shift[i][1]);
				tmp = tmp + s.substring(0,n - shift[i][1]);
			}else {
				tmp = tmp + s.substring(shift[i][1]);
				tmp = tmp + s.substring(0,shift[i][1]);
			}
			s = tmp;
		}
		return s;
	}

}
