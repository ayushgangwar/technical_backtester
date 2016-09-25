package reading;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

public class Volatility  extends backtest{
	static HashMap<String,Double> Volatility = new HashMap();
	public  void Volatile(ArrayList<Double> returns,String name) throws IOException{
		DescriptiveStatistics stats = new DescriptiveStatistics();
		for(int i =0;i< returns.size();i++)
		{
		stats.addValue( returns.get(i));
		}
	//	System.out.print("Volatitly : ");
		Volatility.put(name,Math.pow((double)stats.getStandardDeviation(),2));
		System.out.println("\t "+Math.pow((double)stats.getStandardDeviation(),2));
		System.out.println();
	//	System.out.print(stats.getStandardDeviation());
//		System.out.print("  Volatitly : ");
//		System.out.print(name);
//		System.out.print((double)stats.getStandardDeviation());
		
		
	}

}
