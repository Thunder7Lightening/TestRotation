package tw.edu.ntut.sdtlab.crawler.testapp.testrotation;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class RotationErrorActivity extends AppCompatActivity {

    private TextView textView2;
    private SharedPreferences preference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rotation_error);
        textView2 = (TextView) findViewById(R.id.textView2);

        Boolean shouldRemain = getSharedPreferences("remain", MODE_PRIVATE).getBoolean("shouldRemain", false);

        Bundle bundle = this.getIntent().getExtras();
        String data = shouldRemain ? "Default" : bundle.getString("data");
        textView2.setText(data);
    }

    @Override
    protected void onStop() {
        super.onStop();
        preference.edit()
                .putBoolean("shouldRemain", true)
                .commit();
    }
}
