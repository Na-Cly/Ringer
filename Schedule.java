import java.lang.reflect.Array;
import java.util.ArrayList;

//This class should keep the list of Calendar objects that hold the time of when the sound should play.
public class Schedule {
	//should know what days it is scheduled to repeat.
	//should know what times each day.
	//A schedule should not play at different times on different days. 
	//A schedule always plays the same times.
	//Schedules do not care about if multiple schedules have the same day selected.
	private ArrayList<Ring> rings;
	private int[] days;
	private String name;
	private int dayCount;
	
	//Names must be unique. If not the schedule cannot be added to the scheduler.
	Schedule(String name){
		rings = new ArrayList<Ring>();
		days = new int[7];
		this.name = name;
		dayCount = 0;
	}
	
	
	//get arraylist of rings translates into timers created.
	public ArrayList<Ring> getRings()
	{
		return rings;
	}
	
	//possible to set entire list of rings at once.
	public void addRings(ArrayList<Ring> rings)
	{
		this.rings = rings;
	}
	
	//Function used to add rings to the arraylist.
	public void addRing(Ring ring)
	{
		rings.add(ring);
	}
	
	//Returns true if the requested day is inside the array.
	public boolean getDay(int day)
	{
		for(int i = 0; i < dayCount; i++) {
			if(days[i] == day) {
				return true;
			}
		}
		return false;
	}
	
	//returns the schedule name
	public String getName() {
		return name;
	}
	
	public void updateRings() {
		Ring ring;
		
		for(int i = 0; i < rings.size(); i++) {
			rings.get(i).setNextDay();
		}
	}
	//returns true if day was added. returns false if it already exists.
	public boolean addDay(int day)
	{
		boolean exists = false;
		for(int i = 0; i < days.length; i++) {
			if(days[i] == day) {
				exists = true;
			}
		}
		if(exists) {
			return false;
		}
		else {
			days[dayCount]=day;
			dayCount++;
			return true;
		}

		
	}
	
}
