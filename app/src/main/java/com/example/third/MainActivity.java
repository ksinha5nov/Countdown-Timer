package com.example.third;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView timerTextview;
    SeekBar timerSeekbar;
    Boolean counteractive = false;
    Button goButton;
    CountDownTimer countDownTimer;

    public void resetTimer(){
        timerTextview.setText("00:00");
        timerSeekbar.setProgress(0);
        timerSeekbar.setEnabled(true);
        countDownTimer.cancel();
        goButton.setText("GO!");
        counteractive = false;
    }
    
    public void clickk(View view) {
        if(counteractive){
            resetTimer();

        }else{
            counteractive = true;
            timerSeekbar.setEnabled(false);
            goButton.setText("STOP!");

             countDownTimer = new CountDownTimer(timerSeekbar.getProgress() * 1000 + 100, 1000) {

                @Override
                public void onTick(long l) {
                    updateTimer((int) l/1000);
                    timerSeekbar.setProgress((int) l/1000);
                }

                @Override
                public void onFinish() {
                    resetTimer();

                }
            }.start();
        }


    }
        public void updateTimer(int secondsLeft){
            int minutes = secondsLeft/60;
            int seconds = secondsLeft - (minutes * 60);
            String secondString = Integer.toString(seconds);
            if(seconds <= 9) {
                secondString = "0" + secondString;

                timerTextview.setText(String.format("%02d", minutes) + ":" + secondString);
            }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timerSeekbar = findViewById(R.id.timerSeekBar);
        timerTextview = findViewById(R.id.timerTextView);
        goButton = findViewById(R.id.goButton);

        timerSeekbar.setMax(600);
        timerSeekbar.setProgress(0);

        timerSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });






    }
}
