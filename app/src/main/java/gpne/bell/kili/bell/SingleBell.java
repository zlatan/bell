package gpne.bell.kili.bell;


import java.util.Date;
import java.util.TimerTask;

public class SingleBell extends TimerTask {

    @Override
    public void run() {
        System.out.println("Timer task started at:"+new Date());
    }
}
