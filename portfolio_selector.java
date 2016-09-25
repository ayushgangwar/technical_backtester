package reading;

import java.awt.List;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

import javax.swing.text.html.HTMLDocument.Iterator;


import com.opencsv.CSVReader;

public class portfolio_selector extends screener{

	static ArrayList<String> filtered_names= new ArrayList();
	public void portfolio() throws IOException {
		
		ArrayList<Double> hm = new ArrayList(hp.keySet());
	    
		 
		 HashMap<String,Double> sharpe = new HashMap();
		 Sharpe_ratio sr = new Sharpe_ratio();
		 sharpe = sr.sharpe;
		
		 HashMap vol = new HashMap();
		 Volatility vt = new Volatility();
		 vol=vt.Volatility;
	
		 HashMap<String, Double> WL = new HashMap();
		 WinLossRatio WLR = new WinLossRatio();
		 WL=WLR.WinLoss;
		
		 
		 
		 
	int counter =0;
	try
		{ 
		
		File file = new File("portfolio.csv");
		FileWriter writer = new FileWriter(file); 
		file.createNewFile();
		writer.write("Names\t");
		writer.write("Price\t");
		writer.write("%  Returns\t"); 
		writer.write("% Sharpe\t"); 
		writer.write("% Volatility\t"); 
		writer.write("% Win Loss Ratio\t"); 
		writer.write("% BenchMark returns\t"); 
		writer.write("1 % VAR \t"); 
		writer.write("5 % VAR \t"); 
		writer.write("\n"); 
		for (int i =0;i< hm.size();i++) 
	      {
	    	  counter++;
	    	
	          {
	      
	          writer.write(String.valueOf(hp.get(hm.get(i)))+"\t"); 
	          writer.write(String.valueOf((LTP.get(hp.get(hm.get(i)))))+"\t"); 
	          writer.write(String.valueOf(String.valueOf(hm.get(i)*100)+"\t")); 
	          writer.write(String.valueOf(sharpe.get(hp.get(hm.get(i)))+"\t"));
	          writer.write(String.valueOf(vol.get(hp.get(hm.get(i)))+"\t"));
	          writer.write(String.valueOf(WL.get(hp.get(hm.get(i)))+"\t"));
	          writer.write(String.valueOf(BenchMark.get(hp.get(hm.get(i)))+"\t"));
	          writer.write(String.valueOf(Var001.get(hp.get(hm.get(i)))+"\t"));
	          writer.write(String.valueOf(Var005.get(hp.get(hm.get(i)))));
	          writer.write("\n"); 
	          writer.flush();
	         if(((hm.get(i)))*10000 > 30 &&  WL.get(hp.get(hm.get(i))) > 0.7 ){
	        	 filtered_names.add(hp.get(hm.get(i)));
	         }
	        
	          }
	        
	       }
	     }
	        catch(NoSuchElementException r ){}
		
	  
	}
			
		}
		
	

