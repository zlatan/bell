package gpne.bell.kili.bell;



import android.widget.SeekBar;
import android.widget.TextView;

import java.util.Map;

public class SeekBarWithTextListener implements SeekBar.OnSeekBarChangeListener {

    private TextView textView;
    private String textField;
    private String index;
    private Map<String,Integer> schedules;

    public SeekBarWithTextListener(TextView textView, String textField,String index,  Map<String,Integer> schedules) {
        this.textView = textView;
        this.textField = textField;
        this.index = index;
        this.schedules = schedules;
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        String textFormat = String.format(textField,i);
        schedules.put(index,i);
        textView.setText(textFormat);
        SchedulesExecutor schedulesExecutor = new SchedulesExecutor(schedules);
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
