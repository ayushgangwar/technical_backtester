package reading;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.opencsv.CSVReader;

public class technical_data extends Connect_sqlite {
	 
	  static Connect_sqlite obj2=new Connect_sqlite();
	/**
	 * @param args
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		ArrayList<String> names = new ArrayList();
		double start= System.currentTimeMillis();
		Names obj=new Names();
		names =obj.namess();
		

		     
		   
		     obj2.connect("technical_3mintest6.sqlite");
		    
		 	
		    System.out.println("Size : "+names.size());
		    int counter =0;
		    
		    for(int j=0;j< names.size();j++)
		    {
		    	String name=names.get(j);
		 
		    	String query= "CREATE TABLE IF NOT EXISTS "+ name.toLowerCase()+" (company_id NUMERIC,date VARCHAR, open NUMERIC,low NUMERIC,high NUMERIC,close NUMERIC,adj_close NUMERIC,vol NUMERIC);";
		    	
		  
		    	int p=stmt.executeUpdate(query);
		    	counter++;
		    }
		 obj2.closee();
//		       
		    //MULTITHREADED RUN 
		 System.out.println("Size : "+names.size());
		 recieve_tech obj3= new recieve_tech();   
		     for(int i=0;i< names.size();i++)
		   {
				 System.out.println("Size : "+names.size());

				obj3.run(names.get(i));	
		   }
			System.out.print(System.currentTimeMillis() - start)  ; 
	}

}
