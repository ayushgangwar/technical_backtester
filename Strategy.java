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

public class Strategy extends Connect_sqlite {
	
	static ArrayList<String> names = new ArrayList();
	public  static ArrayList open = new ArrayList();
	public static ArrayList close = new ArrayList();
	public  static ArrayList low = new ArrayList();
	public static ArrayList high = new ArrayList();
	public  static ArrayList adj_close = new ArrayList();
	public static ArrayList vol = new ArrayList();
	public static void main(String args[]) throws IOException, ClassNotFoundException, SQLException{
		double start = System.currentTimeMillis();
		Connect_sqlite obj=new Connect_sqlite();
		obj.connect("technical_242.sqlite");
		
		
		names =names();
		for(int i=0;i<names.size();i++ ){
			
		String query= "SELECT * FROM " +names.get(5).toLowerCase();
		ResultSet st = stmt.executeQuery(query);
		  while (st.next()) {
			 open.add(st.getDouble("open"));
			 close.add(st.getDouble("close"));
			 low.add(st.getDouble("low"));
			 high.add(st.getDouble("high"));
			 vol.add(st.getDouble("volume"));
			 adj_close.add(st.getDouble("adj_close"));
			 
		  }
		  screener bt= new screener();
		//  bt.testing(open,close,high,low,vol,adj_close,names.get(i));
		}
		System.out.print("Done in : ");
		System.out.print(System.currentTimeMillis()- start);
	}
	public static ArrayList<String> names() throws IOException {
		
		double start = System.currentTimeMillis();

		CSVReader reader = new CSVReader(new FileReader("/home/ayush/25.csv"),
				'\t', '\'', 1);
		String[] nextLine;
		while ((nextLine = reader.readNext()) != null) {
			names.add(nextLine[0]);
		}
		reader.close();
		return names;
	}
		
	}

