package com.example.calculatorappkhan;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    String eqnText;
    String first;
    String operation;
    String second;
    TextView tvNumbers;
    boolean doneOperation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eqnText = "";
        first = "";
        operation = "";
        second = "";
        tvNumbers = findViewById(R.id.textViewNumbers);
        doneOperation = false;
    }

    public void numClick(View v){
        // Code for how to get text from a pressed button, found here:
        // https://stackoverflow.com/questions/5620772/get-text-from-pressed-button
        Button b = (Button)v;
        String buttonText = b.getText().toString();

        if(buttonText.equals("CLEAR")){
            eqnText = "";
            first = "";
            second = "";
            operation = "";
            doneOperation = false;
            tvNumbers.setText("0");
        }
        else if(buttonText.equals("=")){
            equation(first, operation, second);
        }
        else if(buttonText.equals("/") || buttonText.equals("*") || buttonText.equals("-") || buttonText.equals("+") || buttonText.equals("%")){
            operation = buttonText;
            eqnText += (" " + operation + " ");
            tvNumbers.setText(eqnText);
            doneOperation = true;
            Log.i("khan", eqnText);
        }
        else if(!doneOperation){
            first += buttonText;
            eqnText += buttonText;
            tvNumbers.setText(eqnText);
            Log.i("khan", eqnText);
        }
        else{
            second += buttonText;
            eqnText += buttonText;
            tvNumbers.setText(eqnText);
            Log.i("khan", eqnText);
        }
    }

    public void equation(String one, String op, String two){
        Double part1 = Double.parseDouble(one);
        Double part2 = Double.parseDouble(two);
        Double result;

        if(op.equals("/")){
            result = (part1 / part2);
        }
        else if(op.equals("*")){
            result = (part1 * part2);
        }
        else if(op.equals("-")){
            result = (part1 - part2);
        }
        else if(op.equals("+")){
            result = (part1 + part2);
        }
        else{
            result = (part1 % part2);
        }
        result = Math.floor(result * 1000) / 1000;
        tvNumbers.setText(result.toString());
        eqnText = "";
        first = "";
        second = "";
        operation = "";
        doneOperation = false;
    }
}