package gpne.bell.kili.bell;


import android.widget.SeekBar;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SeekBarFactory {

    SchedulesExecutor schedulesExecutor;

    public SeekBarFactory(SchedulesExecutor schedulesExecutor) {
        this.schedulesExecutor = schedulesExecutor;
    }

    public void buildHours(List<Hour> hours) {
        for (Hour hour : hours) {
            TextView textView = hour.getTextView();
            String text = hour.getText();
            SeekBar seekBar = hour.getSeekBar();
            String index = hour.getIndex();
            SeekBarWithTextListener seekBarWithTextListener = new SeekBarWithTextListener(textView,text,index,schedulesExecutor);
            seekBar.setOnSeekBarChangeListener(seekBarWithTextListener);
            seekBar.setMax(0);
            seekBar.setMax(40);
            seekBar.setProgress(40);
        }
    }

    public void buildAntracts(List<Hour> hours) {
        for (Hour hour : hours) {
            TextView textView = hour.getTextView();
            String text = hour.getText();
            SeekBar seekBar = hour.getSeekBar();
            String index = hour.getIndex();
            SeekBarWithTextListener seekBarWithTextListener = new SeekBarWithTextListener(textView,text,index,schedulesExecutor);
            seekBar.setOnSeekBarChangeListener(seekBarWithTextListener);
            seekBar.setMax(0);
            seekBar.setMax(15);
            seekBar.setProgress(10);
        }
    }
}
