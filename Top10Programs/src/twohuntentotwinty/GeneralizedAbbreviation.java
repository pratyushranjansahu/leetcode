package twohuntentotwinty;
/*
    https://www.youtube.com/watch?v=LliQjLnbhx8
 */
public class GeneralizedAbbreviation {
    public static void main(String[] args) {
        String s= "pep";
        solution(s,"",0,0);
    }

    public static void solution(String word, String asf,int count, int pos){
        if (pos == word.length()) {
            if (count == 0) {
                System.out.println(asf);
            } else {
                System.out.println(asf + count);
            }
            return;
        }
        if (count > 0) {
            solution(word,asf + count + word.charAt(pos), 0,pos+1);
        }else {
            solution(word,asf + word.charAt(pos), 0,pos+1);
        }
        solution(word,asf , count + 1,pos+1);
    }
}
