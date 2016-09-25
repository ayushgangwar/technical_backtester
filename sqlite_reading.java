package reading;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.*;
public class sqlite_reading {

	/**
	 * @param args
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		try {
			Class.forName("org.sqlite.JDBC");
			
			Connection connection = DriverManager.getConnection("jdbc:sqlite:/home/ayush/testdb.sqlite");
			Statement statement = connection.createStatement();  
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.print("DOne");
	}

}
