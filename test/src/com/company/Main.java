package com.company;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws java.lang.InterruptedException{
        Random random = new Random();
        int f = 100;
        int d = 0;
        for (int i = 0; i <= 50 ; i++) {
            System.out.println(random.nextInt(2));
            TimeUnit.MILLISECONDS.sleep(f);
            d+=f;
            f+=f*0.055;
        }
        System.out.println(d);
    }
}