package reading;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;


public class buy {
	static Connect_sqlite obj=new Connect_sqlite();
	
	
	public double profit(ArrayList<Integer>  dates_to_trade, String name) throws ClassNotFoundException, SQLException, IOException {
		 ArrayList<Double> returns = new ArrayList();
		  ArrayList<Double> returns_per = new ArrayList();
		  double sum=0.0;
		  double win=0;
		  double loss=0;
		  
		  obj.connect("technical_3mintest1.sqlite");
		 // technical_242_updated
		  //FMCG_TECH_temp9
		// TODO Auto-generated method stub
	for(int i =0;i<dates_to_trade.size();i++)
{
		
		String query = "SELECT *  FROM "+ name+" WHERE rowid=" +dates_to_trade.get(i);
		//System.out.println(days.get(i));
		try
			{
				ResultSet rs = obj.stmt.executeQuery(query);
				returns.add(rs.getDouble("close") - rs.getDouble("open"));
			//error for technical_242_updated database..high swapped with close in db	
				returns_per.add((rs.getDouble("close") - rs.getDouble("open"))/rs.getDouble("open"));
			//	System.out.println(rs.getDouble("high"));
			//	System.out.println(rs.getDouble("open"));
//				System.out.print("bc  print ho");
//				System.out.println(returns.get(returns.size()-1));
//				
			//Win-Loss ratio
				if(returns_per.get(returns_per.size()-1) > 0){
					win++;}
				else{
					loss++;
				}
				double g =  (double) returns_per.get((returns.size()-1));
//					System.out.print("Return log: \t");
//					System.out.print(dates_to_trade.get(i)+"\t");
//					System.out.println(returns_per.get((returns.size()-1)));
				sum = sum +g;
			}
		catch(SQLException s)
		{}
		
	}	
//	System.out.println(win);
//	System.out.println(loss);
	Sharpe_ratio sharpee= new Sharpe_ratio();
	sharpee.sharpe(returns,name);
	
	Volatility voltatile= new Volatility();
	voltatile.Volatile(returns, name);
	
	WinLossRatio WL= new WinLossRatio();
	WL.ratio( (win/(loss)), name);
	
	return_log rt = new return_log();
	rt.returns(dates_to_trade, returns_per,name);
	
	

//  System.out.println(sharpee.sharpe(returns_per,names)+ "  ");
//	graph gph = new graph();
//	gph.draw(returns,names);
	
	
//	System.out.println("buy se returns nahi print ho raha");
//	System.out.println(sum);
	return sum;
	}
	
}
