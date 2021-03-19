
import java.util.*;

public class BusTicketBooking {

	public static void main(String[] args) {

		Scanner num = new Scanner(System.in);
		int no;
		UserRegistration s1 = new UserRegistration();
		// PassengerDetails s2 = new PassengerDetails();
		do {
			System.out.println("Please enter your Option:");
			System.out.println("Press '1' For Login");
			System.out.println("Press '2' for Registration");
			System.out.println("Press '3' for View Tickets");
			System.out.println("Press '4' To Exit");
			no = num.hasNextInt() ? num.nextInt() : 4;
			switch (no) {
			case 1: {
				s1.LoginValidation();
				break;
			}
			case 2: {
				s1.UserRegister();
				break;
			}
			case 3: {
				PassengerDetails.ViewTickets();
				break;
			}
			case 4: {
				System.out.println("Thank you");
				break;
			}
			default: {
				System.out.println("Enter wrong number Thank you!");
			}
			}
<<<<<<< HEAD
		} while (no != 3);
		s2.ViewTickets();
		// s1.show();;
=======

		} while (no != 4);
		// s1.show();
>>>>>>> refs/remotes/origin/branch1
		num.close();
	}

}
