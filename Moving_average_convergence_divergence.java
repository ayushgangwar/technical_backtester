package reading;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;


public class Moving_average_convergence_divergence  extends backtest {

	public  double  MACD( String name,int time_frame1,int date, int time_frame2,int signal_time) throws ClassNotFoundException, SQLException
	{
		DescriptiveStatistics ds = new DescriptiveStatistics();
		int counter1=time_frame1;
		int counter2=time_frame2; 
		int counter3=signal_time;
		double sm1=0;
		double sm2=0;
		double sm3=0;
		//EMA 1
		while (( counter1 ) >0) 
		  {
				 {  
					 int t = date - counter1;
					 String query = "SELECT * FROM "+ name+ " WHERE rowid = ";
					 
					 ResultSet rsss1 = stmt.executeQuery(query+t);
					// 	 System.out.println("loop 1 ");
					 
					 sm1 = sm1+ rsss1.getDouble("open");
					 
					 
					
					// System.out.print(rss.getDouble("open"));
				  }
				
				 counter1--;  }
		//EMA 2
		while ((counter2  ) >0) 
		  {
				 {  //  System.out.println("loop 2 ");
					 int t = date - counter2;
					 String query = "SELECT * FROM "+ name+ " WHERE rowid = ";
					 try
					 {
					 ResultSet rsss2 = stmt.executeQuery(query+t);
					// System.out.print(rss.getDouble("open"));
					 
					 sm2 = sm2+ rsss2.getDouble("open");
					 
					 
					
					// System.out.print(rss.getDouble("open"));
				  }
				catch(SQLException w ) {continue;}} 
				 counter2--;  }
		//Signal 
//		
//		while ((counter3  ) >0) 
//		  {
//				 { //   System.out.println("loop 3 ");
//					 int t = date - counter3;
//					 String query = "SELECT * FROM "+ name+ " WHERE rowid = ";
//					 try
//					 {
//					 ResultSet rsss3 = stmt.executeQuery(query+t);
//					// System.out.print(rss.getDouble("open"));
//					 
//					 sm3 = sm3+ rsss3.getDouble("open");
//					 
//					 ds.addValue(rsss3.getDouble("open"));
//					
//					// System.out.print(rss.getDouble("open"));
//				  }
//				catch(SQLException w ) {continue;}} 
//				 counter3--;	  }
		  
		
		double MACDLine = sm1/time_frame1 - sm2/time_frame2 ;
	//	System.out.println(MACDLine);
	//	double signal_line = ds.getMean();
	
		
		
		return MACDLine;
		
	}
}
