import java.awt.Toolkit;
import java.util.Calendar;
import java.util.TimerTask;

public class RingTask extends TimerTask{

	@Override
	public void run() {
		// TODO Play sound in android
		//task runs here.
		System.out.print("This means it works: ");
		Toolkit.getDefaultToolkit().beep();
		Calendar time = Calendar.getInstance();
		System.out.println(time.getTime());
	}

}
