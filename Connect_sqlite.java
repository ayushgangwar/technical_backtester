package reading;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Connect_sqlite {
	protected static Statement stmt=null; 
//	static Statement stmt2=null; 
	static Connection c;
	public void connect(String db_name) throws ClassNotFoundException, SQLException{
	String path="jdbc:sqlite:/home/ayush/"+db_name;
	
    Class.forName("org.sqlite.JDBC");
     c = DriverManager.getConnection(path);
    stmt=c.createStatement();
 //   stmt2=c.createStatement();
    
}
	public void closee() throws SQLException{
		c.close();
	}
	
}