package reading;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;


public class portfolio_optimizer extends portfolio_selector{
	HashMap<String,Double> weights = new HashMap();
	HashMap<String,Integer> shares = new HashMap();
	static Connect_sqlite obj=new Connect_sqlite();
	public void optimizer() throws IOException, ClassNotFoundException, SQLException{
		System.out.println("Number of stocks filtered: "+ filtered_names.size());
		System.out.println(filtered_names);
		obj.connect("technical_3mintest1.sqlite");
		//FMCG_TECH_temp9
		//
		double booksize=20000;
		double weight=0;
		portfolio_selector ps = new portfolio_selector();
		int size=ps.filtered_names.size();
		
		 HashMap<String,Double> sharpe = new HashMap();
		 Sharpe_ratio sr = new Sharpe_ratio();
		 sharpe = sr.sharpe;
		
		 HashMap<String,Double> vol = new HashMap();
		 Volatility vt = new Volatility();
		 vol=vt.Volatility;
		 
		DescriptiveStatistics stats = new DescriptiveStatistics();
		
		for(int i=0;i< size;i++){
			weight=(sharpe.get(filtered_names.get(i)));
			weights.put(filtered_names.get(i), weight);
			stats.addValue(weight);
		}
		
		
		File file = new File("optimized_portfolio.csv");
		FileWriter writer = new FileWriter(file);
		writer.write("BOOK VALUE\t");
		writer.write(String.valueOf(booksize));
		writer.write("\n"); 
		
		writer.write("Names\t");
		writer.write("Number of shares to be bought\t"); 
		writer.write("\n"); 
		
		
		double sum=stats.getMean()*size;
		for(int i=0;i< size;i++){
			double p = weights.get(filtered_names.get(i))*booksize/sum;
			String q1 = "SELECT * FROM "+ filtered_names.get(i)+" WHERE rowid = (SELECT count(*) FROM "+ filtered_names.get(i)+ " )" ;
			ResultSet rs = obj.stmt.executeQuery(q1);
			double b =(rs.getDouble("open"));
			int share = (int) (p/b);
			shares.put(filtered_names.get(i), share);
			
			writer.write(filtered_names.get(i)+"\t");
			writer.write(String.valueOf(share));
			  writer.write("\n"); 
	          writer.flush();
		}
		
	}
}
