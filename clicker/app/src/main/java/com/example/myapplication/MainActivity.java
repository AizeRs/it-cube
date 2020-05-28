package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
  public int balance = 0;
  public int koef = 1;
  public int chance = 3;
  public int chance2 = 2;
  public int price = 10;
  public int price2 = 20;
  SharedPreferences sPref;
  int ban = 0;
  Chance cha;
  SoundPool sp;
  int sound;
  int soLOL;
  Button clButton;
  int flag = 0;
    TextView Tlol;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        sPref = getSharedPreferences("save", MODE_PRIVATE);

        balance = sPref.getInt("balance", 0);
        koef = sPref.getInt("koef", 1);
        chance = sPref.getInt("chance", 3);
        chance2 = sPref.getInt("chance2", 2);
        price = sPref.getInt("price", 10);
        price2 = sPref.getInt("price2", 20);
        clButton = (Button) findViewById(R.id.butt);

        TextView balanceOut = findViewById(R.id.Balance);
        TextView ko = findViewById(R.id.textView2);
        Context c = getApplicationContext();
        sp = new SoundPool(3, AudioManager.STREAM_MUSIC, 0);
        sound = sp.load(c, R.raw.click, 1);
        soLOL = sp.load(c, R.raw.lol, 1);

        balanceOut.setText("You have: " + balance + "$");
        ko.setText("$ per click: " + koef);
        cha = new Chance();
        timer.start();

    }

    public void onStop() {
        super.onStop();

        sPref = getSharedPreferences("save", MODE_PRIVATE);
        SharedPreferences.Editor ed = sPref.edit();

        ed.putInt("balance", balance);
        ed.putInt("koef", koef);
        ed.putInt("chance", chance);
        ed.putInt("chance2", chance2);
        ed.putInt("price", price);
        ed.putInt("price2", price2);

        ed.commit();
    }

    public void onClick(View view) {
        if (flag == 1) {
            ban++;
            if (ban == 5) {
                koef = 1;
                balance = 1;
                price = 10;
                price2 = 20;
                chance = 3;
                chance2 = 2;
                onStop();

                setContentView(R.layout.activity_lol);
                Tlol = (TextView) findViewById(R.id.TextLol);
                Tlol.setText("You are suspected of cheating. All your progress was removed! If you will cheat again, you will get banned!");
            }
        }
        else {
            flag = 1;
            balance += koef;

            TextView aout = (TextView) findViewById(R.id.Balance);
            aout.setText("You have: " + balance + "$");
            sp.play(sound, 1, 1, 1, 0, 1);
        }
    }
    public void onClickOk(View view){
        setContentView(R.layout.activity_main);
    }

    public void onClickShop(View view){
        Intent intent = new Intent(this, ShopActivity.class);

        intent.putExtra("balance", balance);
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
    private CountDownTimer timer = new CountDownTimer(Long.MAX_VALUE, 200) {

        public void onTick(long millisUntilFinished) {
            flag = 0;
            ban = 0;
        }


        public void onFinish() {

        }
    };
}