package reading;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import org.apache.commons.math3.stat.regression.SimpleRegression;

public class screener {
		
		static	HashMap< Double,String > hp = new HashMap<Double,String>();
		static	HashMap< String,Double > LTP = new HashMap<String,Double >();
		static	HashMap< String,Double > BenchMark = new HashMap<String,Double >();
		static	HashMap< String,Double > Var001 = new HashMap<String,Double >();
		static	HashMap< String,Double > Var005 = new HashMap<String,Double >();
		static ArrayList<Double> return_comp = new ArrayList();
	public void testing(ArrayList<Double> open, ArrayList<Double> vol, ArrayList<Double> high, ArrayList<Double> low, ArrayList<Double> close, String names) throws IOException, ClassNotFoundException, SQLException
		{
		
			System.out.print( "-------------------------"+names +"------------------------------ ");
//			System.out.print(open.get(0));
			ArrayList<Double> b = new ArrayList();
			ArrayList<Double> predicted = new ArrayList();
			ArrayList dates_to_trade_buy = new ArrayList();
			ArrayList dates_to_trade_sell = new ArrayList();
			double q =0;
			buy by=new buy();
			sell sll= new sell();
			int counter=0;
			int position=1;
			double benchMark_Returns=0;
			
			
			 int training_data= (int) (open.size()*0.5);

		     simple_moving_average sma1 = new simple_moving_average();

//			 Bollinger_band bb = new Bollinger_band();
//			 Moving_average_convergence_divergence macd = new Moving_average_convergence_divergence();
//			 Relative_Strenght_Index RSI = new Relative_Strenght_Index();
//			 True_range tr= new True_range();
//			 Stochastic_KD kd= new Stochastic_KD();

			 
//			 
//			 Linear_regression regression = new Linear_regression();			 
//			 ArrayList<Double> predict= new ArrayList();
//			 predict=regression.LinearRegression(names, training_data);
//			 double error=0;
			 
			 
			 DescriptiveStatistics dc= new DescriptiveStatistics();
	
			for(int i=2;i<open.size() ;i=i+10)
			{ 	counter++;
			
			
 //_____________________STRATEGY 1 ________________________________________				
//				double a = (open.get(i)+open.get(i-1)+open.get(i-2)+open.get(i-3)+open.get(i-4)+open.get(i-5)+open.get(i-6))/7;
//				double c = (open.get(i)+open.get(i-1)+open.get(i-2))/3;
//				if(c > a ){
//					dates_to_trade_buy.add(i+1);
//				}
//				
				
				
				
				
//_____________________STRATEGY 2: SIMPLE MOVING AVERAGE ________________________________________
//				double a =sma1.sma(names.toLowerCase(), 3, i);
//				double cc = sma1.sma(names.toLowerCase(),5, i);
//		//		System.out.println(i);
//				if(a > cc) 
//				//if(((double)high.get(i)) >(double)high.get(i-1))
//				{   
//					dates_to_trade_buy.add(i+1);
//				//	System.out.println(dates_to_trade_buy.get(dates_to_trade_buy.size()-1));
//					
//				}
//				
//			
				
			
				
				
//_____________________STRATEGY 3: BOLLINGER BANDS _________________________________________
//				double a =bb.bollinger(names, 20,i, 0.95);
//				if(a ==1 )
//					dates_to_trade_buy.add(i+1);
//				if(a == -1 )
//					dates_to_trade_sell.add(i+1);
//				

//____________________STRATEGY 4 ___________________________________________
//				error=error+(open.get(i)-(open.get(i-1)*predict.get(0)+predict.get(1)))/open.get(i-1);
				
				
				
//____________________STRATEGY 5 : ATR___________________________________________
//				double ATR=0;
//				double up=0;
//				double Down=0;
//				
//				for(int j=0;j<14;j++)
//			{
//					ATR= ATR+ tr.trueRange(names, i).get(0);
//					up=up + tr.trueRange(names, i).get(1);
//					Down=Down + tr.trueRange(names, i).get(2);
//					
//			}
//				 ATR=ATR/14;
//				 double ADX = 100*(Down/ATR + up/ATR)/(Down/ATR - up/ATR);
//				// System.out.print(up);
//				 if(ADX>40 && position==0){
//					 position=1;
//					 dates_to_trade_buy.add(i+1);
//				 }
//				 else{
//					 if(position==1){
//						 position=0;
//					 }
//				 }
			//____________________STRATEGY 6: STOCHASTIC KD ___________________________________________
//			double k_val=0;
//			for(int i1=0; i1<3;i1++){
//				k_val=k_val+(kd.stochastic(names, i1-i, 14));
//			}
//		     if(kd.stochastic(names,i, 14) -k_val/3 >0){
//		    	 dates_to_trade_buy.add(i+1);
//		     }
			
			
			
//___________________________________STRATEGY 7 : Time Series Analysis--------------------------------------
			//Stationarity test
			
	//		dc.addValue(open.get(i)-open.get(i+1));
				
//--------------------------------------STRATEGY 8 : MACD--------------------------------------
				
//			   double final_signal=macd.MACD(names, 12, i, 26, 9);
//				double signal_line=0;
//				for(int j =0; j < 9; j ++){
//					
//					signal_line= signal_line + macd.MACD(names, 12, i+j, 26, 9);
//				}
//				if(signal_line/9 > final_signal && position==0){
//					dates_to_trade_buy.add(i+1);
//					position=1;}
//				else{
//					if(position==1){
//						position=0;
//					}
//				}
	//		System.out.println(i);
			
					//end of the loop	
			
		
			
//---------------------------STRATEGY 8 : Relative Strength Index---------------------------------//
			
//			if(RSI.RSI(names, 13, i) > 30 && position ==0){
//				position=1;
//				dates_to_trade_buy.add(i+1);
//			
//			}
//			else{
//				if(position==1){
//					position=0;
//				}
//			}
//-------------------------VOLATILITY----------------------------//
//			dc.addValue(open.get(i));
		
		
			
//___________________________________STRATEGY 7 : Time Series Analysis Continued (Out of loop)--------------------------------------			
//			double mean=dc.getMean();
//			double dev=dc.getStandardDeviation();

			
//---------------------------------STRATEGY 8 :Technical ---------------------------------
//			if((close.get(i)-open.get(i))/(high.get(i)- low.get(i))>(close.get(i-1)-open.get(i-1))/(high.get(i-1)- low.get(i-1)) && position ==0)
//				
//			{
//				dates_to_trade_buy.add(i+1);
//				position=1;
//			}
//			else{
//				if(position==1){
//					position=0;
//				}
//			}
//---------------------------------STRATEGY 9:Technical ---------------------------------
//			if(close.get(i)/close.get(i-1) > 1)
//				
//				{
//					dates_to_trade_buy.add(i+1);
//					position=1;
//				}
//			else{
//				if(position==1){
//					position=0;
//				}
//			}
//---------------------------------STRATEGY 9:Technical ---------------------------------
	
//			System.out.print(close.get(i)/open.get(i) - (high.get(i)+low.get(i))/(2*low.get(i)));
//			System.out.print("\t" + i);
//			System.out.println("\t" + close.get(i));
	if(close.get(i)/open.get(i) - (high.get(i)+low.get(i))/(2*low.get(i))>0  )
		{	
			dates_to_trade_buy.add(i+1);
			position=1;
		//	System.out.println(high.get(i));
		}
	else{
		if(position==1){
			position=0;
		}
	
	}
			
			}
			benchMark_Returns=open.get(open.size()-14) - open.get(0);
			
			//Value_at_Risk var = new Value_at_Risk();
			
			
			double volatility=dc.getStandardDeviation();
			q=by.profit(dates_to_trade_buy, names);
			System.out.println("No. of trades \t Number of trades/Total backtesting days");
			double execution_ratio=(double)dates_to_trade_buy.size()/(double)open.size();
			System.out.println(dates_to_trade_buy.size()+ "\t"+ "\t"+ "\t"+ "\t"+ execution_ratio);
			System.out.println();
			return_comp.add(q*100);
			hp.put(  return_comp.get(return_comp.size()-1),names);
			LTP.put( names,open.get(open.size()-14));
			BenchMark.put( names,benchMark_Returns/open.size());
//			Var001.put(names, var.var(open,close, 2.34,dates_to_trade_buy));
//			Var005.put(names, var.var(open,close, 1.64,dates_to_trade_buy));
			
		//	System.out.print(LTP);
	

	
			}
}
