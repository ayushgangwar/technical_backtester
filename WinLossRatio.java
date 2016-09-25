package reading;

import java.util.HashMap;

public class WinLossRatio {
	static HashMap<String,Double > WinLoss= new HashMap();
	public void ratio(double d, String name) {
		// TODO Auto-generated method stub
		WinLoss.put( name,d);
	//	System.out.println(WinLoss);
	}

}
