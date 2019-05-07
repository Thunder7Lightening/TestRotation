package tw.edu.ntut.sdtlab.crawler.testapp.testrotation;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class RotationDataRemainActivity extends AppCompatActivity {

    private EditText editText;
    private Button goToDataNotRemainActivityButton, goToCrashActivityButton;

    private String data;
    private SharedPreferences preference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rotation_data_remain);

        editText = (EditText) findViewById(R.id.editText);
        goToDataNotRemainActivityButton = (Button) findViewById(R.id.goToDataNotRemainActivityButton);
        goToCrashActivityButton = (Button) findViewById(R.id.goToCrashActivityButton);

        preference = getSharedPreferences("preFile", MODE_PRIVATE);
        data = preference.getString("data", getResources().getString(R.string.default_text));
        editText.setText(data);

        goToDataNotRemainActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToDataRemainActivity();
            }
        });

        goToCrashActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToCrashActivity();
            }
        });

    }

    @Override
    protected void onStop() {
        super.onStop();
        preference.edit()
                .putString("data", data)
                .commit();
    }

    private void goToDataRemainActivity() {
        Intent intent = new Intent(this, RotationDataNotRemainActivity.class);
        startActivity(intent);
    }

    private void goToCrashActivity() {
        Intent intent = new Intent(this, RotationCrashActivity.class);
        startActivity(intent);
    }
}
