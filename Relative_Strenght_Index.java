package reading;

import java.sql.ResultSet;
import java.sql.SQLException;


public class Relative_Strenght_Index  extends backtest {

	public double RSI(String name, int time_frame1, int date){
		
		int counter = time_frame1;
		
		double up=0;
		double down=0;
		
		while ((counter - time_frame1 ) >0) 
		  {
				   
					 int t = date - counter;
					 String query = "SELECT * FROM "+ name+ " WHERE rowid = ";
					 try
					 {
					 ResultSet rsss3 = stmt.executeQuery(query+t);
					// System.out.print(rss.getDouble("open"));
					 
					 if(rsss3.getDouble("high")  -rsss3.getDouble("open") > 0)
					 {
						 up=up +rsss3.getDouble("high")  -rsss3.getDouble("open") ;
					 }
					 else 
						 down=down+ rsss3.getDouble("high")  -rsss3.getDouble("open");
					 
					 counter--;
					// System.out.print(rss.getDouble("open"));
				  }
					 catch(SQLException w ) {continue;}
			} 
		
		double RSI= 100/(1- up/(down+1));
		return RSI;
		  }
	}

