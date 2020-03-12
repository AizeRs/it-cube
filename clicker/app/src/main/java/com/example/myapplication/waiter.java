package com.example.myapplication;

import android.os.CountDownTimer;

public class waiter {
    int time = 0;
    int speed;
    public void waitt(int sp){
        speed = sp;
        timer.start();

    }
    private CountDownTimer timer = new CountDownTimer(Long.MAX_VALUE,  10) {

        public void onTick(long millisUntilFinished) {
            time+=10;
            if(time>=speed){
                speed += speed*0.05;
                timer.cancel();
            }

        }

        public void onFinish() {
        }

    };
}
