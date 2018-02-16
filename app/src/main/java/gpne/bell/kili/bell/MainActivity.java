package gpne.bell.kili.bell;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button buttonStart1,buttonStart2;
    TextView start1,start2;

    private static Context context;

    private int mHour, mMinute;
    SchedulesExecutor schedulesExecutor;

    private AlarmManager alarmMgr;
    private PendingIntent alarmIntent;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MainActivity.context = getApplicationContext();

        List<Hour> hours = new ArrayList<>();
        List<Hour> antracts = new ArrayList<>();
        schedulesExecutor = new SchedulesExecutor();

        int s1 = 7*60 + 30;
        schedulesExecutor.apply("s1",s1);
        int s2 = 13*60 + 30;
        schedulesExecutor.apply("s2",s2);

        hours.add(new Hour((SeekBar) findViewById(R.id.seekBar1),(TextView) findViewById(R.id.textView1),getString(R.string.h1)+" час: %d мин.","1h"));
        hours.add(new Hour((SeekBar) findViewById(R.id.seekBar2),(TextView) findViewById(R.id.textView2),getString(R.string.h2)+" час: %d мин.","2h"));
        hours.add(new Hour((SeekBar) findViewById(R.id.seekBar3),(TextView) findViewById(R.id.textView3),getString(R.string.h3)+" час: %d мин.","3h"));
        hours.add(new Hour((SeekBar) findViewById(R.id.seekBar4),(TextView) findViewById(R.id.textView4),getString(R.string.h4)+" час: %d мин.","4h"));
        hours.add(new Hour((SeekBar) findViewById(R.id.seekBar5),(TextView) findViewById(R.id.textView5),getString(R.string.h5)+" час: %d мин.","5h"));
        hours.add(new Hour((SeekBar) findViewById(R.id.seekBar6),(TextView) findViewById(R.id.textView6),getString(R.string.h6)+" час: %d мин.","6h"));
        hours.add(new Hour((SeekBar) findViewById(R.id.seekBar7),(TextView) findViewById(R.id.textView7),getString(R.string.h7)+" час: %d мин.","7h"));

        antracts.add(new Hour((SeekBar) findViewById(R.id.seekBarA1),(TextView) findViewById(R.id.textViewA1),getString(R.string.a1)+" междучасие: %d мин.","1a"));
        antracts.add(new Hour((SeekBar) findViewById(R.id.seekBarA2),(TextView) findViewById(R.id.textViewA2),getString(R.string.a2)+" междучасие: %d мин.","2a"));
        antracts.add(new Hour((SeekBar) findViewById(R.id.seekBarA3),(TextView) findViewById(R.id.textViewA3),getString(R.string.a3)+" междучасие: %d мин.","3a"));
        antracts.add(new Hour((SeekBar) findViewById(R.id.seekBarA4),(TextView) findViewById(R.id.textViewA4),getString(R.string.a4)+" междучасие: %d мин.","4a"));
        antracts.add(new Hour((SeekBar) findViewById(R.id.seekBarA5),(TextView) findViewById(R.id.textViewA5),getString(R.string.a5)+" междучасие: %d мин.","5a"));
        antracts.add(new Hour((SeekBar) findViewById(R.id.seekBarA6),(TextView) findViewById(R.id.textViewA6),getString(R.string.a6)+" междучасие: %d мин.","6a"));
        antracts.add(new Hour((SeekBar) findViewById(R.id.seekBarA7),(TextView) findViewById(R.id.textViewA7),getString(R.string.a7)+" междучасие: %d мин.","7a"));

        buttonStart1 = (Button) findViewById(R.id.buttonStart1);
        buttonStart2 = (Button) findViewById(R.id.buttonStart2);
        start1 = (TextView) findViewById(R.id.textViewStart1);
        start2 = (TextView) findViewById(R.id.textViewStart2);

        buttonStart1.setOnClickListener(this);
        buttonStart2.setOnClickListener(this);

        start1.setText(minToTime(s1));
        start2.setText(minToTime(s2));

        SeekBarFactory seekBarFactory = new SeekBarFactory(schedulesExecutor);
        seekBarFactory.buildHours(hours);
        seekBarFactory.buildAntracts(antracts);

//        Runnable runnable = new Runnable() {
//            public void run() {
//                // task to run goes here
//                System.out.println("Hello !!");
//            }
//        };
//
//        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
//        service.scheduleAtFixedRate(runnable, 5, 5, TimeUnit.SECONDS);
//        service.scheduleAtFixedRate(runnable, 5, 5, TimeUnit.SECONDS);

    }

    @Override
    public void onClick(View view) {

        if (view == buttonStart1) {
            final Calendar c = Calendar.getInstance();
            mHour = c.get(Calendar.HOUR_OF_DAY);
            mMinute = c.get(Calendar.MINUTE);

            TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                    new TimePickerDialog.OnTimeSetListener() {
                        @RequiresApi(api = Build.VERSION_CODES.O)
                        @Override
                        public void onTimeSet(TimePicker view, int hourOfDay,int minute) {
                            schedulesExecutor.apply("s1",hourOfDay*60+minute);
                            start1.setText(hourOfDay + ":" + minute);
                        }
                    }, mHour, mMinute, true);
            timePickerDialog.show();
        }

        if (view == buttonStart2) {
            final Calendar c = Calendar.getInstance();
            mHour = c.get(Calendar.HOUR_OF_DAY);
            mMinute = c.get(Calendar.MINUTE);

            TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                    new TimePickerDialog.OnTimeSetListener() {
                        @RequiresApi(api = Build.VERSION_CODES.O)
                        @Override
                        public void onTimeSet(TimePicker view, int hourOfDay,int minute) {
                            schedulesExecutor.apply("s2",hourOfDay*60+minute);
                            start2.setText(hourOfDay + ":" + minute);
                        }
                    }, mHour, mMinute, true);
            timePickerDialog.show();
        }
    }

    private String minToTime(int min){
        int h = min/60;
        int m = min%60;
        return new String(h+":"+m);
    }

}
