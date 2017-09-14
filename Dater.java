import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Dater {

	//formats the date into a normal date format.
		static Calendar makeDate(String date) {
			Calendar taskTime = Calendar.getInstance();
			String temp = today();
			temp += date;
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			try {
				taskTime.setTime(df.parse(temp));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return taskTime;
		}
		
	//gets the date and returns it.
		private static String today()
		{
			//Formats today as the correct date format.
			String today = "";
			String month ="";
			int monthNum = 0;
			Calendar now = Calendar.getInstance();
			today += now.get(Calendar.YEAR)+"-";
			monthNum = now.get(Calendar.MONTH) +1;
			if(monthNum < 10)
			{
				month = "0" +  Integer.toString(monthNum);
			}
			else
			{
				month = "" + Integer.toString(monthNum);
			}
			today += month + "-" +now.get(Calendar.DATE) +" ";
			return today;
			
		}

}
