import java.util.ArrayList;
import java.util.Calendar;
import java.util.Timer;

//This class determines what times to play sounds based on all the schedules created. 
//If 2 schedules have overlapping times they will both be played.
public class Scheduler {

	//timer used to schedule all the times for the day.
	private Timer time;
	private ArrayList<Schedule> schedules;
	private ArrayList<Schedule> activeSchedules;
	private Calendar now;
	Scheduler(Timer time){
		this.time = time;
		schedules = new ArrayList<Schedule>();
		activeSchedules = new ArrayList<Schedule>();
		now = Calendar.getInstance();
	}
	
	//cancels and schedules all the timers in the schedules with the current day selected.
	public void cancelTimers() {
		//cancels all timers. cleans out active schedules.
		//time.cancel();
	}
	
	private void getActiveSchedules() {
		for(int i = 0; i < schedules.size(); i++) {
			if(schedules.get(i).getDay(Calendar.getInstance().get(Calendar.DAY_OF_WEEK)))
			{
				activeSchedules.add(schedules.get(i));
			}
		}
	}
	//sets all the timers for a given day. Does not care if times collide within mulitple schedules.
	public void setTimers() {
		//gets all the times from the active schedules and creates timers and schedules them.
		getActiveSchedules();
		scheduleRingList();
		
	}
	
	//schedules times to play sounds from a rings arraylist.
	//this should work, but it sucks balls to check
	private void scheduleRingList() {
		//time.toString();
		for(int i = 0; i < activeSchedules.size(); i++) {
			//call function to schedule a timer for each ring.
			for(int j = 0; j < activeSchedules.get(i).getRings().size(); j++)
			{
				//do the deed right here.
				System.out.println("Scheduling: " + activeSchedules.get(i).getRings().get(j).getRingTime().getTime().toString());
				 time.schedule(new RingTask(),activeSchedules.get(i).getRings().get(j).getRingTime().getTime());
			}
		}
		
	}
	
	//adds a schedule to the arraylist if there is not one with the same name.
	public boolean addSchedule(Schedule newSchedule) {
		
		for(int i = 0; i < schedules.size(); i++)
		{
			if(newSchedule.getName().equals(schedules.get(i).getName()))
			{
				return false;
			}
		}
			
		schedules.add(newSchedule);
		return true;
	}
	
	//we need to figure out what schedules have today set as active.
	//add them to the activeschedules array
	public void updateDay() {
		for(int i = 0; i < schedules.size(); i++) {
			schedules.get(i).updateRings();
		}
		activeSchedules = new ArrayList<Schedule>();
	}
}
