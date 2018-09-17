package comaa.example.hanhyeonmin.subway3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class StationActivity extends AppCompatActivity {
    private TextView stationTextView;
    private DatabaseReference databaseReference;
    private ArrayAdapter<String> touristAdapter;
    private ListView stationList;
    private ArrayList<String> data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_station);

        Intent intent = getIntent();
        stationTextView = findViewById(R.id.stationTextView);
        stationTextView.setText(intent.getStringExtra("STATION"));

        touristAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data);

        stationList = findViewById(R.id.tourist_list);
        stationList.setAdapter(touristAdapter);
        stationList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(StationActivity.this, TouristActivity.class);
                intent.putExtra("TOURIST", adapterView.getItemAtPosition(i).toString());
                startActivity(intent);
            }
        });

        databaseReference = FirebaseDatabase.getInstance().getReference();
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                touristAdapter.clear();

                for(DataSnapshot data : dataSnapshot.child("station").child("tourist").getChildren()){
                    touristAdapter.add(data.getValue(String.class));
                }

                touristAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });




    }

}
