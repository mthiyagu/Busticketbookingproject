import java.util.*;

public class SearchPage {

	Scanner stno = new Scanner(System.in);
	int seatno;
	Scanner cusname = new Scanner(System.in);
	String cname;
	Scanner cage = new Scanner(System.in);
	int age;
	Scanner cgen = new Scanner(System.in);
	String gen;
	Scanner cmob = new Scanner(System.in);
	String mobno;
	Scanner busselct = new Scanner(System.in);
	int bsname;

	void busdetails(String Fromroute, String Toroute) {
		HashMap<Integer, String> Froute = new HashMap<Integer, String>();
		HashMap<Integer, String> Troute = new HashMap<Integer, String>();
		Froute.put(65, "chennai");
		Froute.put(60, "bangalore");
		Froute.put(70, "hyderabad");
		Froute.put(55, "coimbatore");
		Troute.put(65, "chennai");
		Troute.put(60, "bangalore");
		Troute.put(70, "hyderabad");
		Troute.put(55, "coimbatore");
		Troute.put(90, "madurai");
		Troute.put(19, "salem");
		String Frm = Fromroute;
		String Tor = Toroute;
		
		if (Froute.containsValue(Frm) && Troute.containsValue(Tor)) {

			System.out.println("Please Choose your bus: ");
			System.out.println("Press '1' For Parveen Travels");
			System.out.println("Press '2' For Muthu Travels");
			System.out.println("Press '3' For SRM Travels");
			System.out.println("Press '4' For YBM Travels");
			bsname = busselct.nextInt();
			switch (bsname) {
			case 1: {
				System.out.println("Travels Name: Parveen Travels");
				System.out.println("Bus Type: 2+2 Semi Sleeper A/c Multi-Axle Volvo");
				System.out.println("Departure Time: 9:30PM");
				System.out.println("Fare: Rs.750");
				System.out.println("Please enter only one seat number From 1 to 44");
				seatselection(Frm, Tor);
				System.out.println("Fare: Rs.750");
				break;
			}
			case 2: {
				System.out.println("Travels Name: Muthu Travels");
				System.out.println("Bus Type: 2+1 Sleeper Non A/c");
				System.out.println("Departure Time: 8:30PM");
				System.out.println("Fare: Rs.800");
				System.out.println("Please enter only one seat numbers From 1 to 30");
				seatselection(Frm, Tor);
				System.out.println("Fare: Rs.800");
				break;
			}
			case 3: {
				System.out.println("Travels Name: SRM Travels");
				System.out.println("Bus Type: 2+2 Semi-Sleeper Non A/c");
				System.out.println("Departure Time: 10:30PM");
				System.out.println("Fare: Rs.650");
				System.out.println("Please enter only one seat numbers From 1 to 44");
				seatselection(Frm, Tor);
				System.out.println("Fare: Rs.650");
				break;
			}
			case 4: {
				System.out.println("Travels Name: YBM Travels");
				System.out.println("Bus Type: 2+2 PUSHBACK  A/c");
				System.out.println("Departure Time: 10:30PM");
				System.out.println("Fare: Rs.700");
				System.out.println("Please enter only one seat numbers From 1 to 44");
				seatselection(Frm, Tor);
				System.out.println("Fare: Rs.700");
				break;
			}
			default: {
				System.out.println("Wrong Input!Please select again..");
			}
			}
		} else {
			System.out.println("Oops...Sorry! There is no bus service for the particular route. Thank you");
		}

		busselct.close();
	}

	void seatselection(String frte, String trte) {
		String fstn = frte;
		String tstn = trte;
		seatno = stno.nextInt();
		System.out.println("Please enter customer name: ");
		cname = cusname.nextLine();
		System.out.println("Please mention Age: ");
		age = cage.nextInt();
		System.out.println("Please Enter Gender: ");
		gen = cgen.nextLine();
		System.out.println("Enter Mobile number: ");
		mobno = cmob.nextLine();
		System.out.println("Congratulation! Your ticket booked successfully ");
		System.out.println("Route : " + fstn + " to " + tstn);
		System.out.println("Passenger Name:  " + cname);
		System.out.println("Age:  " + age);
		System.out.println("Gender:  " + gen);
		System.out.println("Seat No:  " + seatno);
		System.out.println("Mobile Number :  " + mobno);

	}

}
