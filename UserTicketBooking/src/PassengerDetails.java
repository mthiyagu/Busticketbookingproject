
import java.util.*;
import java.sql.*;

public class PassengerDetails {

	static void sqlConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "arul");
			PreparedStatement rec = con.prepareStatement(
					"insert into ticket_details(operator_name,source,destination,pax_name,age,gender,fare,mobile_no,seat_no,tot_seats,tot_fare) values (?,?,?,?,?,?,?,?,?,?,?)");
			rec.setString(1, travelsname);
			rec.setString(2, source);
			rec.setString(3, destination);
			rec.setString(4, cname);
			rec.setInt(5, age);
			rec.setString(6, gen);
			rec.setInt(7, amount);
			rec.setLong(8, mobno);
			StringJoiner buf = new StringJoiner(",");
			for (String st : seatnumbers) {

				buf.add(st.toString());
				rec.setString(9, buf.toString());

			}
			rec.setInt(10, totseats);
			rec.setInt(11, totfare);
			rec.executeUpdate();
			System.out.println("Record updated");
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	Scanner passenger = new Scanner(System.in);
	static String cname;
	Scanner scan = new Scanner(System.in);
	static int age;
	Scanner cgen = new Scanner(System.in);
	static String gen;
	static long mobno;
	static String source;
	static String destination;
	static String[] seatnumbers;
	static String st;
	static int totseats;
	static int totfare;
	static int amount;
	static String travelsname;

	void userDetails() {
		System.out.println("Please enter Passenger name: ");
		cname = passenger.nextLine();
		System.out.println("Enter Age: ");
		age = scan.nextInt();
		System.out.println("Enter Gender: ");
		gen = cgen.nextLine();
		System.out.println("Enter Mobile number: ");
		mobno = scan.nextLong();
		System.out.println("Congratulation! Your ticket booked successfully ");
		System.out.println("Travels Name: " + travelsname);
		System.out.println("Passenger Name:  " + cname);
		System.out.println("Age:  " + age);
		System.out.println("Gender:  " + gen);
		System.out.println("Mobile Number :  " + mobno);

	}

	void printTicket(String fstn, String tstn, String[] seatno, int count, int totprice, int fare, String busname) {
		source = fstn;
		destination = tstn;
		seatnumbers = seatno;
		totseats = count;
		totfare = totprice;
		amount = fare;
		travelsname = busname;
		System.out.println("Fare: " + amount);
		System.out.println("Route : " + source + " to " + destination);
		System.out.println("Total booked Seats :" + totseats);
		System.out.println("Total Fare: " + totfare);
		sqlConnection();

	}

	static void viewTickets() {
		System.out.println("Confirmed Ticket ");
		System.out.println("Travels Name: " + travelsname);
		System.out.println("Route : " + source + " to " + destination);
		System.out.println("Passenger Name:  " + cname);
		System.out.println("Age:  " + age);
		System.out.println("Gender:  " + gen);
		System.out.println("Mobile Number :  " + mobno);
		System.out.println("Fare: " + amount);
		System.out.println("Booked Seats");
		System.out.println(st);
//		for (String w : seatnumbers) {
//			System.out.println(w.toUpperCase());
//		}
		System.out.println("Total booked Seats :" + totseats);
		System.out.println("Total Fare: " + totfare);

	}

	static void getDetails() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "arul");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(
					"select operator_name,source,destination,pax_name,age,gender,fare,mobile_no,seat_no,tot_seats,tot_fare from ticket_details");
			while (rs.next()) {
				travelsname = rs.getString("operator_name");
				source = rs.getString("source");
				destination = rs.getString("destination");
				cname = rs.getString("pax_name");
				age = rs.getInt("age");
				gen = rs.getString("gender");
				amount = rs.getInt("fare");
				mobno = rs.getLong("mobile_no");
				st = rs.getString("seat_no");
				totseats = rs.getInt("tot_seats");
				totfare = rs.getInt("tot_fare");
				viewTickets();
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}