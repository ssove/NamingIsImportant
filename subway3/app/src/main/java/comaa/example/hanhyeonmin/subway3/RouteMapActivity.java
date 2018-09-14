package comaa.example.hanhyeonmin.subway3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class RouteMapActivity extends AppCompatActivity {
    private Button stationButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_route_map);

        stationButton = findViewById(R.id.stationButton);
        stationButton.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RouteMapActivity.this, StationActivity.class);
                intent.putExtra("STATION", "seoul");
                System.out.println(" hh ");
                startActivity(intent);
            }
        });
    }
}
