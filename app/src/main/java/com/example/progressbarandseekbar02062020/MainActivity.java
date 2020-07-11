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

public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {

    TextView mTvHex,mTvRGB;
    LinearLayout mLinearBackGround;
    SeekBar mSkAlpha,mSkRed,mSkGreen,mSkBlue;
    int mValueRed,mValueGreen,mValueBlue,mValueAlpha;
    String mStringColor = "";
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
        mValueAlpha = 255;

        mSkRed.setMax(255);
        mSkGreen.setMax(255);
        mSkBlue.setMax(255);
        mSkAlpha.setMax(255);

        mSkRed.setOnSeekBarChangeListener(this);
        mSkGreen.setOnSeekBarChangeListener(this);
        mSkBlue.setOnSeekBarChangeListener(this);
        mSkAlpha.setOnSeekBarChangeListener(this);
    }


    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        switch (seekBar.getId()){
            case R.id.seekbarRed :
                mValueRed = progress;
                break;
            case R.id.seekbarGreen :
                mValueGreen = progress;
                break;
            case R.id.seekbarBlue :
                mValueBlue = progress;
                break;
            case R.id.seekbarAlpha :
                mValueAlpha = progress;
                break;

        }
        setColor(mValueAlpha ,mValueRed, mValueGreen,mValueBlue);
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
    public void setColor(Integer alpha , Integer red,Integer green , Integer blue){
        mLinearBackGround.setBackgroundColor(Color.argb(alpha,red, green, blue));
        mTvRGB.setText(String.format("RGB 255 %d %d %d",red,green,blue));
        mStringColor = "" + To00Hex(alpha) + To00Hex(red) + To00Hex(green) + To00Hex(blue);
        mTvHex.setText("HEX # " + mStringColor.toUpperCase());
    }
    private static String To00Hex(int value) {
        String hex = "00".concat(Integer.toHexString(value));
        return hex.substring(hex.length()-2, hex.length());
    }
}