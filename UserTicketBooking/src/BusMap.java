import java.util.*;

public class BusMap {

	ArrayList<String> seatnumbers=new ArrayList<String>();
	
void SeatBusMap(){
	System.out.println("Please Check the below available seats");
	seatnumbers.add("1");
	seatnumbers.add("2W");
	seatnumbers.add("3SL");
	seatnumbers.add("4SL");
	seatnumbers.add("5");
	seatnumbers.add("6W");
	seatnumbers.add("7");
	seatnumbers.add("8W");
	seatnumbers.add("9");
	seatnumbers.add("10W");
	Iterator<String> i=seatnumbers.iterator();
	while(i.hasNext()) {
		System.out.println(i.next());
	}
}
}
