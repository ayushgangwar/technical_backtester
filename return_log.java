package reading;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class return_log extends screener {

	public void returns(ArrayList<Integer> dates_to_trade,
			ArrayList<Double> returns_per, String name) throws IOException {
		// TODO Auto-generated method stub
		File file = new File("/media/ayush/Seagate Expansion Drive/workspace/final_project_main/log/"+name+ "_log.csv");
		FileWriter writer = new FileWriter(file); 
		file.createNewFile();
		writer.write("Day id \t");
		writer.write("Return %\t");
		writer.write("\n");
		
		for(int i =0;i< returns_per.size();i++){
			writer.write(dates_to_trade.get(i)+"\t");
			writer.write(returns_per.get(i)+"\n");
		}
	}
	

}
