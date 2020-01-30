package com.company;

import java.util.Calendar;

public class cal {
    long millisStart;
    long millisStop;
    long delay = 0;
    long i = 0;
    public void start() throws InterruptedException {
        for (int j = 0; j < 10; j++) {
            millisStart = Calendar.getInstance().getTimeInMillis() % 100000;
            millisStop = Calendar.getInstance().getTimeInMillis() % 100000;
            i += millisStop - millisStart;
        }
        delay = i / 10;
    }
}
