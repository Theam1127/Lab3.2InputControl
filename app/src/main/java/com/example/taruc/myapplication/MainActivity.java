package com.example.taruc.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    private Spinner spinnerAge;
    private RadioButton radioButtonMale, radioButtonFemale;
    private CheckBox checkBoxSmoker;
    private TextView textViewPremium;
    private double basicPremium, temp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinnerAge = (Spinner) findViewById(R.id.spinnerAge);
        radioButtonMale = (RadioButton) findViewById(R.id.radioButtonMale);
        radioButtonFemale = (RadioButton) findViewById(R.id.radioButtonFemale);
        checkBoxSmoker = (CheckBox) findViewById(R.id.checkBoxSmoker);
        textViewPremium = (TextView) findViewById(R.id.textViewPremium);

        spinnerAge.setOnItemSelectedListener(this);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.age, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerAge.setAdapter(adapter);


    }

    public void reset(View view){
        radioButtonMale.setChecked(false);
        radioButtonFemale.setChecked(false);
        checkBoxSmoker.setChecked(false);
        spinnerAge.setSelection(0);
        textViewPremium.setText(getResources().getString(R.string.premium));
    }

    public void calculate(View view) {
        basicPremium = temp;
        if (radioButtonMale.isChecked()) {
            switch (spinnerAge.getSelectedItemPosition()) {
                case 2:
                    basicPremium += 50;
                    break;
                case 3:
                    if (checkBoxSmoker.isChecked())
                        basicPremium += 200;
                    else
                        basicPremium += 100;
                    break;
                case 4:
                    if (checkBoxSmoker.isChecked())
                        basicPremium += 250;
                    else
                        basicPremium += 100;
                    break;
                case 5:
                    if (checkBoxSmoker.isChecked())
                        basicPremium += 200;
                    else
                        basicPremium += 50;
                    break;
                default:
                    break;
            }
        } else {
            if (checkBoxSmoker.isChecked())
                switch (spinnerAge.getSelectedItemPosition()) {
                    case 3:
                        basicPremium += 100;
                        break;
                    case 4:
                        basicPremium += 150;
                        break;
                    case 5:
                        basicPremium += 150;
                        break;
                    case 6:
                        basicPremium += 250;
                        break;
                    case 7:
                        basicPremium += 250;
                        break;
                    default:
                        break;
                }
        }
        textViewPremium.setText(getResources().getString(R.string.premium) + basicPremium);
    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch(position){
            case 0:
                basicPremium = 50;
                break;
            case 1:
                basicPremium = 55;
                break;
            case 2:
                basicPremium = 60;
                break;
            case 3:
                basicPremium = 70;
                break;
            case 4:
                basicPremium = 120;
                break;
            case 5:
                basicPremium = 160;
                break;
            case 6:
                basicPremium = 200;
                break;
            case 7:
                basicPremium = 250;
                break;

        }
        temp = basicPremium;
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
