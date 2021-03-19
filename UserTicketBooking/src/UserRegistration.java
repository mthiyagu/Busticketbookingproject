import java.util.*;

public class UserRegistration {

// Getting Input for User Registration 	
	Scanner usrname = new Scanner(System.in);
	String uname;
	Scanner pwd = new Scanner(System.in);
	String pass;
	Scanner cpwd = new Scanner(System.in);
	String cpass;
	Scanner mnum = new Scanner(System.in);
	int mno;
	int value;
// User login Validation	
	Scanner lvusrname = new Scanner(System.in);
	String lvname;
	Scanner lvpwd = new Scanner(System.in);
	String lgnpwd;
// Getting user input for Origin and Destination
	Scanner orgn = new Scanner(System.in);
	String org;
	Scanner Destn = new Scanner(System.in);
	String dstation;
	SearchPage sp1 = new SearchPage();
	PassengerDetails pd1 = new PassengerDetails();

	void UserRegister() {
		System.out.println("Please enter your user name");
		uname = usrname.nextLine();
		System.out.println("Enter  password");
		pass = pwd.nextLine();
		System.out.println("Enter Confirm Password: ");
		cpass = cpwd.nextLine();
		if (!pass.equals(cpass)) {
			System.out.println("Password Mismatch! Please enter correct password");
			cpass = cpwd.nextLine();
		}
		System.out.println("Enter your Mobile number: ");
		mno = mnum.nextInt();
		System.out.println("Registration done successfully");
	}

	void LoginValidation() {
		int n = 1;
		for (int i = 0; i < n; i++) {
			System.out.println("Enter Your Username: ");
			lvname = lvusrname.nextLine();
			System.out.println("Enter password:");
			lgnpwd = lvpwd.nextLine();
			if (lvname.equals(uname) && lgnpwd.equals(pass)) {
				System.out.println("Welcome: " + lvname);
				System.out.println("Enter 1.Search Result");
				System.out.println("Enter 2. View Ticket");
				value = mnum.nextInt();
				switch (value) {
				case 1: {
					Search();
					break;
				}
				case 2: {
					PassengerDetails.ViewTickets();
					break;
				}
				default: {
					System.out.println("Please enter the right number.");
				}
				}

			} else {
				System.out.println("Invalid Username or password OR Please Register if not register ");
				n++;
			}
		}
	}

	void Search() {

		int j = 1;
		for (int i = 0; i < j; i++) {
			System.out.println("Enter From Station: ");
			org = orgn.nextLine();
			System.out.println("Enter To Station: ");
			dstation = Destn.nextLine();
			if (org.equals(dstation)) {
				System.out.println("origin and destination cannot be same");
				j++;
			}
		}

		sp1.BusDetails(org, dstation);
	}

	void Show() {
		System.out.println("Your Name is: " + uname);
		System.out.println("Password : " + pass);
		System.out.println("Mobile Num: " + mno);
	}
}