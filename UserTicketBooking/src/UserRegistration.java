import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;

public class UserRegistration {

	public static Logger log = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

	public void mylog() {
		log.setLevel(Level.INFO);
		log.info("Error on SQL fields! Please check the ");

	}

// Getting Input for User Registration 	
	Scanner usrname = new Scanner(System.in);
	String username;
	Scanner pwd = new Scanner(System.in);
	String password;
	Scanner cpwd = new Scanner(System.in);
	String confirmPassword;
	Scanner mnum = new Scanner(System.in);
	long mobileNumber;
	int value;
	static int userId;
// User login Validation	
	Scanner loginUserName = new Scanner(System.in);
	String loginName;
	Scanner loginpwd = new Scanner(System.in);
	String loginPassword;
// Getting user input for Origin and Destination
	Scanner orgn = new Scanner(System.in);
	String origin;
	Scanner destn = new Scanner(System.in);
	String destination;
	SearchPage sp1 = new SearchPage();
	PassengerDetails pd1 = new PassengerDetails();

	void userRegister() {
		System.out.println("Please enter your user name");
		username = usrname.nextLine();
		System.out.println("Enter  password");
		password = pwd.nextLine();
		System.out.println("Enter Confirm Password: ");
		confirmPassword = cpwd.nextLine();
		if (!password.equals(confirmPassword)) {
			System.out.println("Password Mismatch! Please enter correct password");
			confirmPassword = cpwd.nextLine();
		}
		System.out.println("Enter your Mobile number: ");
		mobileNumber = mnum.nextLong();
		System.out.println("Registration done successfully");
		insert();
	}

	void search() {

		int j = 1;
		for (int i = 0; i < j; i++) {
			System.out.println("Enter From Station: ");
			origin = orgn.nextLine();
			System.out.println("Enter To Station: ");
			destination = destn.nextLine();
			if (origin.equals(destination)) {
				System.out.println("origin and destination cannot be same");
				j++;
			}
		}

		sp1.busDetails(origin, destination);
	}

	void show() {

		System.out.println("Your Name is: " + username);
		System.out.println("Password : " + password);
		System.out.println("Mobile Num: " + mobileNumber);
	}

	void insert() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "arul");
			PreparedStatement ps = cn
					.prepareStatement("insert into user_details(user_name,user_pwd,mob_no) values(?,?,?)");
			ps.setString(1, username);
			ps.setString(2, password);
			ps.setLong(3, mobileNumber);
			ps.executeUpdate();
			cn.close();
		} catch (Exception e) {
			e.printStackTrace();
			mylog();
		}
	}

	void getUser() {
		int n = 1;
		for (int i = 0; i < n; i++) {
			System.out.println("Enter Your Username: ");
			loginName = loginUserName.nextLine();
			System.out.println("Enter password:");
			loginPassword = loginpwd.nextLine();
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection cont = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "arul");
				PreparedStatement stmt = cont.prepareStatement(
						"select user_id,user_name,user_pwd from user_details where user_name = ? and user_pwd = ?");
				stmt.setString(1, loginName);
				stmt.setString(2, loginPassword);
				ResultSet rs = stmt.executeQuery();
				if (rs.next()) {
					userId = rs.getInt("user_id");
					username = rs.getString("user_name");
					password = rs.getString("user_pwd");
					System.out.println("Welcome: " + loginName);
					System.out.println("Enter '1' for Search Result");
					System.out.println("Enter '2' for View Ticket");
					value = mnum.nextInt();
					switch (value) {
					case 1: {
						search();
						break;
					}
					case 2: {
						PassengerDetails.getDetails();
						break;
					}
					default: {
						System.out.println("Please enter the right number.");
					}
					}
				} else {
					System.out.println("Invalid Username or Password");
					n++;
				}
				cont.close();
			} catch (Exception e) {
				e.printStackTrace();
				mylog();
			}
		}
	}
}