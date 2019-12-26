package com.company;

import java.util.Calendar;

public class Sec {
    long millisStart;
    long millisStop;
    long millis;
    public void start() throws InterruptedException {
        millisStart = Calendar.getInstance().getTimeInMillis() % 100000;
    }
    public void stop() throws InterruptedException {
        long millisStop = Calendar.getInstance().getTimeInMillis() % 100000;
        millis = millisStop - millisStart - 18;
    }
}
