package com.example.calculatorappkhan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    String eqn = "";
    String first = "";
    String second = "";
    TextView tvNumbers = findViewById(R.id.textViewNumbers);
    boolean doneOperation = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void numClick(View v){
        // Code for how to get text from a pressed button, found here:
        // https://stackoverflow.com/questions/5620772/get-text-from-pressed-button
        Button b = (Button)v;
        String buttonText = b.getText().toString();

        if(buttonText.equals("CLEAR")){
            eqn = "";
            tvNumbers.setText("0");
        }
        else if(!doneOperation){
            first += buttonText;
            tvNumbers.setText(first);
        }
        else{
            second += buttonText;
            tvNumbers.setText(second);
        }
    }

    public void equation(View v){
        // Code for how to get text from a pressed button, found here:
        // https://stackoverflow.com/questions/5620772/get-text-from-pressed-button
        Button b = (Button)v;
        String buttonText = b.getText().toString();
        String operation = "";

        if(!buttonText.equals("=")){
            operation = buttonText;
            doneOperation = true;
        }
        else{
            Double part1 = Double.parseDouble(first);
            Double part2 = Double.parseDouble(second);
            Double result = 0.0;

            if(operation.equals("/")){
                result = (part1 / part2);
            }
            else if(operation.equals("*")){
                result = (part1 * part2);
            }
            else if(operation.equals("-")){
                result = (part1 - part2);
            }
            else if(operation.equals("+")){
                result = (part1 + part2);
            }
            else if(operation.equals("%")){
                result = (part1 % part2);
            }

            tvNumbers.setText(result.toString());
        }
    }
}