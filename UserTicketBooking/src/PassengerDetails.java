
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;

public class PassengerDetails {

	public static Logger log1 = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

	public static void myLog() {
		log1.setLevel(Level.INFO);
		log1.info("Error on SQL fields! Please check");

	}

	
	static void sqlConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "arul");
			PreparedStatement rec = con.prepareStatement(
					"insert into ticket_details(operator_name,source,destination,pax_name,age,gender,fare,mobile_no,seat_no,tot_seats,tot_fare) values (?,?,?,?,?,?,?,?,?,?,?)");
			rec.setString(1, travelsName);
			rec.setString(2, source);
			rec.setString(3, destination);
			rec.setString(4, customerName);
			rec.setInt(5, age);
			rec.setString(6, gender);
			rec.setInt(7, amount);
			rec.setLong(8, mobileNumber);
			StringJoiner buf = new StringJoiner(",");
			for (String st : seatnumbers) {

				buf.add(st.toString());
				rec.setString(9, buf.toString());

			}
			rec.setInt(10, totSeats);
			rec.setInt(11, totFare);
			rec.executeUpdate();
			System.out.println("Record updated");
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
			myLog();
		}
	}

	Scanner passenger = new Scanner(System.in);
	static String customerName;
	Scanner scan = new Scanner(System.in);
	static int age;
	Scanner cgen = new Scanner(System.in);
	static String gender;
	static long mobileNumber;
	static String source;
	static String destination;
	static String[] seatnumbers;
	static String st;
	static int totSeats;
	static int totFare;
	static int amount;
	static String travelsName;

	void userDetails() {
		System.out.println("Please enter Passenger name: ");
		customerName = passenger.nextLine();
		System.out.println("Enter Age: ");
		age = scan.nextInt();
		System.out.println("Enter Gender: ");
		gender = cgen.nextLine();
		System.out.println("Enter Mobile number: ");
		mobileNumber = scan.nextLong();
		System.out.println("Congratulation! Your ticket booked successfully ");
		System.out.println("Travels Name: " + travelsName);
		System.out.println("Passenger Name:  " + customerName);
		System.out.println("Age:  " + age);
		System.out.println("Gender:  " + gender);
		System.out.println("Mobile Number :  " + mobileNumber);

	}

	void printTicket(String fstn, String tstn, String[] seatno, int count, int totprice, int fare, String busname) {
		source = fstn;
		destination = tstn;
		seatnumbers = seatno;
		totSeats = count;
		totFare = totprice;
		amount = fare;
		travelsName = busname;
		System.out.println("Fare: " + amount);
		System.out.println("Route : " + source + " to " + destination);
		System.out.println("Total booked Seats :" + totSeats);
		System.out.println("Total Fare: " + totFare);
		sqlConnection();

	}

	static void viewTickets() {
		System.out.println("Confirmed Ticket ");
		System.out.println("Travels Name: " + travelsName);
		System.out.println("Route : " + source + " to " + destination);
		System.out.println("Passenger Name:  " + customerName);
		System.out.println("Age:  " + age);
		System.out.println("Gender:  " + gender);
		System.out.println("Mobile Number :  " + mobileNumber);
		System.out.println("Fare: " + amount);
		System.out.println("Booked Seats");
		System.out.println(st);
//		for (String w : seatNumbers) {
//			System.out.println(w.toUpperCase());
//		}
		System.out.println("Total booked Seats :" + totSeats);
		System.out.println("Total Fare: " + totFare);

	}

	static void getDetails() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "arul");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(
					"select operator_name,source,destination,pax_name,age,gender,fare,mobile_no,seat_no,tot_seats,tot_fare from ticket_details");
			while (rs.next()) {
				travelsName = rs.getString("operator_name");
				source = rs.getString("source");
				destination = rs.getString("destination");
				customerName = rs.getString("pax_name");
				age = rs.getInt("age");
				gender = rs.getString("gender");
				amount = rs.getInt("fare");
				mobileNumber = rs.getLong("mobile_no");
				st = rs.getString("seat_no");
				totSeats = rs.getInt("tot_seats");
				totFare = rs.getInt("tot_fare");
				viewTickets();
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
			myLog();
		}
	}
}