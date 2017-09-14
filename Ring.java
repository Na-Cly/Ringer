import java.util.Calendar;

//A ring is a specific time that a sound should be played. Default constructor will use the default sound for the app.
public class Ring {
	
	private Calendar time;
	Ring(Calendar time){
		this.time = time;
	}
	public void setTime(String setTime)
	{
		time = Dater.makeDate(setTime);
	}
	public Calendar getRingTime()
	{
		return time;
	}
	
	public String getTimeString() {
		//Formats today as the correct date format.
		String today = "";
		
		Calendar now = time;
		now.set(Calendar.SECOND, 0);
		if(now.get(Calendar.HOUR)< 10) {
			today+="0" + now.get(Calendar.HOUR)+":";
		}
		else{
			today += now.get(Calendar.HOUR)+":";
		}
		if(now.get(Calendar.MINUTE)< 10 ) {
			today+="0" + now.get(Calendar.MINUTE)+":";
		}
		else{
			today += now.get(Calendar.MINUTE)+":";
		}
		if(now.get(Calendar.SECOND)< 10 ) {
			today+="0" + now.get(Calendar.SECOND);
		}
		else{
			today += now.get(Calendar.SECOND);
		}

		
		return today;
	}
	
	public void setNextDay() {
		Calendar now = time;
		now.set(Calendar.HOUR,time.get(Calendar.HOUR));
		now.set(Calendar.MINUTE,time.get(Calendar.MINUTE));
		now.set(Calendar.SECOND,time.get(Calendar.SECOND));
		now.set(Calendar.MILLISECOND, 0);
		now.add(Calendar.DATE,1);
		time = now;
		System.out.println(time.getTime().toString());
	}
}
