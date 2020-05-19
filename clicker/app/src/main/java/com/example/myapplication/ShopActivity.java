package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.media.SoundPool;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.os.UserHandle;
import android.view.Display;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class ShopActivity extends AppCompatActivity {

    public int price = 10;
    public int price2 = 20;
    public int balance = 0;
    public int koef = 0;
    public int chance = 0;
    public int chance2 = 0;
    SharedPreferences sPref;
    int ran = 0;
//    Dialog d = new Dialog();
    int time = 0;
    long speed = 120;
    int i = 0;
    Bundle savedInstanceState;
    TextView PriceOut;
    TextView PriceOut2;
    TextView koefread;
    TextView ShopA;
    TextView resultOut;
    Chance cha;
    int chann;
    TextView Price25;
    TextView Price50;
    SoundPool sp;
    int win;
    int lose;
    int jackpot;
    Toast toast;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.savedInstanceState = savedInstanceState;
        Intent intent = getIntent();
        setContentView(R.layout.activity_shop);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        PriceOut = findViewById(R.id.Price25Shop);
        PriceOut2 = findViewById(R.id.Price50Shop);
        koefread = findViewById(R.id.KoefOutShop);
        ShopA = findViewById(R.id.ShopA);
        resultOut = findViewById(R.id.result);

        balance = intent.getIntExtra("balance", 0);
        koef = intent.getIntExtra("koef", 1);
        chance = intent.getIntExtra("chance", 3);
        chance2 = intent.getIntExtra("chance2", 2);
        price = intent.getIntExtra("price", 10);
        price2 = intent.getIntExtra("price2", 20);
        koefread = findViewById(R.id.KoefOutShop);
        ShopA = findViewById(R.id.ShopA);
        Price25 = findViewById(R.id.Price25Shop);
        Price50 = findViewById(R.id.Price50Shop);
        Context c = getApplicationContext();

        ShopA.setText("Your $: " + balance);
        Price25.setText("price 1: " + price);
        Price50.setText("price 2: " + price2);
        koefread.setText("$ per click: " + koef);
        cha = new Chance();
        sp = new SoundPool(3, AudioManager.STREAM_MUSIC, 0);
        win = sp.load(c, R.raw.win, 1);
        lose = sp.load(c, R.raw.lose, 1);
        jackpot = sp.load(c, R.raw.jackpot, 1);
        toast = new Toast(c);
        toast = Toast.makeText(c, "Not enough money!", Toast.LENGTH_LONG);
    }

    public void onClickButton25(View view) {

        if (balance >= price) {
            chann = 4;
            ran = cha.get(chann);
            balance -= price;
            price += 10;
            koef += ran;
            switch (ran) {
                case 0:
                    resultOut.setText("lose");
                    sp.play(lose, 1,1,1,0,1);
                    break;
                case 1:
                    resultOut.setText("win");
                    sp.play(win, 1,1,1,0,1);
                    break;
                case 20:
                    resultOut.setText("JACKPOT");
                    sp.play(jackpot, 1,1,1,0,1);
                    break;
            }
            ShopA.setText("Your $: " + balance);
            Price25.setText("price 1: " + price);
            Price50.setText("price 2: " + price2);
            koefread.setText("$ per click: " + koef);

        }
        else{
            toast.show();
        }
    }

        public void onClickButton50 (View view){
            TextView koefout = findViewById(R.id.Price50Shop);
            TextView koefread = findViewById(R.id.KoefOutShop);
            TextView ShopA = findViewById(R.id.ShopA);
            if (balance >= price2) {
                chann = 2;
                ran = cha.get(chann);
                balance -= price2;
                price2 += 20;
                koef += ran;
                switch (ran){
                    case 0:
                        resultOut.setText("lose");
                        sp.play(lose, 1,1,1,0,1);
                        break;
                    case 1:
                        resultOut.setText("win");
                        sp.play(win, 1,1,1,0,1);
                        break;
                    case 20:
                        resultOut.setText("JACKPOT");
                        sp.play(jackpot, 1,1,1,0,1);
                        break;
                }
                ShopA.setText("Your $: " + balance);
                Price25.setText("price 1: " + price);
                Price50.setText("price 2: " + price2);
                koefread.setText("$ per click: " + koef);
            }
            else{
          toast.show();
            }
        }

        public void onClickButtonBack (View view){
            Intent Gintent = new Intent(this, MainActivity.class);
            startActivity(Gintent);
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

    @Override
    protected void onPause() {
        super.onPause();
        Intent Gintent = new Intent(this, MainActivity.class);
        startActivity(Gintent);
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

    private CountDownTimer timer = new CountDownTimer(Long.MAX_VALUE, speed) {

        public void onTick(long millisUntilFinished) {
        }


        public void onFinish() {

        }
    };
}