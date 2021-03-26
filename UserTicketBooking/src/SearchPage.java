import java.util.*;

public class SearchPage {

	Scanner stno = new Scanner(System.in);
	String[] seatno = new String[10];
	Scanner busselct = new Scanner(System.in);
	int travelsName;
	Scanner sorgn = new Scanner(System.in);
	Scanner sdestn = new Scanner(System.in);
	PassengerDetails b1 = new PassengerDetails();
	int count;
	int fare;
	int totFare;
	String operatorName;
	ArrayList<String> seatnumbers = new ArrayList<String>();

	void busDetails(String fromRoute, String toRoute) {
		HashMap<Integer, String> Froute = new HashMap<Integer, String>();
		HashMap<Integer, String> Troute = new HashMap<Integer, String>();
		Froute.put(65, "chennai");
		Froute.put(60, "bangalore");
		Froute.put(70, "hyderabad");
		Froute.put(55, "coimbatore");
		Froute.put(90, "madurai");
		Troute.put(65, "chennai");
		Troute.put(60, "bangalore");
		Troute.put(70, "hyderabad");
		Troute.put(55, "coimbatore");
		Troute.put(90, "madurai");
		Troute.put(19, "salem");
		String Frm = fromRoute;
		String Tor = toRoute;
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
				travelsName = busselct.nextInt();
				switch (travelsName) {
				case 1: {
					System.out.println("Travels Name: Parveen Travels");
					operatorName = "Parveen Travels";
					fare = 800;
					seatSelection(Frm, Tor, fare, operatorName);
					break;
				}
				case 2: {
					System.out.println("Travels Name: Muthu Travels");
					operatorName = "Muthu Travels";
					fare = 650;
					seatSelection(Frm, Tor, fare, operatorName);
					break;
				}
				case 3: {
					System.out.println("Travels Name: SRM Travels");
					operatorName = "SRM Travels";
					fare = 750;
					seatSelection(Frm, Tor, fare, operatorName);
					break;
				}
				case 4: {
					System.out.println("Travels Name: YBM Travels");
					operatorName = "YBM Travels";
					fare = 600;
					seatSelection(Frm, Tor, fare, operatorName);
					break;
				}
				case 5: {
					System.out.println("Travels Name: King Travels");
					operatorName = "King Travels";
					fare = 700;
					seatSelection(Frm, Tor, fare, operatorName);
					break;
				}
				case 6: {
					System.out.println("Travels Name: Sree Kannathal Travels");
					operatorName = "Sree Kannathal Travels";
					fare = 750;
					seatSelection(Frm, Tor, fare, operatorName);
					break;
				}
				case 7: {
					System.out.println("Travels Name: Apple Travels");
					operatorName = "Apple Travels";
					fare = 780;
					seatSelection(Frm, Tor, fare, operatorName);
					break;
				}
				case 8: {
					System.out.println("Travels Name: National Travels");
					operatorName = "National Travels";
					fare = 800;
					seatSelection(Frm, Tor, fare, operatorName);
					break;
				}
				case 9: {
					System.out.println("Travels Name: Sharma Transport");
					operatorName = "Sharma Transport";
					fare = 690;
					seatSelection(Frm, Tor, fare, operatorName);
					break;
				}
				case 10: {
					System.out.println("Travels Name: GeePee Travels");
					operatorName = "GeePee Travels";
					fare = 850;
					seatSelection(Frm, Tor, fare, operatorName);
					break;
				}
				default: {
					System.out.println("Wrong Input!Please select again..");
				}
				}
			} else {
				System.out.println("Oops...Sorry! There is no bus service for the particular route.Try Again");
				int n = 1;
				for (int k = 0; k < n; k++) {
					System.out.println("Enter From Station: ");
					Frm = sorgn.nextLine();
					System.out.println("Enter To Station: ");
					Tor = sdestn.nextLine();
					if (Frm.equals(Tor)) {
						System.out.println("Source and Destination cannot be same, Please try again");
						n++;
					}
				}
				j++;
			}
		}
	}

	void seatSelection(String frte, String trte, int fare, String operatorName) {
		String fstn = frte;
		String tstn = trte;
		int price = fare;
		String busname = operatorName;
		int j = 1;
		System.out.println("Bus Type: 2+2 Semi Sleeper A/c Multi-Axle Volvo");
		System.out.println("Please Check the below available seats");
		seatnumbers.add("23");
		seatnumbers.add("12W");
		seatnumbers.add("7SL");
		seatnumbers.add("8SL");
		seatnumbers.add("20");
		seatnumbers.add("21W");
		seatnumbers.add("14");
		seatnumbers.add("15W");
		seatnumbers.add("16");
		seatnumbers.add("17W");
		Iterator<String> itr = seatnumbers.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}
		for (int i = 0; i < j; i++) {
			System.out.println("Please enter Seat number with comma separator:");
			seatno = stno.nextLine().split(","); // Important concept to split a value using comma separator
			for (String w : seatno) {
				if (seatnumbers.contains(w) || seatnumbers.contains(w.toUpperCase()))
					count = count + 1;
				else {
					System.out.println("Sorry Selected seat not available or already booked");
					j++;
					break;
				}
			}
		}

		b1.userDetails();
		// System.out.println("Route : " + fstn + " to " + tstn);
		count = 0;
		for (String w : seatno) {
			System.out.println(w.toUpperCase());
			count = count + 1;
		}
		totFare = price * count;
		// System.out.println("Total booked Seat numbers :" + count);
		// System.out.println("Total Fare: " + totprice);
		b1.printTicket(fstn, tstn, seatno, count, totFare, price, busname);
		seatnumbers.clear();
	}

}
