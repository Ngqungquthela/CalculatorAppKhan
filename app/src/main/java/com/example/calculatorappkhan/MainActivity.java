package com.example.calculatorappkhan;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    String eqnText, first, operation, second;
    TextView tvNumbers;
    boolean doneOperation, resultReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eqnText = "0";
        first = "0";
        operation = "";
        second = "";
        tvNumbers = findViewById(R.id.textViewNumbers);
        doneOperation = false;
        resultReset = true;
    }

    public void numClick(View v){
        // Code for how to get text from a pressed button, found here:
        // https://stackoverflow.com/questions/5620772/get-text-from-pressed-button
        Button b = (Button)v;
        String buttonText = b.getText().toString();

        if(buttonText.equals("CLEAR")){
            eqnText = "0";
            first = "0";
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
            if(resultReset){
                first = "";
                eqnText = "";
                resultReset = false;
            }
            if(first.contains(".") && buttonText.equals(".")){
                buttonText = "";
            }
            first += buttonText;
            eqnText += buttonText;
            tvNumbers.setText(eqnText);
            Log.i("khan", eqnText);
        }
        else{
            if(second.contains(".") && buttonText.equals(".")){
                buttonText = "";
            }
            second += buttonText;
            eqnText += buttonText;
            tvNumbers.setText(eqnText);
            Log.i("khan", eqnText);
        }
    }

    public void equation(String one, String op, String two){
        Double part1 = Double.parseDouble(one);
        Double part2 = Double.parseDouble(two);
        double result;
        String resultText;

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
        if(result % 1 == 0){
            resultText = (int)result + "";
        }
        else{
            resultText = result + "";
        }

        tvNumbers.setText(resultText);
        eqnText = resultText;
        first = resultText;
        second = "";
        operation = "";
        doneOperation = false;
        resultReset = true;
    }
}