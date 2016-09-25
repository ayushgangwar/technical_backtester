package reading;

import java.util.ArrayList;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;


public class Value_at_Risk extends screener {

	public double var(ArrayList<Double> open, ArrayList<Double> close, double  z_val, ArrayList<Integer> dates_to_trade_buy) {
		// TODO Auto-generated method stub
	
		DescriptiveStatistics ratio = new DescriptiveStatistics();
		DescriptiveStatistics clos = new DescriptiveStatistics();
		
		for(int i=0;i< dates_to_trade_buy.size();i++){
			ratio.addValue(close.get(dates_to_trade_buy.get(i))-open.get(dates_to_trade_buy.get(i)));
			clos.addValue(close.get(i));
		}
	
		double ratiomean=ratio.getMean();
		double ratiostd=ratio.getStandardDeviation();
	
	
		double loss001= ratiomean -  z_val*ratiostd;
		return loss001;
	}

	
}
