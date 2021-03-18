
import java.util.*;

public class PassengerDetails {

	Scanner passenger = new Scanner(System.in);
	static String cname;
	Scanner scan = new Scanner(System.in);
	static int age;
	Scanner cgen = new Scanner(System.in);
	static String gen;
	static int mobno;

	void UserDetails() {
		System.out.println("Please enter Passenger name: ");
		cname = passenger.nextLine();
		System.out.println("Enter Age: ");
		age = scan.nextInt();
		System.out.println("Enter Gender: ");
		gen = cgen.nextLine();
		System.out.println("Enter Mobile number: ");
		mobno = scan.nextInt();
		System.out.println("Congratulation! Your ticket booked successfully ");
		ViewTickets();

	}

	static void ViewTickets() {
		System.out.println("Confirmed Ticket ");
		System.out.println("Passenger Name:  " + cname);
		System.out.println("Age:  " + age);
		System.out.println("Gender:  " + gen);
		System.out.println("Mobile Number :  " + mobno);
	}
}
