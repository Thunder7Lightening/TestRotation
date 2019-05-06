package tw.edu.ntut.sdtlab.crawler.testapp.testrotation;

import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class RotationCrashActivity extends AppCompatActivity {

    private TextView speakTextView3;
    private SharedPreferences preference;
    private Boolean dataSelection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rotation_crash);

        speakTextView3 = (TextView) findViewById(R.id.speakTextView3);

        preference = getSharedPreferences("remain", MODE_PRIVATE);
        dataSelection = preference.getBoolean("dataSelection", true);

        String data = getData();
        speakTextView3.setText(data);
    }

    private String getData() {
        String data = "";
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT)
            data = "portrait";
        else
            crash();
        return data;
    }

    private void crash() {
        int crash = 1 / 0;
    }

    @Override
    protected void onStop() {
        super.onStop();
        preference.edit()
                .putBoolean("dataSelection", !dataSelection)
                .commit();
    }
}
