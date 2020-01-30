package com.company;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        Sec sec = new Sec();
        cal cal = new cal();
        Scanner in = new Scanner(System.in);

        cal.start();
        sec.delay = cal.delay;

        while (true) {
            System.out.println();
            System.out.println("Which mode do you want? Bаsic or Pro?");
            String a = in.nextLine();
            if (a.equals("Basic") || a.equals("basic") || a.equals("BASIC")) {
                System.out.println("Are you ready?(press enter)");
                in.nextLine();
                Basic.start();
            } else {
                if (a.equals("PRO") || a.equals("Pro") || a.equals("pro")) {
                    System.out.println("Coming soon!");
                } else {
                    System.out.println("Wrong mode entered!");
                    //System.out.println(a);
                }
            }
        }
    }
}