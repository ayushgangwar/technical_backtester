package reading;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.stat.correlation.Covariance;
import org.apache.commons.math3.stat.correlation.PearsonsCorrelation;
import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import org.apache.commons.math3.*;


import com.opencsv.CSVReader;

public class Covariance_matrix extends backtest{
	
	public static void covariance() throws ClassNotFoundException, SQLException, IOException{
		
		ArrayList<String> names= new ArrayList();
	
		RealMatrix mx =MatrixUtils.createRealMatrix(31797,5);
		CSVReader reader = new CSVReader(new FileReader("/media/ayush/Seagate Expansion Drive/workspace/final_project_main/portfolio.csv"), '\t', '\'', 1);
		String[] nextline;
		double covv[][]=new double[31797][250];
		int column=0;
		int COUNTER=0;
		while((nextline=reader.readNext())!=null){
			COUNTER++;
			System.out.println(nextline[0]);	
			names.add(nextline[0]);
		
			
			for(int i =0; i< 31797;i++)
			{
			
			try{
				String query = "SELECT open FROM "  + (nextline[0]).toLowerCase() + " WHERE rowid = ";
				
				ResultSet name=stmt.executeQuery(query+i);
				
				covv[i][column]= name.getDouble("open");
				//System.out.print(covv[i][column]);
				
			}
			catch(SQLException e ) {}
			
			}	
			System.out.println();
			column++;
		
			
	}
		reader.close();
		
		RealMatrix mxb = new  PearsonsCorrelation().computeCorrelationMatrix(covv);
		System.out.print(mxb.getColumnDimension());
		correlationFileCreator(mxb,names);
	
		
}
	public static void correlationFileCreator(RealMatrix mxb,ArrayList<String> names) throws IOException{
		File file = new File("Correlation matrix.csv");
		FileWriter fw = new FileWriter(file);
		fw.write(String.valueOf("\t"));
		for(int i =0; i < names.size();i++){
			fw.write(names.get(i));
			fw.write(String.valueOf("\t"));
			}
		fw.write("\n");
		for(int i =0; i < names.size();i++){
			fw.write(names.get(i));
			fw.write(String.valueOf("\t"));
			for(int j =0; j < names.size();j++){
				fw.write(String.valueOf(mxb.getColumn(i)[j]));
				fw.write(String.valueOf("\t"));
			}
			fw.write("\n");
		}
		fw.flush();
		fw.close();
		
	}
}
