package comaa.example.hanhyeonmin.subway3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class TouristActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tourist);

        Intent intent = getIntent();
        TextView testView = findViewById(R.id.textView);
        testView.setText(intent.getStringExtra("TOURIST"));
    }
}
