package com.app.multicoloredittextexample;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.kishan.multicolor_edittext.MultiColorEditText;

public class MainActivity extends AppCompatActivity {
    MultiColorEditText multiColorEditText;
    Button btnChangeColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        multiColorEditText = findViewById(R.id.multiColorEditText);
        btnChangeColor = findViewById(R.id.btnChangeColor);
        btnChangeColor.setOnClickListener(view -> {
            multiColorEditText.setCurrentTextColor("#FF6F00");
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}