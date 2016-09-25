package reading;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class True_range  extends backtest{
	public ArrayList<Double> trueRange(String name,int rowid) throws SQLException{
		
		ArrayList<Double> arr= new ArrayList();
		
		String query1="SELECT * FROM " + name+ " WHERE rowid=";
	
	
		ResultSet tr1= stmt.executeQuery(query1+ rowid);
		
		double high=tr1.getDouble("high");
		double low=tr1.getDouble("low");
		
//		tr1.next();
		ResultSet tr2= stmt.executeQuery(query1+(rowid-1));
		double prev_close=tr2.getDouble("close");
		double prev_high=tr2.getDouble("high");
		double prev_low=tr2.getDouble("low");
		double TR=Math.max(high -low , high -prev_close) ;
	    
		double Directional_index_pos= high- prev_high;
	    double Directional_index_neg= low- prev_low;

		arr.add(TR);
		arr.add(Directional_index_pos);
		arr.add(Directional_index_neg);
		
		return arr;
		
	}

}
