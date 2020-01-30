package com.example.myapplication;

import java.util.Random;

public class Chance {

    public int get(int ch) {
        Random r = new Random();
        int num = r.nextInt(99) + 1;
        if(num / ch == 0) {
            return 1;
        }
        if(num == 77){
            return 20;
        }
        else{
            return 0;
        }
    }
}
