package gpne.bell.kili.bell;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Hour> hours = new ArrayList<>();
        List<Hour> antracts = new ArrayList<>();

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

        SeekBarFactory seekBarFactory = new SeekBarFactory();
        seekBarFactory.buildHours(hours);
        seekBarFactory.buildAntracts(antracts);
    }
}
