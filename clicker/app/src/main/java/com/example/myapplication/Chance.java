package com.example.myapplication;

import java.util.Random;

public class Chance {

    static int get (int numb) {
        Random r = new Random();
        int num = r.nextInt(numb) + 1;
        if(num == 1){
            return 1;
        }
        else{
            return 0;
        }
    }

}
