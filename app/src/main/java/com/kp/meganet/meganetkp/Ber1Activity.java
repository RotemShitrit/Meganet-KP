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

import java.util.ArrayList;

public class Ber1Activity extends AppCompatActivity {

    private Spinner meterSpinner, sizeSpinner, flowUnitSpinner, accUnitSpinner, resolutionSpinner, pulseWidthSpinner;
    private EditText id, factor, Q3, Q03, Q2, Q1, positive, negative, Accomulation;
    private Button programBtn;
    ArrayList<String> meters, sizes, flows, accUnit, resolution;
    Float acc, pos, neg, res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ber1_programming);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        meterSpinner = (Spinner) findViewById(R.id.MeterSpinner);
        sizeSpinner = (Spinner) findViewById(R.id.SpinnerSize);
        flowUnitSpinner = (Spinner) findViewById(R.id.SpinnerFlowUnit);
        accUnitSpinner = (Spinner) findViewById(R.id.SpinnerAccUnit);
        resolutionSpinner = (Spinner) findViewById(R.id.SpinnerResolution);
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

        meters = new ArrayList<String>();
        sizes = new ArrayList<String>();
        flows = new ArrayList<String>();
        accUnit = new ArrayList<String>();
        resolution = new ArrayList<String>();

        meters.add("900");
        meters.add("TurboBAR");
        meters.add("TurboIR");

        // Initializing an ArrayAdapter
        ArrayAdapter<String> meterSpinnerArrayAdapter = new ArrayAdapter<String>(this, R.layout.checked, meters);
        meterSpinnerArrayAdapter.setDropDownViewResource(R.layout.spinner_item);
        meterSpinner.setAdapter(meterSpinnerArrayAdapter);

        meterSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                sizes.clear();
                String meter = (String) meterSpinner.getSelectedItem();
                if(meter.equals("900")) {
                    //sizes = new String[]{"2\"", "3\"", "4\"", "6\"", "8\""};
                    sizes.add("2\"");
                    sizes.add("3\"");
                    sizes.add("4\"");
                    sizes.add("6\"");
                    sizes.add("8\"");
                } else if(meter.equals("TurboBAR")){
                    //sizes = new String[]{"2.5\"", "3\"", "4\"", "5\"", "6\"", "8\"", "10\"", "11\"", "12\""};
                    sizes.add("2.5\"");
                    sizes.add("3\"");
                    sizes.add("4\"");
                    sizes.add("5\"");
                    sizes.add("6\"");
                    sizes.add("8\"");
                    sizes.add("10\"");
                    sizes.add("11\"");
                    sizes.add("12\"");
                } else if(meter.equals("TurboIR")){
                    //sizes = new String[]{"1.5\"", "2\"", "2.5\"", "3\"", "4\"", "5\"", "6\"", "8\"", "10\"", "12\"", "16\"", "20\""};
                    sizes.add("1.5\"");
                    sizes.add("2\"");
                    sizes.add("2.5\"");
                    sizes.add("3\"");
                    sizes.add("4\"");
                    sizes.add("5\"");
                    sizes.add("6\"");
                    sizes.add("8\"");
                    sizes.add("10\"");
                    sizes.add("12\"");
                    sizes.add("16\"");
                    sizes.add("20\"");
                }

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
        Accomulation.setText("11111");
        negative.setText("1100");
        positive.setText(String.valueOf(Integer.valueOf(String.valueOf(Accomulation.getText())) + Integer.valueOf(String.valueOf(negative.getText()))));

        Accomulation.setOnFocusChangeListener(new View.OnFocusChangeListener(){
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    if(res<1 && acc*res == Float.valueOf(String.valueOf(Accomulation.getText())))
                    {
                        //Do Nothing
                    }
                    else {
                        acc = Float.valueOf(String.valueOf(Accomulation.getText()));
                        pos = acc + neg;

                        if (accUnitSpinner.getSelectedItem().toString().equals("M3")) {
                            res = Float.valueOf(resolutionSpinner.getSelectedItem().toString());
                            if (res < 1) {
                                Accomulation.setText(String.valueOf(acc * res));
                                negative.setText(String.valueOf(neg * res));
                                positive.setText(String.valueOf(pos * res));
                            }
                        }
                    }
                }
            }
        });

        negative.setOnFocusChangeListener(new View.OnFocusChangeListener(){
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    if(res<1 && neg*res == Float.valueOf(String.valueOf(negative.getText())))
                    {
                        //Do Nothing
                    }
                    else {
                        neg = Float.valueOf(String.valueOf(negative.getText()));
                        pos = acc + neg;

                        if (accUnitSpinner.getSelectedItem().toString().equals("M3")) {
                            res = Float.valueOf(resolutionSpinner.getSelectedItem().toString());
                            if (res < 1) {
                                Accomulation.setText(String.valueOf(acc * res));
                                negative.setText(String.valueOf(neg * res));
                                positive.setText(String.valueOf(pos * res));
                            }
                        }
                    }
                }
            }
        });

        flows.add("M3/h");
        flows.add("L/S");
        flows.add("GPM");
        flows.add("CFS");

        // Initializing an ArrayAdapter
        ArrayAdapter<String> flowSpinnerArrayAdapter = new ArrayAdapter<String>(this, R.layout.checked, flows);
        flowSpinnerArrayAdapter.setDropDownViewResource(R.layout.spinner_item);
        flowUnitSpinner.setAdapter(flowSpinnerArrayAdapter);

        flowUnitSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                accUnit.clear();
                resolution.clear();
                String flowUnit = (String) flowUnitSpinner.getSelectedItem();

                if (flowUnit.equals("M3/h") || flowUnit.equals("L/S")) {
                    //AccUnit = new String[]{"M3"};
                    accUnit.add("M3");
                    //resolution = new String[]{"0.001","0.01","0.1","1","10","100"};
                    resolution.add("0.001");
                    resolution.add("0.01");
                    resolution.add("0.1");
                    resolution.add("1");
                    resolution.add("10");
                    resolution.add("100");

                } else if (flowUnit.equals("GPM")) {
                    //AccUnit = new String[]{"GAL", "AF"};
                    accUnit.add("GAL");
                    accUnit.add("AF");
                    //resolution = new String[]{"1","10","100","1000","10000"};
                    resolution.add("1");
                    resolution.add("10");
                    resolution.add("100");
                    resolution.add("1000");
                    resolution.add("10000");

                } else if (flowUnit.equals("CFS")) {
                   //AccUnit = new String[]{"AF","CFT"};
                    accUnit.add("AF");
                    accUnit.add("CFT");
                    //resolution = new String[]{"0.1","1","10","100","1000","10000"};
                    resolution.add("0.1");
                    resolution.add("1");
                    resolution.add("10");
                    resolution.add("100");
                    resolution.add("1000");
                    resolution.add("10000");
                }

                ArrayAdapter<String> accUnitArrayAdapter = new ArrayAdapter<String>
                        (getApplicationContext(), R.layout.checked, accUnit);
                accUnitArrayAdapter.setDropDownViewResource(R.layout.spinner_item);
                accUnitSpinner.setAdapter(accUnitArrayAdapter);

                ArrayAdapter<String> resolutionArrayAdapter = new ArrayAdapter<String>
                        (getApplicationContext(), R.layout.checked, resolution);
                resolutionArrayAdapter.setDropDownViewResource(R.layout.spinner_item);
                resolutionSpinner.setAdapter(resolutionArrayAdapter);

                resolutionSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        res = Float.valueOf(resolutionSpinner.getSelectedItem().toString());
                        if(res<1) {
                            Accomulation.setText(String.valueOf(acc * res));
                            negative.setText(String.valueOf(neg * res));
                            positive.setText(String.valueOf(pos * res));
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });

                accUnitSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        if(accUnitSpinner.getSelectedItem().toString().equals("M3"))
                        {
                            res = Float.valueOf(resolutionSpinner.getSelectedItem().toString());
                            if(res<1) {
                                Accomulation.setText(String.valueOf(acc * res));
                                negative.setText(String.valueOf(neg * res));
                                positive.setText(String.valueOf(pos * res));
                            }
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
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
        pulseWidthSpinner.setSelection(0);

        programBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        acc = Float.valueOf(String.valueOf(Accomulation.getText()));
        neg = Float.valueOf(String.valueOf(negative.getText()));
        pos = Float.valueOf(String.valueOf(positive.getText()));

        meterSpinner.setSelection(0);
        flowUnitSpinner.setSelection(0);
    }
}