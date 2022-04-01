package com.example.task21p;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    ImageButton tape, thermostat, weight;
    TextView TV1, TV2, TV3;
    EditText EV1, EV2, EV3, VI;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // spinner setup
        Spinner spinner = findViewById(R.id.dropDownBox);
        // set which text populates the spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.units, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource((android.R.layout.simple_spinner_item));
        spinner.setAdapter(adapter);
        // reacting to clicks
        spinner.setOnItemSelectedListener(this);
    }

    @Override
    // when selecting an item will change the state of the text boxes
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String text = adapterView.getItemAtPosition(i).toString();
        Toast.makeText(adapterView.getContext(), text, Toast.LENGTH_SHORT).show();
    // occurs when the button is pushed
        tape = findViewById(R.id.tapeButton);
        thermostat = findViewById(R.id.thermostatButton);
        weight = findViewById(R.id.weightButton);
        VI = findViewById((R.id.valueInput));
        TV1 = findViewById(R.id.textView1);
        TV2 = findViewById((R.id.textView2));
        TV3 = findViewById((R.id.textView3));
        EV1 = findViewById((R.id.decimalText1));
        EV2 = findViewById((R.id.decimalText2));
        EV3 = findViewById((R.id.decimalText3));
        tape.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if (adapterView.getItemAtPosition(i) != adapterView.getItemAtPosition(0)){
                    Toast.makeText(MainActivity.this, "wrong button", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity.this, "metre converted", Toast.LENGTH_SHORT).show();
                    TV1.setText(R.string.centimetre);
                    TV2.setText(R.string.foot);
                    TV3.setText(R.string.inch);

                    float value = Float.parseFloat(VI.getText().toString());

                    float centiResult = value * 100;
                    EV1.setText(String.valueOf(centiResult));

                    double footResult = value * 3.28084;
                    EV2.setText(String.valueOf(footResult).format("%.2f",footResult));

                    double inchResult = value * 39.37;
                    EV3.setText((String.valueOf(inchResult).format("%.2f",inchResult)));

                }

            }
        });
        thermostat.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if (adapterView.getItemAtPosition(i) != adapterView.getItemAtPosition(1)){
                    Toast.makeText(MainActivity.this, "wrong button", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity.this, "celsius converted", Toast.LENGTH_SHORT).show();
                    TV1.setText(R.string.fahrenheit);
                    TV2.setText(R.string.kelvin);
                    TV3.setText(R.string.empty);

                    float value = Float.parseFloat(VI.getText().toString());
                    double fahrenheitResult = (value * 1.8) + 32;
                    EV1.setText(String.valueOf(fahrenheitResult).format("%.2f", fahrenheitResult));

                    double kelvinResult = value * 273.15;
                    EV2.setText(String.valueOf(kelvinResult).format("%.2f", kelvinResult));

                    EV3.setText(R.string.empty);
                }

            }
        });
        weight.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if (adapterView.getItemAtPosition(i) != adapterView.getItemAtPosition(2)){
                    Toast.makeText(MainActivity.this, "wrong button", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity.this, "kilograms converted", Toast.LENGTH_SHORT).show();
                    TV1.setText(R.string.gram);
                    TV2.setText(R.string.ounce);
                    TV3.setText(R.string.pound);

                    float value = Float.parseFloat(VI.getText().toString());
                    double gramResult = value * 1000;
                    EV1.setText(String.valueOf(gramResult).format("%.2f", gramResult));

                    double ounceResult = value * 35.2739619;
                    EV2.setText(String.valueOf(ounceResult).format("%.2f", ounceResult));

                    double poundResult = value * 2.2046;
                    EV3.setText(String.valueOf(poundResult).format("%.2f", poundResult));
                }

            }
        });

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}