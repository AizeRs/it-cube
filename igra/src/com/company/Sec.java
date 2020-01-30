package com.company;

import java.util.Calendar;

public class Sec {
    long millisStart;
    long millisStop;
    long millis;
    long delay;
    public void start() throws InterruptedException {
        millisStart = Calendar.getInstance().getTimeInMillis() % 100000;
    }
    public void stop() throws InterruptedException {
        millisStop = Calendar.getInstance().getTimeInMillis() % 100000;
        millis = millisStop - millisStart - delay;
    }
}
