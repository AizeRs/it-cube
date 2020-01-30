package com.example.reaction;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;

import java.util.Date;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    public int a = 0;
    public int millis = 0;
    Random random = new Random();
    Date date = new Date();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
        public void onClickStart(View view){
            a = random.nextInt(6500)+1000;
            setContentView(new MyDraw(this));
            long st = date.getTime() % 1000000;
            long now = 0;
            while(st - now <= 1000){
               now = date.getTime();
            }

            setContentView(new MyDrawT(this));
            millis = 0;
            timer.start();
        }

    private CountDownTimer timer = new CountDownTimer(Long.MAX_VALUE, 1) {
        public void onTick(long millisUntilFinished) {
            millis++;
        }

        public void onFinish() {
        }
    };
}