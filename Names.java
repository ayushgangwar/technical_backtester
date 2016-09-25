package reading;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import com.opencsv.CSVReader;

public class Names {

	/**
	 * @param args
	 */

	static ArrayList<String> names = new ArrayList<String>();

	public ArrayList<String> namess() throws IOException {
		// TODO Auto-generated method stub
		double start = System.currentTimeMillis();

		CSVReader reader = new CSVReader(new FileReader("/home/ayush/bansal/stock_db_list_bansal.csv"),'\t', '\'', 1);//,'\t', '\'', 0
		String[] nextLine;
		while ((nextLine = reader.readNext()) != null) {
		//System.out.print(nextLine[0]);
			String[] p = nextLine[0].split(",");
			names.add(p[2]);
		}
		reader.close();
		return names;
	}

}
