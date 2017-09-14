import java.awt.Toolkit;
import java.util.Timer;
import java.util.TimerTask;

public class CleanUp extends TimerTask{
	Timer time;
	CleanUp(Timer time){
		this.time = time;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("This should cancel all timers.");
		time.cancel();
		Toolkit.getDefaultToolkit().beep();
		System.exit(0);
	}
}
