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

public class MainActivity extends AppCompatActivity {

    TextView mTvHex,mTvRGB;
    LinearLayout mLinearBackGround;
    SeekBar mSkAlpha,mSkRed,mSkGreen,mSkBlue;
    int mValueRed,mValueGreen,mValueBlue;
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

        mSkRed.setMax(255);
        mSkGreen.setMax(255);
        mSkBlue.setMax(255);

        mSkRed.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                mValueRed = progress;
                setColor(mValueRed,mValueGreen,mValueBlue);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        mSkBlue.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                mValueBlue = progress;
                setColor(mValueRed,mValueGreen,mValueBlue);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        mSkGreen.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                mValueGreen = progress;
                setColor(mValueRed,mValueGreen,mValueBlue);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
    public void setColor(Integer red,Integer green , Integer blue){
        mLinearBackGround.setBackgroundColor(Color.rgb(red, green, blue));
    }

}