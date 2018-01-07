package gpne.bell.kili.bell;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

public class SchedulesExecutor {

    private Map<String,Integer> schedules = new HashMap<>();

    public void apply(String index, Integer value){
        schedules.put(index,value);
        for(String dgd:  schedules.keySet()){
            System.out.println(dgd + ">>>" + schedules.get(dgd));
        }
//        modAr();
    }

    private void modAr(){
        TimerTask timerTask = new SingleBell();
        Timer timer = new Timer(true);
        timer.scheduleAtFixedRate(timerTask, new Date(),0);
    }
}
