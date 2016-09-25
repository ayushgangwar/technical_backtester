package reading;
import java.sql.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.opencsv.CSVReader;
import java.util.Date;
public class recieve_tech {
	static int counter=0;
	


	/**
	 * @param dateP 
	 * @param lowP 
	 * @param highP 
	 * @param closeP 
	 * @param openP 
	 * @param arg
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public void run(String name) throws ClassNotFoundException, SQLException, NumberFormatException, IOException
	{
		
		Connect_sqlite obj= new Connect_sqlite();
		obj.connect("technical_3mintest1.sqlite");
		 int q=0;
		  
			     ArrayList openP= new ArrayList();
				 ArrayList closeP= new ArrayList();
				 ArrayList highP= new ArrayList();
				 ArrayList lowP= new ArrayList();
				 ArrayList volP= new ArrayList();
				 ArrayList dateP= new ArrayList();
				 ArrayList adj_closeP= new ArrayList();
			
				
			   
				   
				//reading specific file 
				      String path2="/home/ayush/data/"+  name.toUpperCase().substring(1, name.length()-1)+ ".csv";
				      System.out.println("Creating table for :"+path2);
				      CSVReader reader2 = new CSVReader(new FileReader(path2), '\t', '\'', 150000);//
					  String [] nextLine2;
					 
					
					  
					int counter =0;
					
				     while ((nextLine2 = reader2.readNext()) != null) {
				    	  
//				    	 System.out.println(nextLine2[0]);
//				    	 System.out.println("lauda laisun");
				    	 dateP.add(nextLine2[0].split(",")[0]);
				    	 openP.add(Double.parseDouble(nextLine2[0].split(",")[1]));
				    	 closeP.add(Double.parseDouble(nextLine2[0].split(",")[4]));
				    	 highP.add(Double.parseDouble(nextLine2[0].split(",")[3]));
				    	 lowP.add(Double.parseDouble(nextLine2[0].split(",")[2]));
				    //	 adj_closeP.add(Double.parseDouble(nextLine2[0].split(",")[6]));
				    	 volP.add(Double.parseDouble(nextLine2[0].split(",")[5]));
				    
				    	 String insert_query="INSERT INTO "+ name.toLowerCase() + "(company_id,date,open,low,high,close,vol) VALUES (?,?,?,?,?,?,?)";
				    	
				    	 PreparedStatement ps= obj.c.prepareStatement(insert_query); 
				    	 ps.setDouble(1,counter);
				    	 ps.setString(2,(String) dateP.get(dateP.size()-1));
				    	 ps.setDouble(3,(double) openP.get(openP.size()-1));
				    	 ps.setDouble(4,(double) highP.get(highP.size()-1));
				    	 ps.setDouble(5,(double) lowP.get(lowP.size()-1));
				    	 ps.setDouble(6,(double) closeP.get(closeP.size()-1));
				  //  	 ps.setDouble(6,(double) adj_closeP.get(adj_closeP.size()-1));
				    	 ps.setDouble(7,(double) volP.get(volP.size()-1));

				    	
				    	 ps.executeUpdate();
				    	
				    	 
				     } System.out.print(name);
					   System.out.println(" done");}
			  
			  
				    
//		if(q==0){
//			Strategy st=new Strategy();
//			try {
//				st.technical_indicator(openP);
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				System.out.print("Stock Data not found");
//				e.printStackTrace();
//			}
//			
//		}
		
	}
	


