package gpne.bell.kili.bell;

import android.widget.SeekBar;
import android.widget.TextView;


public class SeekBarWithTextListener implements SeekBar.OnSeekBarChangeListener {

    private TextView textView;
    private String textField;
    private String index;
    private SchedulesExecutor schedulesExecutor;

    public SeekBarWithTextListener(TextView textView, String textField,String index, SchedulesExecutor schedulesExecutor) {
        this.textView = textView;
        this.textField = textField;
        this.index = index;
        this.schedulesExecutor = schedulesExecutor;
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        String textFormat = String.format(textField,i);
        schedulesExecutor.apply(index,i);
        textView.setText(textFormat);
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
