package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ShopActivity extends AppCompatActivity {



    public int price = 10;
    public int price2 = 20;
    public int a = 0;
    public int koef = 0;
    public int chance = 0;
    public int chance2 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        setContentView(R.layout.activity_shop);
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

        if(a >= price){
            int b = Chance.get(chance);
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

        if (a >= price2) {
            int b = Chance.get(chance2);
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

        Gintent.putExtra("a", a);
        Gintent.putExtra("koef", koef);
        Gintent.putExtra("chance", chance);
        Gintent.putExtra("chance2", chance2);
        Gintent.putExtra("price", price);
        Gintent.putExtra("price2", price2);

        startActivity(Gintent);
    }
}