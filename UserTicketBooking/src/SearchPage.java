import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

public class SearchPage {

	Scanner stno = new Scanner(System.in);
	String[] seatno = new String[10];
	Scanner busselct = new Scanner(System.in);
	int travelsName;
	Scanner sorgn = new Scanner(System.in);
	Scanner sdestn = new Scanner(System.in);
	PassengerDetails b1 = new PassengerDetails();
	int count, operatorId;
	int fare;
	int totFare;
	String operatorName;
	int routeId;
	String busType;
	ArrayList<String> seatnumbers = new ArrayList<String>();

	void busDetails(String fromRoute, String toRoute) {
		String origin = fromRoute;
		String destination = toRoute;
		int j = 1;
		for (int i = 0; i < j; i++) {
			try {

				Class.forName("com.mysql.jdbc.Driver");
				Connection cont = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "arul");
				PreparedStatement stmt = cont.prepareStatement(
						"select source,destination,route_id from route_details where source= ? and destination= ?");
				stmt.setString(1, origin);
				stmt.setString(2, destination);
				ResultSet rs = stmt.executeQuery();
				if (rs.next()) {
					origin = rs.getString("source");
					destination = rs.getString("destination");
					routeId = rs.getInt("route_id");
					PreparedStatement ps = cont.prepareStatement(
							"select id,operator_name,bus_type,fare from operator_details where route_id = ?");
					ps.setInt(1, routeId);
					ResultSet res = ps.executeQuery();
					while (res.next()) {
						travelsName = res.getInt("id");
						operatorName = res.getString("operator_name");
						busType = res.getString("bus_type");
						fare = res.getInt("fare");
						System.out.println(+travelsName + ". Travels Name: " + operatorName);
						System.out.println("Bus Type: " + busType);
						System.out.println("Fare: " + fare);
					}
					System.out.println("Please enter your Travels number");
					travelsName = busselct.nextInt();
					PreparedStatement pre = cont
							.prepareStatement("select operator_name,fare from operator_details where id = ?");
					pre.setInt(1, travelsName);
					ResultSet rst = pre.executeQuery();
					if (rst.next()) {
						operatorName = rst.getString("operator_name");
						fare = rst.getInt("fare");
						seatSelection(origin, destination, fare, operatorName);
					}
				} else {
					System.out.println("Oops...Sorry! There is no bus service for the particular route.Try Again");
					int n = 1;
					for (int k = 0; k < n; k++) {
						System.out.println("Enter From Station: ");
						origin = sorgn.nextLine();
						System.out.println("Enter To Station: ");
						destination = sdestn.nextLine();
						if (origin.equals(destination)) {
							System.out.println("Source and Destination cannot be same, Please try again");
							n++;
						}
					}
					j++;
				}
				cont.close();
			} catch (Exception e) {
				e.printStackTrace();
				PassengerDetails.myLog();
			}
		}
	}

	void seatSelection(String fRoute, String tRoute, int fare, String operator) {
		String fromStation = fRoute;
		String toStation = tRoute;
		int price = fare;
		String busname = operator;
		int j = 1;
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
		count = 0;
		for (String w : seatno) {
			System.out.println(w.toUpperCase());
			count = count + 1;
		}
		totFare = price * count;
		b1.printTicket(fromStation, toStation, seatno, count, totFare, price, busname);
		seatnumbers.clear();
	}

}
