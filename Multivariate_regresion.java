package reading;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class Multivariate_regresion extends backtest{
	public ArrayList<Double> MultivariateRegression(String name,int training_set) throws SQLException{

		   double MSE_Normalize=0;
			while(training_set > 1)
			{
			 String query = "SELECT * FROM "+ name+ " WHERE rowid = ";
		
			 ResultSet rsss4 = stmt.executeQuery(query + (training_set));
			//fit desired parameters 
			 ResultSet rsss5= stmt.executeQuery((query)+(training_set-1));
			 ResultSet rsss6= stmt.executeQuery((query)+(training_set-1));
			}
		return null;
		
	}

}
