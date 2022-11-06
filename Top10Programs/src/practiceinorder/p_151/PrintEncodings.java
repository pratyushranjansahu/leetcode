package practiceinorder.p_151;
/*
    https://www.pepcoding.com/resources/online-java-foundation/recursion-on-the-way-up/print-encodings-official/ojquestion
    https://www.youtube.com/watch?v=2ClSccwnq1Y
 */
public class PrintEncodings {
    public static void main(String[] args) {
        printEncodings("655196", "");
        //feeaif
        //feesf
    }

    public static void printEncodings(String ques, String asf) {
        if(ques.length() == 0){
            System.out.println(asf);
            return;
        }else if(ques.length() == 1){
            char ch = ques.charAt(0);
            if( ch == '0'){
                return;
            }else {
                int chv = ch - '0';
                char code = (char)('a' + chv-1);
                System.out.println(asf + code);
            }
        }else {
            char ch = ques.charAt(0);
            String roq = ques.substring(1);
            if( ch == '0'){
                return;
            }else {
                int chv = ch - '0';
                char code = (char)('a' + chv-1);
                printEncodings(roq, asf+code);
            }
            String ch12 = ques.substring(0,2);
            String roq12 = ques.substring(2);
            int ch12v = Integer.parseInt(ch12);
            if( ch12v <= 26) {
                char code = (char) ('a'+ch12v-1);
                printEncodings(roq12, asf+code);
            }
        }
    }
}
