package geektest;

public class ReverseWords {

	public static void main(String[] args) {
		String s = "i.like.this.program.very.much";
		
		String[] sarr=s.split("\\.");
		StringBuilder sb=new StringBuilder();
		for(int i=sarr.length-1;i>=0;i--) {
			sb.append(sarr[i]).append(".");
		}
		sb.deleteCharAt(sb.length()-1);
		System.out.println(sb.toString());
	}

}
