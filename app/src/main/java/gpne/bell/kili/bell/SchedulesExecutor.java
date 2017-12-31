package gpne.bell.kili.bell;

import java.util.Map;

public class SchedulesExecutor {

    Map<String,Integer> schedules;

    public SchedulesExecutor(Map<String, Integer> schedules) {
        this.schedules = schedules;
        calc();
    }

    private void calc(){
        for(String dgd:  schedules.keySet()){
            System.out.println(dgd + ">>>" + schedules.get(dgd));
        }
    }
}
