package com.example.reaction;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.SystemClock;
import android.view.View;
import android.view.Window;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    public int a = 0;
    public int millis = 0;
    Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
        public void onClickStart(View view){
            setContentView(new MyDraw(this));
            a = random.nextInt(29);
            a++;
            a*=1000;
            timer.start();
            while (millis <= a){
            }
            timer.cancel();
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