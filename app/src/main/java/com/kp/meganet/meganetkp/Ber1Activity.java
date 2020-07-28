package com.kp.meganet.meganetkp;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class Ber1Activity extends AppCompatActivity {

    private Spinner meterSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ber1_programming);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        meterSpinner = (Spinner) findViewById(R.id.MeterSpinner);


        String[] meters = {"900", "TurboBAR", "TurboIR"};
        // Initializing an ArrayAdapter
        ArrayAdapter<String> meterSpinnerArrayAdapter = new ArrayAdapter<String>(
                this,android.R.layout.simple_spinner_item,meters
        );
        meterSpinnerArrayAdapter.setDropDownViewResource(R.layout.spinner_item);
        meterSpinner.setAdapter(meterSpinnerArrayAdapter);
    }

}
