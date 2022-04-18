package hunfortytofifty;

public class BulbSwitcher {

    public static void main(String[] args) {
        int n = 4;
        System.out.println(bulbSwitch(n));
    }
    public static int bulbSwitch(int n) {
        int count = 0;
        for(int i=1 ; i*i <=n ; i++)
            count++;
        return count;
    }

}
