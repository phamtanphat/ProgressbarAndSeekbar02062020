package com.example.progressbarandseekbar02062020;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements Debounce {

    TextView mTvHex,mTvRGB;
    LinearLayout mLinearBackGround;
    SeekBar mSkAlpha,mSkRed,mSkGreen,mSkBlue;
    int mValueRed,mValueGreen,mValueBlue;
    Debounce mDebounce;
    Handler mHandler;
    Boolean mIsRunning = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTvHex = findViewById(R.id.textviewHex);
        mTvRGB = findViewById(R.id.textviewRGB);
        mLinearBackGround = findViewById(R.id.linearBackGround);
        mSkAlpha = findViewById(R.id.seekbarAlpha);
        mSkRed = findViewById(R.id.seekbarRed);
        mSkGreen = findViewById(R.id.seekbarGreen);
        mSkBlue = findViewById(R.id.seekbarBlue);

        mValueBlue = mValueGreen = mValueRed = 0;
        mHandler = new Handler();
        mDebounce = this;
        mSkRed.setMax(255);
        mSkGreen.setMax(255);
        mSkBlue.setMax(255);

        mSkRed.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                mValueRed = progress;
                mDebounce.delayTime(true);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mDebounce.delayTime(false);
            }
        });
        mSkBlue.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                mValueBlue = progress;
                mDebounce.delayTime(true);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mDebounce.delayTime(false);
            }
        });
        mSkGreen.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                mValueGreen = progress;
                mDebounce.delayTime(true);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mDebounce.delayTime(true);
            }
        });

    }

    @Override
    public void delayTime(Boolean isDelay) {
//        if (mIsRunning){
//            mHandler.
//        }
//        mHandler.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                mIsRunning = true;
//            }
//        },2000);
    }
}