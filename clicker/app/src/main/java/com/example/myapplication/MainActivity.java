package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
  private String LOG = "buy";
  private int a = 0;
  private int koef = 1;
  private int price = 10;
  private int price2 = 20;
  private int chance = 3;
  private int chance2 = 2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onClickButtonClick(View view){

        TextView text = (TextView)findViewById(R.id.textt);
        a += koef;
        text.setText("Your $: " + a);
    }
    public void onClickButton25(View view){
        Log.i(LOG, "клик");
        TextView koefout = (TextView)findViewById(R.id.koefout);
        TextView koefread = (TextView)findViewById(R.id.textView2);
        TextView text = (TextView)findViewById(R.id.textt);
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
        Log.i(LOG, "клик");
        TextView koefout = (TextView) findViewById(R.id.koefout2);
        TextView koefread = (TextView) findViewById(R.id.textView2);
        TextView text = (TextView) findViewById(R.id.textt);
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
    public void onClickButtonADM(View view){
        chance = 1;
        chance2 = 1;
    }
}