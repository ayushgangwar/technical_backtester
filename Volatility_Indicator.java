package reading;
import java.sql.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Volatility_Indicator extends Connect_sqlite{
	Connect_sqlite sqlite = new Connect_sqlite();
	ArrayList arr = new ArrayList();
	public  ArrayList  volatiliy(String name) throws ClassNotFoundException, SQLException{
		sqlite.connect("technical_242.sqlite");
		String query = "SELECT *  FROM "+ name ;
		ResultSet rs = stmt.executeQuery(query);
		
		  while (rs.next()) {
			  arr.add((rs.getDouble("high") - rs.getDouble("low"))/(rs.getDouble("open") - rs.getDouble("close")));
		  }
		  
		return arr;
		
	}
}
