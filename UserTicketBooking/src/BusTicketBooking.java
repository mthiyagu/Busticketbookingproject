import java.io.IOException;
import java.util.*;

public class BusTicketBooking {

	public static void main(String[] args) throws IOException {

		Scanner num = new Scanner(System.in);
		int no;
		UserRegistration s1 = new UserRegistration();
		do {
			System.out.println("Please enter your Option:");
			System.out.println("Press '1' For User Registration");
			System.out.println("Press '2' for User Login");
			System.out.println("Press '3' To Exit");
			no = num.hasNextInt()  ? num.nextInt(): 3;
			switch (no) {
			case 1: {
				s1.usrreg();
				System.out.println("Registration done successfully");
				break;
			}
			case 2: {
				s1.loginvalidation();
				break;
			}
			case 3: {
				System.out.println("Thank you");
				break;
			}

			default: {
				System.out.println("Enter wrong number Thank you!");
			}
			}

		} while (no != 3);
		//s1.show();
		num.close();
	}

}
