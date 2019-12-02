package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
  public int a = 0;
  public int koef = 1;
  public int chance = 3;
  public int chance2 = 2;
  public int price = 10;
  public int price2 = 20;
  SharedPreferences sPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        sPref = getSharedPreferences("save", MODE_PRIVATE);

        a = sPref.getInt("a", 0);
        koef = sPref.getInt("koef", 1);
        chance = sPref.getInt("chance", 3);
        chance2 = sPref.getInt("chance2", 2);
        price = sPref.getInt("price", 10);
        price2 = sPref.getInt("price2", 20);

        TextView aout = findViewById(R.id.textt);
        TextView ko = findViewById(R.id.textView2);

        aout.setText("Your $: " + a);
        ko.setText("$ per click: " + koef);
    }

    public void onStop() {
        super.onStop();

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

    public void onClick(View view){

        a += koef;

        TextView aout = (TextView)findViewById(R.id.textt);
        aout.setText("Your $: " + a);
    }

    public void onClickShop(View view){
        Intent intent = new Intent(this, ShopActivity.class);

        intent.putExtra("a", a);
        intent.putExtra("koef", koef);
        intent.putExtra("chance", chance);
        intent.putExtra("chance2", chance2);
        intent.putExtra("price", price);
        intent.putExtra("price2", price2);

        startActivity(intent);
    }
    public void onClickSettings(View view){
        Intent intent = new Intent(this, SettingsActivity.class);

        startActivity(intent);
    }
}