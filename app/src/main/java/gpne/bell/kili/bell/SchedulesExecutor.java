package gpne.bell.kili.bell;

import java.util.HashMap;
import java.util.Map;

public class SchedulesExecutor {

    private Map<String,Integer> schedules = new HashMap<>();

    public void apply(String index, Integer value){
        schedules.put(index,value);
        for(String dgd:  schedules.keySet()){
            System.out.println(dgd + ">>>" + schedules.get(dgd));
        }
    }
}
