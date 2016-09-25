package reading;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;

import com.opencsv.CSVReader;

public class update_242
	{
		Connect_sqlite sq = new Connect_sqlite();
		public void  update() throws ClassNotFoundException, SQLException, IOException
		{
			sq.connect("technical_242.sqlite");
			CSVReader reader = new CSVReader(new FileReader("/home/ayush/25.csv"),'\t', '\'', 1);
			String[] nextLine;
			while ((nextLine = reader.readNext()) != null) 
				{
				
				
				}
		}
}