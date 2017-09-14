
import java.util.Timer;
import java.util.TimerTask;
//this task needs to run daily to make the timers go again
public class ResetTimers extends TimerTask{
	Timer time;
	Scheduler s;
	ResetTimers(Timer time, Scheduler s){
		this.time = time;
		this.s = s;
		//System.out.println(time.toString());
	}
	
	@Override
	public void run() {
		System.out.println("WHAT");
		
		s.updateDay();
		s.setTimers();
		
		
	}
}
