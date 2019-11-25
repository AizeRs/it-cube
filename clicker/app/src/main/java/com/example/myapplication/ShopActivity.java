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
    }

    public void onClickButton25(View view){
        TextView koefout = findViewById(R.id.koefout);
        TextView koefread = findViewById(R.id.textView2);
        TextView text = findViewById(R.id.textt);
        if(a >= price){
            int b = Chance.get(chance);
            a -= price;
            koef += b;
            price += 10;
            koefout.setText("price 1: " + price);
            koefread.setText("$ per click: " + koef);
            text.setText("Your $: " + a);
        }
    }
    public void onClickButton50(View view) {
        TextView koefout = findViewById(R.id.koefout2);
        TextView koefread = findViewById(R.id.textView2);
        TextView text = findViewById(R.id.textt);
        if (a >= price2) {
            int b = Chance.get(chance2);
            a -= price2;
            koef += b;
            price2 += 20;
            koefout.setText("price 2: " + price2);
            koefread.setText("$ per click: " + koef);
            text.setText("Your $: " + a);
        }
    }
    public void onClickButtonBack(View view) {
        Intent Gintent = new Intent(this, MainActivity.class);
        Gintent.putExtra("a", a);
        Gintent.putExtra("koef", koef);
        Gintent.putExtra("chance", chance);
        Gintent.putExtra("chance2", chance2);
        startActivity(Gintent);
    }
}