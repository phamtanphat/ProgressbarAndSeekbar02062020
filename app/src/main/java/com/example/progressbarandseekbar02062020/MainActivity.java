package com.example.progressbarandseekbar02062020;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView mTvCurrent,mTvTotal;
    ProgressBar mProgress;
    int count = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTvCurrent = findViewById(R.id.textviewCurrentLoading);
        mTvTotal = findViewById(R.id.textviewTotal);
        mProgress = findViewById(R.id.progressbar);

        // CountDownTimer

        CountDownTimer countDownTimer = new CountDownTimer(5000,2000) {
            @Override
            public void onTick(long millisUntilFinished) {
                Log.d("BBB",millisUntilFinished + "");
            }

            @Override
            public void onFinish() {
//                Log.d("BBB",count + "");
            }
        };
        countDownTimer.start();
    }
}