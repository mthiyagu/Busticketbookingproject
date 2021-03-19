
import java.util.*;

public class PassengerDetails {

	Scanner passenger = new Scanner(System.in);
	static String cname;
	Scanner scan = new Scanner(System.in);
	static int age;
	Scanner cgen = new Scanner(System.in);
	static String gen;
	static int mobno;
	static String source;
	static String destination;
	static String[] seatnumbers;
	static int totseats;
	static int totfare;

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
		System.out.println("Passenger Name:  " + cname);
		System.out.println("Age:  " + age);
		System.out.println("Gender:  " + gen);
		System.out.println("Mobile Number :  " + mobno);

	}

	void PrintTicket(String fstn, String tstn, String[] seatno, int count, int totprice) {
		source=fstn;
		destination=tstn;
		seatnumbers=seatno;
		totseats=count;
		totfare=totprice;
		
		System.out.println("Route : " + source + " to " + destination);
		System.out.println("Total booked Seat numbers :" + totseats);
		System.out.println("Total Fare: " + totfare);

	}

	static void ViewTickets() {
		System.out.println("Confirmed Ticket ");
		System.out.println("Route : " + source + " to " + destination);
		System.out.println("Passenger Name:  " + cname);
		System.out.println("Age:  " + age);
		System.out.println("Gender:  " + gen);
		System.out.println("Mobile Number :  " + mobno);
		for (String w : seatnumbers) {
			System.out.println(w.toUpperCase());
		}
		System.out.println("Total booked Seat numbers :" + totseats);
		System.out.println("Total Fare: " + totfare);
	}
}
