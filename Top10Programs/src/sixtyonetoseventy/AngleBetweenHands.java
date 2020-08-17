package sixtyonetoseventy;

public class AngleBetweenHands {

	public static void main(String[] args) {
		System.out.println(angleClock(12,30));

	}
	private static double angleClock(int hour,int minutes) {
		float angle=0;
		float h=(hour%12+(float)minutes/60)*30;
		float m=minutes*6;
		angle=Math.abs(h-m);
		if(angle>180)
			angle=360-angle;
		return angle;
	}

}
