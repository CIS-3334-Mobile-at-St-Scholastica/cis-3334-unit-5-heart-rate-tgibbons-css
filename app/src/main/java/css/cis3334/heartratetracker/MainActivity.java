package css.cis3334.heartratetracker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    HeartRateList heartRateList;        // The list of heart rate objects

    TextView tvSelect;
    ListView lvHeartRates;          // The listview of the heartrates
    RecyclerView rvHeartRates;

    HeartRateAdapter hrAdapter;         // The array adapter for the heartrates
    HeartRateRecyclerAdapter rvAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        heartRateList = new HeartRateList();
        heartRateList.InitRandomElderly();

        tvSelect = findViewById(R.id.tvSelect);
        lvHeartRates = findViewById(R.id.lvHeartRate);
        rvHeartRates = findViewById((R.id.rvHeartRate));

        setupHrList();

        // specify an adapter (see also next example)
        rvAdapter = new HeartRateRecyclerAdapter(heartRateList);
        rvHeartRates.setAdapter(rvAdapter);

    }

    private void setupHrList() {

        hrAdapter = new HeartRateAdapter(this, R.layout.heart_rate_row, R.id.textViewPulse, heartRateList);
        hrAdapter.setDropDownViewResource(R.layout.heart_rate_row);
        lvHeartRates.setAdapter(hrAdapter);

        lvHeartRates.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, final View view, int position, long id) {
                HeartRate hr = (HeartRate) parent.getItemAtPosition(position);
                tvSelect.setText("You selected: " + hr.toString());
            }
        });
    }
}
