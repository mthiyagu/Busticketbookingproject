import java.util.*;

public class SearchPage {

	Scanner stno = new Scanner(System.in);
	String[] seatno;
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
	Scanner sorgn = new Scanner(System.in);
	Scanner sdestn = new Scanner(System.in);
	BusMap b1 = new BusMap();
	int count = 0;
	int fare;

	void BusDetails(String Fromroute, String Toroute) {
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

		int j = 1;
		for (int i = 0; i < j; i++) {
			if (Froute.containsValue(Frm) && Troute.containsValue(Tor)) {
				System.out.println("Please Choose your bus: ");
				System.out.println("1. Parveen Travels 2+1 Sleeper A/c Rs.800");
				System.out.println("2. Muthu Travels 2+2 Semi-Sleeper non a/c Rs.650");
				System.out.println("3. SRM Travels 2+2 Semi-Sleeper Multi-Axle Volvo Rs.750");
				System.out.println("4. YBM Travels 2+2 Seater non-A/c Rs.600");
				System.out.println("5. King Travels 2+2 Semi-Sleeper A/c Rs.700");
				System.out.println("6. Sree Kannathal Travels 2+1 Sleeper non A/c Rs.750 ");
				System.out.println("7. Apple Travels 2+2 Semi-Sleeper A/c Rs.780");
				System.out.println("8. National Travels 2+1 Sleeper non a/c Rs.800");
				System.out.println("9. Sharma Transport 2+2 Seater A/c Rs.690");
				System.out.println("10. GeePee Travels 2+2 Semi-Sleeper A/c Rs.850");
				bsname = busselct.nextInt();
				switch (bsname) {
				case 1: {
					System.out.println("Travels Name: Parveen Travels");
					fare = 800;
					SeatSelection(Frm, Tor, fare);
					break;
				}
				case 2: {
					System.out.println("Travels Name: Muthu Travels");
					fare = 650;
					SeatSelection(Frm, Tor, fare);
					break;
				}
				case 3: {
					System.out.println("Travels Name: SRM Travels");
					fare = 750;
					SeatSelection(Frm, Tor, fare);
					break;
				}
				case 4: {
					System.out.println("Travels Name: YBM Travels");
					fare = 600;
					SeatSelection(Frm, Tor, fare);
					break;
				}
				case 5: {
					System.out.println("Travels Name: King Travels");
					fare = 700;
					SeatSelection(Frm, Tor, fare);
					break;
				}
				case 6: {
					System.out.println("Travels Name: Sree Kannathal Travels");
					fare = 750;
					SeatSelection(Frm, Tor, fare);
					break;
				}
				case 7: {
					System.out.println("Travels Name: Apple Travels");
					fare = 780;
					SeatSelection(Frm, Tor, fare);
					break;
				}
				case 8: {
					System.out.println("Travels Name: National Travels");
					fare = 800;
					SeatSelection(Frm, Tor, fare);
					break;
				}
				case 9: {
					System.out.println("Travels Name: Sharma Transport");
					fare = 690;
					SeatSelection(Frm, Tor, fare);
					break;
				}
				case 10: {
					System.out.println("Travels Name: GeePee Travels");
					fare = 850;
					SeatSelection(Frm, Tor, fare);
					break;
				}
				default: {
					System.out.println("Wrong Input!Please select again..");
				}
				}
			} else {
				System.out.println("Oops...Sorry! There is no bus service for the particular route. Thank you");
				System.out.println("Enter From Station: ");
				Frm = sorgn.nextLine();
				System.out.println("Enter To Station: ");
				Tor = sdestn.nextLine();
				j++;

			}
		}
		busselct.close();
	}

	void SeatSelection(String frte, String trte, int totfare) {
		String fstn = frte;
		String tstn = trte;
		int totprice = totfare;
		System.out.println("Bus Type: 2+2 Semi Sleeper A/c Multi-Axle Volvo");
		b1.SeatBusMap();
		System.out.println("Please enter Seat number with comma separator:");
		seatno = stno.nextLine().split(","); // Import concept to split a value using comma separator
		System.out.println("Please enter Passenger name: ");
		cname = cusname.nextLine();
		System.out.println("Enter Age: ");
		age = cage.nextInt();
		System.out.println("Enter Gender: ");
		gen = cgen.nextLine();
		System.out.println("Enter Mobile number: ");
		mobno = cmob.nextLine();
		System.out.println("Congratulation! Your ticket booked successfully ");
		System.out.println("Route : " + fstn + " to " + tstn);
		System.out.println("Passenger Name:  " + cname);
		System.out.println("Age:  " + age);
		System.out.println("Gender:  " + gen);
		for (String w : seatno) {
			System.out.println(w);
			count = count + 1;
		}
		totprice = totprice * count;
		System.out.println("Total booked Seat numbers :" + count);
		System.out.println("Total Fare: " + totprice);
		// System.out.println("Seat No: " + seatno);
		System.out.println("Mobile Number :  " + mobno);
		stno.close();
	}

}
