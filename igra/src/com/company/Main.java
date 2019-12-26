package com.company;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        Sec sec = new Sec();
        Random random = new Random();
        Scanner in = new Scanner(System.in);

        int a = random.nextInt(10);
        a = (a + 1)*1000;
        Thread.sleep(a);

        System.out.println("START");
        sec.start();
        while (!in.hasNextLine()){
        }
        sec.stop();
        long seconds = sec.millis / 1000;
        long millis = sec.millis % 1000;
        System.out.println(seconds + "," + millis);
    }
}