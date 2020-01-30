package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Date;
import java.util.Random;

public class ShopActivity extends AppCompatActivity {

    public int price = 10;
    public int price2 = 20;
    public int a = 0;
    public int koef = 0;
    public int chance = 0;
    public int chance2 = 0;
    SharedPreferences sPref;
    Random random = new Random();
    Date date = new Date();
    int ran = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        setContentView(R.layout.activity_shop);

        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        a = intent.getIntExtra("a", 0);
        koef = intent.getIntExtra("koef", 1);
        chance = intent.getIntExtra("chance", 3);
        chance2 = intent.getIntExtra("chance2", 2);
        price = intent.getIntExtra("price", 10);
        price2 = intent.getIntExtra("price2", 20);

        TextView Price25 = findViewById(R.id.Price25Shop);
        TextView Price50 = findViewById(R.id.Price50Shop);
        TextView koefread = findViewById(R.id.KoefOutShop);
        TextView ShopA = findViewById(R.id.ShopA);

        ShopA.setText("Your $: " + a);
        Price25.setText("price 1: " + price);
        Price50.setText("price 2: " + price2);
        koefread.setText("$ per click: " + koef);
    }

    public void onClickButton25(View view){
        TextView koefout = findViewById(R.id.Price25Shop);
        TextView koefread = findViewById(R.id.KoefOutShop);
        TextView ShopA = findViewById(R.id.ShopA);
        TextView resultOut = findViewById(R.id.result);
        Chance cha = new Chance();

        if(a >= price){
            int res = 0;
            int speed = 300;
            int b = 0;

            while(speed <= 2300){
                ran = cha.get(4);
                switch (ran){
                    case 1:
                        resultOut.setText("lose");
                        break;
                    case 0:
                        resultOut.setText("win");
                        break;
                    case 100:
                        resultOut.setText("BONUS");
                        break;
                }
                long st = date.getTime() % 1000000;
                long now = 0;
                while(st - now <= speed){
                    now = date.getTime();
                }
                speed -= 40;
            }
            b = ran;
            a -= price;
            koef += b;
            price += 10;

            koefout.setText("price 1: " + price);
            koefread.setText("$ per click: " + koef);
            ShopA.setText("Your $: " + a);
        }
    }
    public void onClickButton50(View view) {
        TextView koefout = findViewById(R.id.Price50Shop);
        TextView koefread = findViewById(R.id.KoefOutShop);
        TextView ShopA = findViewById(R.id.ShopA);
        Chance cha = new Chance();

        if (a >= price2) {
            int b = cha.get(2);
            a -= price2;
            koef += b;
            price2 += 20;

            koefout.setText("price 2: " + price2);
            koefread.setText("$ per click: " + koef);
            ShopA.setText("Your $: " + a);
        }
    }

    public void onClickButtonBack(View view) {
        Intent Gintent = new Intent(this, MainActivity.class);
        startActivity(Gintent);

        sPref = getSharedPreferences("save", MODE_PRIVATE);
        SharedPreferences.Editor ed = sPref.edit();

        ed.putInt("a", a);
        ed.putInt("koef", koef);
        ed.putInt("chance", chance);
        ed.putInt("chance2", chance2);
        ed.putInt("price", price);
        ed.putInt("price2", price2);

        ed.commit();
    }

}