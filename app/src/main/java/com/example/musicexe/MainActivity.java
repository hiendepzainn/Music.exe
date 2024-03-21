package com.example.musicexe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button buttonPlayResume, buttonStop;
    boolean isPlay = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonPlayResume = findViewById(R.id.buttonPlayResume);
        buttonStop = findViewById(R.id.buttonStop);

        buttonPlayResume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // khai báo Intent để khởi động Service
                Intent intent1 = new Intent(MainActivity.this, MyService.class);
                startService(intent1);
                if (isPlay == false) {
                    isPlay = true;
                    buttonPlayResume.setText("Resume");
                } else {
                    isPlay = false;
                    buttonPlayResume.setText("Play");
                }
            }
        });

        buttonStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(MainActivity.this, MyService.class);
                stopService(intent2);
                buttonPlayResume.setText("Play");
                isPlay = false;
            }
        });
    }
}