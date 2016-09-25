package reading;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class simple_moving_average  extends backtest{

	
//	public ArrayList data_input(ArrayList open, ArrayList close, ArrayList high, ArrayList low, ArrayList vol, ArrayList adj_close, String name) {
//		// TODO Auto-generated constructor stub
//		
//		ArrayList total = new ArrayList();
//			total.add(open);
//			total.add(high);
//			total.add(low);
//			total.add(close);
//			total.add(vol);
//			total.add(adj_close);
//			
//	return total;
//		
		
	//}
  
    
	public  double  sma( String name,int lag,int date) throws ClassNotFoundException, SQLException{
		
	    double sm=0;

	    
		int counter=0;
	

		  while ((lag-counter  ) >0) {
			 {  int t = date - counter;
				 String query = "SELECT * FROM "+ name+ " WHERE rowid = ";
				 try{ 
				 ResultSet rss = stmt.executeQuery(query+t);
			
				// System.out.print(rss.getDouble("open"));
				 sm = sm + rss.getDouble("open");
				 
//				 System.out.print(rss.getDouble("open"));
			
			  }
			catch(SQLException w ) {continue;}} counter++;
		  }
		 // System.out.println(sm/lag);
		return sm/lag;
		  
	}
}