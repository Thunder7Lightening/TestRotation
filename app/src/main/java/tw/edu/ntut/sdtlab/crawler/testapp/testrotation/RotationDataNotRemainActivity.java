package tw.edu.ntut.sdtlab.crawler.testapp.testrotation;

import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class RotationDataNotRemainActivity extends AppCompatActivity {

    private TextView speakTextView2;
    private SharedPreferences preference;
    private Boolean dataSelection = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rotation_not_data_remain);

        speakTextView2 = (TextView) findViewById(R.id.speakTextView2);

        preference = getSharedPreferences("remain", MODE_PRIVATE);
        dataSelection = preference.getBoolean("dataSelection", true);
        
        String data = getData();
        speakTextView2.setText(data);
    }

    private String getData() {
        String data = "";
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT)
            data = "portrait";
        else
            data = "landscape";
        return data;
    }

    @Override
    protected void onStop() {
        super.onStop();
        preference.edit()
                .putBoolean("dataSelection", !dataSelection)
                .commit();
    }
}
