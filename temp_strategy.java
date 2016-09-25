package reading;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class temp_strategy {
	public void testing(ArrayList open, ArrayList close, ArrayList high, ArrayList low, ArrayList vol, ArrayList adj_close, String names) throws IOException, ClassNotFoundException, SQLException
	{
	int pos=0;
	int neg =0;
		double expected_pos_return=0;double expected_neg_return=0;
	for(int i = 0; i < 30;i++)
	{
		if((double)close.get(i) - (double)open.get(i) > 0){
	expected_pos_return = expected_pos_return+	((double)close.get(i+1) - (double)open.get(i+1));
	pos++;
		}
		else{expected_neg_return = expected_neg_return+	((double)close.get(i+1) - (double)open.get(i+1));
			neg++;
		}
	double ret =	neg*expected_neg_return + pos*expected_pos_return;
	}
	}
}
