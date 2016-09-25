package reading;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.time.Day;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.*;

import com.opencsv.CSVReader;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.time.Day;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.*;


public class graph {
	
	/**
	 * @param args
	 * @throws IOException 
	 */
	

	public static  void draw( String name) throws IOException{
	    XYSeries series = new XYSeries("XYGraph");
	 ArrayList<Double> returns = new ArrayList();
	    CSVReader reader = new CSVReader(new FileReader(name+"log.csv"),'\t','\'', 1);//,'\t','\'', 1
		
		String[] nextLine;
		while ((nextLine = reader.readNext()) != null) 
			{
			System.out.print(nextLine[0]);
			returns.add(Double.parseDouble(nextLine[1]));
			}
		XYSeriesCollection dataset = new XYSeriesCollection();
		 XYSeries firefox = new XYSeries( "Firefox" );
		 for(int i =0;i< returns.size()-1;i++){
			 firefox.add(i, returns.get(i));
		 }
		JFreeChart chart = ChartFactory.createXYLineChart(
				"XY Chart",
				// Title
				"x-axis",
				// x-axis Label
				"y-axis",
				// y-axis Label
				dataset,
				// Dataset
				PlotOrientation.VERTICAL, // Plot Orientation
				true,
				// Show Legend
				true,
				// Use tooltips
				true
				// Configure chart to generate URLs?
				);
				{
					ChartUtilities.saveChartAsJPEG(new File(name+".jpg"), chart, 500, 300);
				} 
	}
}
