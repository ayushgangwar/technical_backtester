package reading;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

public class Sharpe_ratio {
	static double beta_mean = 0;
	public static HashMap<String, Double> sharpe = new HashMap();

	public void sharpe(ArrayList<Double> return_per, String name) throws IOException {
		double mean = 0;
		double sum = 0;

		DescriptiveStatistics stats = new DescriptiveStatistics();

		for (int i = 0; i < return_per.size(); i++) {
			stats.addValue((double) return_per.get(i));
			

		}
	//	mean = stats.getMean();
		double std = 0;
		sum=stats.getSum();
		std = stats.getStandardDeviation();

//		for (int i = 0; i < returns.size(); i++) {
//			beta_mean = beta_mean + (double) returns.get(i);
//		}
	//	std = Math.pow(std / returns.size(), 0.5);
		System.out.println();
		 System.out.println("Standard dev\t         Total absolute Returns\t             Sharpe \t  \t     Volatitly ");
		 
		 System.out.print(std+ "\t" + sum+ "\t" +  sum*Math.pow(252,.5)/  (std*return_per.size()));
		 // Multiply by 360 average returns in a day
		sharpe.put(name, sum*Math.pow(252,.5)/  (std*return_per.size()));
	

	}
}
