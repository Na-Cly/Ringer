import java.util.ArrayList;
import java.util.Calendar;
import java.util.Timer;

public class Main {

	public static void main(String[] args) {
		//TODO get a better grasp on timer.
		//make sure scheduling a bunch won't make everything go crazy.
		Timer time = new Timer();
		//Array list holds the time for execution in string format.
		ArrayList<String> times = new ArrayList<String>();
		ArrayList<Ring> rings = new ArrayList<Ring>();
		Schedule schedule = new Schedule("test");
		Scheduler sch = new Scheduler(time);
		Calendar now = Calendar.getInstance();
		Ring ring = new Ring(Dater.makeDate("00:01:00"));
		
		rings.add(ring);
		ring = new Ring(Dater.makeDate("23:59:30"));
		rings.add(ring);
		//System.out.println(Dater.makeDate(ring.getTimeString()).getTime().toString());
	
		
		schedule.addRings(rings);
		System.out.println(schedule.addDay(4));
		System.out.println(schedule.addDay(5));
		//TODO: make sure you can update a schedule
		sch.addSchedule(schedule);
		sch.setTimers();
		//time.schedule(new ResetTimers(time,sch), now.getTime() );
		
		//Figure out how to do this everyday.
		
		now.set(Calendar.HOUR_OF_DAY, 0);
		now.set(Calendar.MINUTE, 0);
		now.set(Calendar.SECOND, 0);
		now.set(Calendar.MILLISECOND, 0);

		now.add(Calendar.DATE,1);
		System.out.println(now.getTime().toString());
		time.schedule(new ResetTimers(time,sch), now.getTime());
	
	//	System.out.println(sch.addSchedule(schedule));
	//	schedule = new Schedule("temp");
	//	System.out.println(sch.addSchedule(schedule));
	//	System.out.println(sch.addSchedule(schedule));
		//times.add("13:00:00");
		//initialize rings
		//will be used when getting times from the list as a string to make it into a Calendar.
		//Will be added to the current schedules arraylist of rings.
		//Ring tempRing = new Ring(Dater.makeDate(times.get(0)));
	//	schedule.addRing(tempRing);
		//rings = schedule.getRings();
		//System.out.println(rings.get(0).getRingTime().getTime());
		//System.out.println(tempRing.getTime().getTime());
			
		//adds all the times in the arraylist to the scheduled tasks.
		//check if today is the day to schedule these tasks ie not a weekend or unselected date.
		/*for(int i = 0; i < times.size(); i++)
		{
			time.schedule(new RingTask(), Dater.makeDate(times.get(i)).getTime());
		}*/
		
		//Can schedule a task for midnight to reset the day.
		//time.schedule(new CleanUp(time), Dater.makeDate("14:27:30").getTime());
		
		
	}
	
}
