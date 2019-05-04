package tw.edu.ntut.sdtlab.crawler.testapp.testrotation;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private Button changeTextButton, nextPageButton;

    private String data;
    private SharedPreferences preference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textView);
        changeTextButton = (Button) findViewById(R.id.changeTextButton);
        nextPageButton = (Button) findViewById(R.id.nextPageButton);

        preference = getSharedPreferences("preFile", MODE_PRIVATE);
        data = preference.getString("data", "TextView");
        textView.setText(data);

        changeTextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = "Hello";
                textView.setText(data);
            }
        });

        nextPageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToNextPage();
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

    private void goToNextPage() {
        Intent intent = new Intent(this, RotationErrorActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("data", data);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
