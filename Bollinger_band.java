package reading;



import java.sql.ResultSet;
import java.sql.SQLException;


import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;


public class Bollinger_band extends backtest {
	public  double  bollinger( String name,int lag,int date, double percent_deviaion_allowed) throws ClassNotFoundException, SQLException
	{
		
		double sm =0;
		int counter=0;
		
		  DescriptiveStatistics ds = new DescriptiveStatistics();
		  String query0 = "SELECT * FROM "+ name+ " WHERE rowid = ";
		  ResultSet rsss0 = stmt.executeQuery(query0+date);
		  double present_price= rsss0.getDouble("open");
		  while ((lag-counter  ) >0) {
			 {  int t = date - counter;
				 String query = "SELECT * FROM "+ name+ " WHERE rowid = ";
				 try{
				 ResultSet rsss = stmt.executeQuery(query+t);
				// System.out.print(rss.getDouble("open"));
				 
				 sm = sm + rsss.getDouble("open");
				 
				 ds.addValue(rsss.getDouble("open"));
				 counter++;
				// System.out.print(rss.getDouble("open"));
			  }
			catch(SQLException w ) {continue;}} 
		  }
		
		  
		  double std =ds.getStandardDeviation();
		  double upper = sm/lag + std;
		  double lower = sm/lag - std;
		  if(present_price > sm/lag && present_price <  upper*percent_deviaion_allowed){
			  return 1; 
		  }
		  else 
			  if(present_price < sm/lag && present_price <  lower*percent_deviaion_allowed)
				  return -1; 
		  else
			  return 0;
		 // System.out.println(sm/lag);
		
		
	 }
}
