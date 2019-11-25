package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
  public int a = 0;
  public int koef = 1;
  public int chance = 3;
  public int chance2 = 2;
  public int price = 10;
  public int price2 = 20;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        a = intent.getIntExtra("a", 0);
        koef = intent.getIntExtra("koef", 1);
        chance = intent.getIntExtra("chance", 3);
        chance2 = intent.getIntExtra("chance2", 2);
        price = intent.getIntExtra("price", 10);
        price2 = intent.getIntExtra("price2", 20);

        TextView aout = findViewById(R.id.textt);
        TextView ko = findViewById(R.id.textView2);

        aout.setText("Your $: " + a);
        ko.setText("$ per click: " + koef);

    }
    public void onClickButtonClick(View view){

        a += koef;

        TextView aout = (TextView)findViewById(R.id.textt);
        aout.setText("Your $: " + a);
    }
    public void onClickButtonShop(View view){
        Intent intent = new Intent(this, ShopActivity.class);

        intent.putExtra("a", a);
        intent.putExtra("koef", koef);
        intent.putExtra("chance", chance);
        intent.putExtra("chance2", chance2);
        intent.putExtra("price", price);
        intent.putExtra("price2", price2);

        startActivity(intent);
    }

}