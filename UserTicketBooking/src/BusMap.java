import java.util.*;

public class BusMap {

	ArrayList<String> seatnumbers = new ArrayList<String>();

	void SeatBusMap() {
		System.out.println("Please Check the below available seats");
		seatnumbers.add("1.23");
		seatnumbers.add("2.12W");
		seatnumbers.add("3.7SL");
		seatnumbers.add("4.8SL");
		seatnumbers.add("5.20");
		seatnumbers.add("6.21W");
		seatnumbers.add("7.14");
		seatnumbers.add("8.15W");
		seatnumbers.add("9.16");
		seatnumbers.add("10.17W");
		Iterator<String> i = seatnumbers.iterator();
		while (i.hasNext()) {
			System.out.println(i.next());
		}
	}
}
