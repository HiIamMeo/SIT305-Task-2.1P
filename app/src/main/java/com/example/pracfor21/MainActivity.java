package com.example.pracfor21;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public Spinner spinner;
    public EditText number;
    public TextView output1;
    public TextView output2;
    public TextView output3;
    public TextView label1;
    public TextView label2;
    public TextView label3;
    public ImageButton metreButton;
    public ImageButton tempButton;
    public ImageButton weightButton;

    public void variable(){
        spinner = findViewById(R.id.spinner);
        number = findViewById(R.id.input);
        output1 = findViewById(R.id.output1);
        output2 = findViewById(R.id.output2);
        output3 = findViewById(R.id.output3);
        label1 = findViewById(R.id.value1);
        label2 = findViewById(R.id.value2);
        label3 = findViewById(R.id.value3);

        metreButton = findViewById(R.id.button1);
        tempButton = findViewById(R.id.button2);
        weightButton = findViewById(R.id.button3);


// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.list_array, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);

        metreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickAction(view);
            }
        });

        tempButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickAction(view);
            }
        });

        weightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickAction(view);
            }
        });
    }

    public void clickAction(View view) {
        switch (view.getId()) {
            case R.id.button1: {
                if (spinner.getSelectedItem().toString().trim().equals("Metre")) {
                    DisplayLength();
                } else DisplayError();
            }
            break;
            case R.id.button2: {
                if (spinner.getSelectedItem().toString().trim().equals("Celsius")) {
                    DisplayTemp();
                } else DisplayError();
            }
            break;
            case R.id.button3: {
                if (spinner.getSelectedItem().toString().trim().equals("Kilograms")) {
                    DisplayWeight();
                } else DisplayError();
            }
            break;
        }
    }

    public void DisplayLength() {
        output1.setText("Centimeter");
        output2.setText("Foot");
        output3.setText("Inch");

        //centimetres
        double input = Double.valueOf(String.valueOf(number.getText()));;
        double result = input * 100;
        String roundedResult = String.format("%.2f", result);
        label1.setText(roundedResult);
        //foot
        result = input * 3.281;
        roundedResult = String.format("%.2f", result);
        label2.setText(roundedResult);
        //inch
        result = input * 39.37;
        roundedResult = String.format("%.2f", result);
        label3.setText(roundedResult);
    }

    public void DisplayTemp() {
        output1.setText("Fahrenheit");
        output2.setText("Kelvin");
        output3.setText("");

        //fahrenheit
        double input = Double.valueOf(String.valueOf(number.getText()));
        double result = input * 9 / 5 + 32;
        String roundedResult = String.format("%.2f", result);
        label1.setText(roundedResult);
        //kelvin
        result = input + 273.15;
        roundedResult = String.format("%.2f", result);
        label2.setText(roundedResult);
        //hide third area
        label3.setText("");
    }

    public void DisplayWeight() {
        output1.setText("Gram");
        output2.setText("Ounce(Oz)");
        output3.setText("Pound(lb)");

        //gram
        double input = Double.valueOf(String.valueOf(number.getText()));
        double result = input * 1000;
        String roundedResult = String.format("%.2f", result);
        label1.setText(roundedResult);
        //ounce
        result = input * 35.274;
        roundedResult = String.format("%.2f", result);
        label2.setText(roundedResult);
        //pound
        result = input * 2.205;
        roundedResult = String.format("%.2f", result);
        label3.setText(roundedResult);
    }

    public void DisplayError() {
        Toast.makeText(MainActivity.this, "Please select the correct conversion button", Toast.LENGTH_LONG).show();
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        variable();
    }
}