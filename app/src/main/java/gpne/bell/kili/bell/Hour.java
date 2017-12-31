package gpne.bell.kili.bell;


import android.widget.SeekBar;
import android.widget.TextView;

public class Hour {

    private SeekBar seekBar;
    private TextView textView;
    private String text;
    private String index;

    public Hour(SeekBar seekBar, TextView textView, String text, String index) {
        this.seekBar = seekBar;
        this.textView = textView;
        this.text = text;
        this.index = index;
    }

    public SeekBar getSeekBar() {
        return seekBar;
    }

    public TextView getTextView() {
        return textView;
    }

    public String getText() {
        return text;
    }

    public String getIndex() {
        return index;
    }
}
