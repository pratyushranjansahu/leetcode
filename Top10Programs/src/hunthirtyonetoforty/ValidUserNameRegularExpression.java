//https://www.youtube.com/watch?v=PlGYb3tY-sca
public class ValidUserNameRegularExpression {

	public static void main(String[] args) {
		String userName = "Samantha";
		validateUserName(userName);

	}

	private static void validateUserName(String userName) {
		String regularExpression = "^[a-zA-Z]\\w{7,29}$";
		if (userName.matches(regularExpression)) {
			System.out.println("Valid");
		} else {
			System.out.println("Invalid");
		}
	}

}
