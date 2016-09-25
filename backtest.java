package reading;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;


import com.opencsv.CSVReader;

public class backtest extends Connect_sqlite {
	
	static ArrayList<String> names = new ArrayList();
	
	 
	public static void main(String args[]) throws IOException, ClassNotFoundException, SQLException{
		double start = System.currentTimeMillis();
		
		
		 Connect_sqlite obj=new Connect_sqlite();
		 System.out.println("Starting Screening......");
		names =names();
		for(int i=0;i<names.size();i++ )
			{
			obj.connect("technical_3mintest1.sqlite");
			//technical_242_updated
			//FMCG_TECH_temp9.sqlite
			//technical_3min.sqlite
		   	 ArrayList open = new ArrayList();
			 ArrayList close = new ArrayList();
			 ArrayList low = new ArrayList();
			 ArrayList high = new ArrayList();
		//	 ArrayList adj_close = new ArrayList();
			 ArrayList vol = new ArrayList();
			
			 String query= "SELECT * FROM " +names.get(i).toLowerCase();
			 ResultSet st = stmt.executeQuery(query);
			 while (st.next()) 
				 
			 	{
				 open.add(st.getDouble("open"));
				 close.add(st.getDouble("close"));
				 low.add(st.getDouble("low"));
				 high.add(st.getDouble("high"));
				 vol.add(st.getDouble("vol"));
		//		 adj_close.add(st.getDouble("volume"));
		
			 	}	    	   
		
			 screener bt= new screener();
			
			 bt.testing(open,close,high,low,vol,names.get(i));		 
		}
		System.out.println();
		System.out.println("Screening complete");
		System.out.println("Starting portfolio selector class");
		portfolio_selector ps = new portfolio_selector();
		ps.portfolio();
		portfolio_optimizer po = new portfolio_optimizer();
		po.optimizer();
		Covariance_matrix cv =new Covariance_matrix();
	//	cv.covariance();
//		graph gp = new graph();
//		gp.draw(names.get(0));
		System.out.print("Done in : ");
		System.out.print(System.currentTimeMillis()- start);
		
	}
	public static ArrayList<String> names() throws IOException 
		{
			double start = System.currentTimeMillis();
			CSVReader reader = new CSVReader(new FileReader("/home/ayush/technical_3mNam.csv"));//,'\t','\'', 1
			///home/ayush/sector_wise_nse_list/fmcglist.csv"
			//home/ayush/25.csv , 
			String[] nextLine;
			while ((nextLine = reader.readNext()) != null) 
				{
					names.add(nextLine[0]);
				}
			reader.close();
			return names;
		}
		
	}

