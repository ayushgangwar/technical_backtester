package reading;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.commons.math3.stat.regression.SimpleRegression;


public class Linear_regression extends backtest{
	public ArrayList<Double> LinearRegression(String name,int training_set){
		
		ArrayList<Double> regression_parameters= new ArrayList<Double>();
		SimpleRegression sm = new SimpleRegression();
		
		  
				   double MSE_Normalize=0;
					while(training_set > 1)
					{
					 String query = "SELECT * FROM "+ name+ " WHERE rowid = ";
					 try
					 {
					 ResultSet rsss4 = stmt.executeQuery(query + (training_set));
					//fit desired parameters 
					 ResultSet rsss5= stmt.executeQuery((query)+(training_set-1));
				
//					 System.out.println(rsss4.getDouble("close"));
//					 System.out.print(rsss5.getDouble("close"));
					 
					 //  (add.data(x,y))
					 sm.addData( rsss5.getDouble("open"),rsss4.getDouble("close"));
					 MSE_Normalize=rsss4.getDouble("close");
					 training_set--;
					 }
					 
					 catch(SQLException w ) {continue;}
					}
					
					//Add required paramters 
					regression_parameters.add(sm.getSlope());
					regression_parameters.add(sm.getIntercept());
					regression_parameters.add(sm.getMeanSquareError()/MSE_Normalize);
					regression_parameters.add(sm.getSignificance());
//					System.out.print(name);
					System.out.println(regression_parameters);
					
		return regression_parameters;
		
		
	}

}
