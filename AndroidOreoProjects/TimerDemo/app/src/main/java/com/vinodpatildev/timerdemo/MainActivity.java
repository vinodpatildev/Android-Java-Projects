package com.vinodpatildev.timerdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.widget.TextView;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tvTimer = (TextView) findViewById(R.id.tvTimer);

        //Method: 1
//        Handler handler = new Handler();
//        Runnable run = new Runnable() {
//            @Override
//            public void run() {
//                String hr = Integer.toString(Calendar.getInstance().getTime().getHours());
//                String min = Integer.toString(Calendar.getInstance().getTime().getMinutes());
//                String sec = Integer.toString(Calendar.getInstance().getTime().getSeconds());
//
//                tvTimer.setText(hr + ":" + min + ":" + sec);
//
//                handler.postDelayed(this,1000);
//            }
//        };
//        handler.post(run);

        //Method: 2
        CountDownTimer countDownTimer = new CountDownTimer(100000,1000){
            @Override
            public void onTick(long millisecondsUntilDone) {
                tvTimer.setText(Long.toString(millisecondsUntilDone / 1000));
            }
            @Override
            public void onFinish() {

            }
        };
        countDownTimer.start();





    }
}