package com.example.calculatorappkhan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clear(View v){
        TextView tvNumbers = findViewById(R.id.textViewNumbers);
        tvNumbers.setText("0");
    }

    public void numClick(View v){
        // Code for how to get text from a pressed button, found here:
        // https://stackoverflow.com/questions/5620772/get-text-from-pressed-button
        Button b = (Button)v;
        String buttonText = b.getText().toString();

        TextView tvNumbers = findViewById(R.id.textViewNumbers);

        if(tvNumbers.toString().equals("0")){
            tvNumbers.setText(buttonText);
        }
        else {
            tvNumbers.setText(tvNumbers + buttonText);
        }
    }
}