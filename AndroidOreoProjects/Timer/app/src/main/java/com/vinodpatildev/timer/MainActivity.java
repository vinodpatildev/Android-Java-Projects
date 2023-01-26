package com.vinodpatildev.timer;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private SeekBar pbTime;
    private TextView tvTime;
    private Button btnStartPause;
    private MediaPlayer mediaPlayer;
    private CountDownTimer countDownTimer;

    private Boolean timerIsRunning = false;


    private void setupCountDownTimer(int seconds){
        countDownTimer = new CountDownTimer(seconds*1000,1000) {
            @Override
            public void onTick(long l) {
                l = l/1000;
                pbTime.setProgress((int)(l));

                long minl = l / 60;
                long secl = l % 60;

                String min = Long.toString(minl);
                if(min.length()==1){
                    min = "0"+min;
                }
                String sec = Long.toString(secl);
                if(sec.length()==1){
                    sec = "0"+sec;
                }
                tvTime.setText(min + ":" + sec);
            }
            @Override
            public void onFinish() {
                mediaPlayer.start();
            }
        };
        countDownTimer.start();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pbTime = (SeekBar) findViewById(R.id.pbTime);
        tvTime = (TextView) findViewById(R.id.tvTime);
        btnStartPause = (Button) findViewById(R.id.btnStartPause);
        mediaPlayer = MediaPlayer.create(this,R.raw.alarm_sound);

        pbTime.setMax(600);
        pbTime.setProgress(600);

        pbTime.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                countDownTimer.cancel();
                countDownTimer = null;
                setupCountDownTimer(i);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        btnStartPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(timerIsRunning){
                    timerIsRunning = false;
                    btnStartPause.setText("Play");
                    if(countDownTimer != null){
                        countDownTimer.cancel();
                        countDownTimer = null;
                    }
                }else{
                    timerIsRunning = true;
                    btnStartPause.setText("Pause");
                    setupCountDownTimer(600);
                }
            }
        });
    }
}