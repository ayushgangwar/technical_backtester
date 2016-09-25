package reading;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;


public class Stochastic_KD  extends backtest{
	public double stochastic(String name,int rowid,int lookback) throws SQLException{
		
		
		String query1="SELECT * FROM " + name+ " limit "+ rowid+ "," + lookback;
		
		
		ResultSet rs = stmt.executeQuery(query1+rowid);
		
		double close= rs.getDouble("close");
		
		ArrayList<Double> lookbackprice_LOW= new ArrayList();
		ArrayList<Double> lookbackprice_high= new ArrayList();
		
		DescriptiveStatistics ds = new DescriptiveStatistics();
		DescriptiveStatistics ds2 = new DescriptiveStatistics();
		for(int i =lookback;i>0;i--){
			ResultSet rs2=stmt.executeQuery(query1+ (rowid - i) );
	
			ds.addValue(rs2.getDouble("low"));
			ds2.addValue(rs2.getDouble("high"));
			
		}
	  double lowest_low=ds.getMin();
	  double highest_high=ds2.getMax();
	
	  double k= (close - lowest_low)/(highest_high-lowest_low) ;
	  
		return k;
		
	}

}
