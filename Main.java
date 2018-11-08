package aplab7;
import java.sql.*;
import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String firstName, lastName, month; int reg;
		Statement stmt; int action=-1;
		ResultSet rs;
		Connection connect = null;
		try {
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            connect = DriverManager
                    .getConnection("jdbc:mysql://localhost/aplab7?"
                            + "user=root&password=");

    		while (action!=5 && connect.isValid(100)) {
    			firstName = ""; lastName =""; month =""; reg = -1;
    			//Options
    		System.out.println("You can perform the following Actions from the Fee Slip:");
    		System.out.println("1. Store Data to Database");
    		System.out.println("2. Display Data To Output");
    		System.out.println("3. Update Data to Database");
    		System.out.println("4. Delete Data to Database");
    		System.out.println("5. Quit");
    			//Choose Options		
    		action = input.nextInt();
    		while (!(action >= 1 && action <= 5)) {
    		System.out.println("Undefined input please choose again:");
    		action = input.nextInt();
    		}
    			//Operating on Options
    		//Store data into database;
    		if (action == 1)
    		{
    			System.out.println("Enter First Name: ");
    			firstName = input.next();

    			System.out.println("Enter Last Name: ");
    			lastName = input.next();

    			System.out.println("Enter Month: ");
    			month = input.next();

    			System.out.println("Enter Registration: ");
    			reg = input.nextInt();
    			//Todo
    			try {
    			stmt = connect.createStatement();
    			System.out.println("The Executed Query: insert into feeslip (first_name, last_name,"
    					+ " month, registration) values  (\""+firstName+"\""+","+"\""+lastName+"\""+","+"\""+month+"\""+","+reg+")" );
    			stmt.executeUpdate("insert into feeslip (first_name, last_name,"
    					+ " month, registration) values  (\""+firstName+"\""+","+"\""+lastName+"\""+","+"\""+month+"\""+","+reg+")" );
    			System.out.println("The Data has been entered to the feeslip table.");
    			}
    			catch(SQLException se) {
    				System.out.println(se.getMessage());
    			}
    		}
    		//Display Data To Output
    		else if ( action == 2 ) {
    			System.out.println("Enter Registration: ");
    			reg = input.nextInt();
    			stmt = connect.createStatement();
    			rs = stmt.executeQuery("Select * from feeslip where registration = "+reg);
    			if (rs.next()) {
    			System.out.println("The First Name: "+rs.getString("first_name") + "\nLast Name: "+rs.getString("last_name"));
    			System.out.println("Registration: "+rs.getString("month"));
    			System.out.println("Month: "+rs.getInt("registration"));
    			System.out.println("Time Stamp: "+rs.getTimestamp("date"));
    			}
    			else {
    				System.out.println("No Such record exists in the Database try again!");
    			}
    			}
    		//Update Data in Database
    		else if (action == 3)
    		{
    			
    			try {
        			System.out.println("Enter Registration: ");
        			reg = input.nextInt();
        			stmt = connect.createStatement();
        			int fnchoice = 0;
        			int lnchoice = 0;
        			int mchoice = 0;
        			
        			System.out.println("Do you want to change first name (0/1): ");
        			
        			fnchoice = input.nextInt();
        			String Querytoupdate = "update feeslip set";
        			
        			if (fnchoice == 1)
        			{
        				System.out.println("Enter New Name: ");
        				firstName = input.next();
        				Querytoupdate += " first_name="+"'"+firstName+"',";
        			}
        			
        			System.out.println("Do you want to change last name (0/1): ");
        			lnchoice = input.nextInt();
        			
        			if (lnchoice == 1)
        			{
        				System.out.println("Enter Last Name: ");
        				lastName = input.next();
        				Querytoupdate += " last_name="+"'"+lastName+"',";
        			}
        			
        			System.out.println("Do you want to change Month (0/1): ");
        			mchoice = input.nextInt();
        			
        			if (mchoice == 1)
        			{
        				System.out.println("Enter New Month: ");
        				month = input.next();
        				Querytoupdate += " month="+"'"+month+"'";
        			}
        			Querytoupdate+= " where registration = "+reg;
        			System.out.println(Querytoupdate);
        			
        			
        			stmt = connect.createStatement();
        			stmt.executeUpdate(Querytoupdate);
        			}
        			catch(SQLException se)
        			{
        			System.out.println(se.getMessage());
        			}
    		}
    		//Delete Data from the Database
    		else if ( action == 4)
    		{
    			try {
    			System.out.println("Enter Registration: ");
    			reg = input.nextInt();
    			stmt = connect.createStatement();
    			stmt.executeUpdate("Delete from feeslip where registration ="+reg);
    			}
    			catch(SQLException se)
    			{
    			System.out.println(se.getMessage());
    			}
    			}
    		//Quitting
    		else if (action  == 5)
    			break;
    		}

		}
		catch (SQLException se)
		{
			System.out.println(se.getMessage());
		}
		catch (ClassNotFoundException cnfe)
		{
			System.out.println(cnfe.getMessage());
		}		
		
	}
}
