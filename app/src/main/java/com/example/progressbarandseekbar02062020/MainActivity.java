package com.example.progressbarandseekbar02062020;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView mTvCurrent,mTvTotal;
    ProgressBar mProgress;
    Random mRandom;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTvCurrent = findViewById(R.id.textviewCurrentLoading);
        mTvTotal = findViewById(R.id.textviewTotal);
        mProgress = findViewById(R.id.progressbar);

        mRandom = new Random();
        // CountDownTimer
        final CountDownTimer countDownTimer = new CountDownTimer(100000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                if (mProgress.getProgress() >= 100){
                    onFinish();
                }else{
                    mProgress.setProgress(mProgress.getProgress() + mRandom.nextInt(11));
                    mTvCurrent.setText(mProgress.getProgress() + "%");
                    mTvTotal.setText(String.format("%d/%d",mProgress.getProgress(),100));
                }
            }

            @Override
            public void onFinish() {
                Toast.makeText(MainActivity.this, "Ket thuc", Toast.LENGTH_SHORT).show();
                this.cancel();
            }
        };
        countDownTimer.start();


    }
}