package gpne.bell.kili.bell;

import android.os.Build;
import android.support.annotation.RequiresApi;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SchedulesExecutor {

    private Map<String,Integer> schedules = new HashMap<>();
    private List<Integer> singleBell = new ArrayList<>();
    private List<Integer> doubleBell = new ArrayList<>();


    @RequiresApi(api = Build.VERSION_CODES.O)
    public void apply(String index, Integer value){
        schedules.put(index,value);

        for(String dgd:  schedules.keySet()){
//            System.out.println(dgd + ">>>" + schedules.get(dgd));
            calc();
        }
//        modAr();
    }

    private void modAr(){
        TimerTask timerTask = new SingleBell();
        Timer timer = new Timer(true);
        timer.scheduleAtFixedRate(timerTask, new Date(),0);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void calc(){
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime lt = LocalTime.parse(dtf.format(now),DateTimeFormatter.ofPattern("HH:mm:ss"));
        Integer tNow = lt.toSecondOfDay();
//        System.out.println(dtf.format(now));
//        System.out.println(t0);


        List<Integer> h = schedules.keySet()
                .stream().sorted()
                .filter(x -> x.endsWith("h"))
                .map(x -> schedules.get(x))
                .collect(Collectors.toList());

        List<Integer> a = schedules.keySet()
                .stream().sorted()
                .filter(x -> x.endsWith("a"))
                .map(x -> schedules.get(x))
                .collect(Collectors.toList());

        List<Integer> zipped = zip(h,a);

        List<Integer> dailySchedules = new ArrayList<>();
        dailySchedules.add(schedules.get("s1"));
        dailySchedules.addAll(zipped);
        dailySchedules.add(schedules.get("s2"));
        dailySchedules.addAll(zipped);

        if (dailySchedules.size()==30){
            Integer ds[] = new Integer[30];
            ds = dailySchedules.toArray(ds);
            int i = 1;

            singleBell.add(ds[0]-5);
            doubleBell.add(ds[0]);
            singleBell.add(ds[0]+ds[1]);
            doubleBell.add(ds[0]);
            doubleBell.add(ds[0]);
            doubleBell.add(ds[0]);
            doubleBell.add(ds[0]);
            doubleBell.add(ds[0]);
            doubleBell.add(ds[0]);
            doubleBell.add(ds[0]);


            System.out.println(ds[29]);

        }


//
//        0I/System.out: 450 G
//        1I/System.out: 40 M
//        1/2       M
//        2I/System.out: 10 G
//        3I/System.out: 40
//        4I/System.out: 10
//        5I/System.out: 40
//        6I/System.out: 10
//        7I/System.out: 40
//        8I/System.out: 10
//        9I/System.out: 39
//        10I/System.out: 10
//        11I/System.out: 40
//        12I/System.out: 10
//        13I/System.out: 40
//        14 =>>>>>>>>>>>>I/System.out: 10
//        15I/System.out: 810
//        16I/System.out: 40
//        17I/System.out: 10
//        18I/System.out: 40
//        19I/System.out: 10
//        20I/System.out: 40
//        21I/System.out: 10
//        22I/System.out: 40
//        23I/System.out: 10
//        24I/System.out: 39
//        25I/System.out: 10
//        26I/System.out: 40
//        27I/System.out: 10
//        28I/System.out: 40
//        29 =>>>>>>>>>I/System.out: 10
//


//        Stream<Integer> s1 = Stream.of(schedules.get("s1"));
//        Stream<Integer> s2 = Stream.of(schedules.get("s2"));
//
//        Stream<Integer> fs = Stream.concat(s1,zipped.stream());
//        Stream<Integer> ss = Stream.concat(s2,zipped.stream());
//
//        Stream<Integer> daylySchedules = Stream.concat(fs,ss);



        System.out.println("===================================");
//        dailySchedules.forEach(System.out::println);
//        daylySchedules.stream().filter(Objects::nonNull).map(x -> deltaTInSeconds(x,tNow)).forEach(System.out::println);


//        int shift = 5*60;
//        singleBell.add(deltaTInSeconds(schedules.get("s1"),tNow));
//        schedules.get("1h");

    }

    private Integer deltaTInSeconds(Integer t, Integer tNow){
        Integer deltaT = t*60 - tNow;
        if (deltaT >= 0){
            return deltaT;
        } else {
            return 24*60*60 + deltaT;
        }
    }

    private List<Integer> zip(List<Integer> a, List<Integer> b){
        List<Integer> zipped = new ArrayList<>();
        if (a.size() == 7 && b.size() == 7) {
            Iterator<Integer> iteratorA = a.iterator();
            Iterator<Integer> iteratorB = b.iterator();

            while (iteratorA.hasNext() && iteratorB.hasNext()) {
                zipped.add(iteratorA.next());
                zipped.add(iteratorB.next());
                iteratorA.remove();
                iteratorB.remove();
            }
        }
        return zipped;
    }
}
