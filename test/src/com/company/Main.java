package com.company;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws java.lang.InterruptedException{
        int time = 0;
        int speed = 120;
        Random r = new Random();
        for (int i = 0; i < 50; i++) {
            System.out.println(r.nextInt(2));
            TimeUnit.MILLISECONDS.sleep(speed);
            speed*=1.05;
            time +=speed;
        }
        System.out.println(time);
    }
}