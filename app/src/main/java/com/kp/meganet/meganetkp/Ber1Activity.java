package com.kp.meganet.meganetkp;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class Ber1Activity extends AppCompatActivity {

    private Spinner meterSpinner, sizeSpinner, flowUnitSpinner, volumeTypeSpinner, pulseVolumeSpinner, pulseWidthSpinner;
    private EditText id, factor, Q3, Q03, Q2, Q1, positive, negative, Accomulation;
    private Button programBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ber1_programming);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        meterSpinner = (Spinner) findViewById(R.id.MeterSpinner);
        sizeSpinner = (Spinner) findViewById(R.id.SpinnerSize);
        flowUnitSpinner = (Spinner) findViewById(R.id.SpinnerFlowUnit);
        volumeTypeSpinner = (Spinner) findViewById(R.id.SpinnerVolumeType);
        pulseVolumeSpinner = (Spinner) findViewById(R.id.SpinnerPulseVolume);
        pulseWidthSpinner = (Spinner) findViewById(R.id.SpinnerPulseWidth);
        programBtn = (Button) findViewById(R.id.programBtn);

        id = (EditText) findViewById(R.id.editTextID);
        factor = (EditText) findViewById(R.id.editTextFactor);
        Q3 = (EditText) findViewById(R.id.editTextQ3);
        Q03 = (EditText) findViewById(R.id.editTextQ03);
        Q2 = (EditText) findViewById(R.id.editTextQ2);
        Q1 = (EditText) findViewById(R.id.editTextQ1);
        positive = (EditText) findViewById(R.id.editTextPositive);
        negative = (EditText) findViewById(R.id.editTextNegative);
        Accomulation = (EditText) findViewById(R.id.editTextAccomulation);

        String[] meters = {"900", "TurboBAR", "TurboIR"};
        // Initializing an ArrayAdapter
        ArrayAdapter<String> meterSpinnerArrayAdapter = new ArrayAdapter<String>(
                this, R.layout.checked, meters
        );
        meterSpinnerArrayAdapter.setDropDownViewResource(R.layout.spinner_item);
        meterSpinner.setAdapter(meterSpinnerArrayAdapter);

        meterSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String[] sizes;
                String meter = (String) meterSpinner.getSelectedItem();
                if(meter.equals("900")) {
                    sizes = new String[]{"2\"", "3\"", "4\"", "6\"", "8\""};
                } else if(meter.equals("TurboBAR")){
                    sizes = new String[]{"2.5\"", "3\"", "4\"", "5\"", "6\"", "8\"", "10\"", "11\"", "12\""};
                } else if(meter.equals("TurboIR")){
                    sizes = new String[]{"1.5\"", "2\"", "2.5\"", "3\"", "4\"", "5\"", "6\"", "8\"", "10\"", "12\"", "16\"", "20\""};
                } else
                    sizes = new String[0];

                // Initializing an ArrayAdapter
                ArrayAdapter<String> sizeSpinnerArrayAdapter = new ArrayAdapter<String>(
                        getApplicationContext(), R.layout.checked, sizes);
                sizeSpinnerArrayAdapter.setDropDownViewResource(R.layout.spinner_item);
                sizeSpinner.setAdapter(sizeSpinnerArrayAdapter);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        id.setText("100");
        factor.setText("25000");
        Q3.setText("-9.99");
        Q03.setText("1.44");
        Q2.setText("-0.8");
        Q1.setText("1.23");
        positive.setText("17385");
        negative.setText("4563");
        Accomulation.setText(String.valueOf(Integer.valueOf(String.valueOf(positive.getText())) - Integer.valueOf(String.valueOf(negative.getText()))));


        String[] flows = {"M3/h", "L/S", "GPM", "CFS"};
        // Initializing an ArrayAdapter
        ArrayAdapter<String> flowSpinnerArrayAdapter = new ArrayAdapter<String>(
                this, R.layout.checked, flows
        );
        flowSpinnerArrayAdapter.setDropDownViewResource(R.layout.spinner_item);
        flowUnitSpinner.setAdapter(flowSpinnerArrayAdapter);

        flowUnitSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String[] volumeTypes, pulseVolumes;
                String flowUnit = (String) flowUnitSpinner.getSelectedItem();
                if (flowUnit.equals("M3/h") || flowUnit.equals("L/S")) {
                    volumeTypes = new String[]{"M3"};
                    pulseVolumes = new String[]{"0.001","0.01","0.1","1","10","100"};
                } else if (flowUnit.equals("GPM")) {
                    volumeTypes = new String[]{"GAL", "AF"};
                    pulseVolumes = new String[]{"1","10","100","1000","10000"};
                } else if (flowUnit.equals("CFS")) {
                    volumeTypes = new String[]{"AF","CFT"};
                    pulseVolumes = new String[]{"0.1","1","10","100","1000","10000"};
                } else {
                    volumeTypes = new String[0];
                    pulseVolumes = new String[0];
                }

                ArrayAdapter<String> volumeTypesArrayAdapter = new ArrayAdapter<String>
                        (getApplicationContext(), R.layout.checked, volumeTypes);
                volumeTypesArrayAdapter.setDropDownViewResource(R.layout.spinner_item);
                volumeTypeSpinner.setAdapter(volumeTypesArrayAdapter);

                ArrayAdapter<String> pulseVolumeArrayAdapter = new ArrayAdapter<String>
                        (getApplicationContext(), R.layout.checked, pulseVolumes);
                pulseVolumeArrayAdapter.setDropDownViewResource(R.layout.spinner_item);
                pulseVolumeSpinner.setAdapter(pulseVolumeArrayAdapter);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        String[] pulseWidths = {"off", "50", "100", "200", "300", "400", "500"};
        ArrayAdapter<String> pulseWidthSpinnerArrayAdapter = new ArrayAdapter<String>
                (getApplicationContext(), R.layout.checked, pulseWidths);
        pulseWidthSpinnerArrayAdapter.setDropDownViewResource(R.layout.spinner_item);
        pulseWidthSpinner.setAdapter(pulseWidthSpinnerArrayAdapter);

        programBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}