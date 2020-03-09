package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import java.util.concurrent.TimeUnit;

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
    int speed = 100;
    Bundle savedInstanceState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.savedInstanceState = savedInstanceState;
        Intent intent = getIntent();
        setContentView(R.layout.activity_shop);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        balance = intent.getIntExtra("balance", 0);
        koef = intent.getIntExtra("koef", 1);
        chance = intent.getIntExtra("chance", 3);
        chance2 = intent.getIntExtra("chance2", 2);
        price = intent.getIntExtra("price", 10);
        price2 = intent.getIntExtra("price2", 20);

        TextView Price25 = findViewById(R.id.Price25Shop);
        TextView Price50 = findViewById(R.id.Price50Shop);
        TextView koefread = findViewById(R.id.KoefOutShop);
        TextView ShopA = findViewById(R.id.ShopA);

        ShopA.setText("Your $: " + balance);
        Price25.setText("price 1: " + price);
        Price50.setText("price 2: " + price2);
        koefread.setText("$ per click: " + koef);
    }

    public void onClickButton25(View view) throws InterruptedException {
        TextView koefout = findViewById(R.id.Price25Shop);
        TextView koefread = findViewById(R.id.KoefOutShop);
        TextView ShopA = findViewById(R.id.ShopA);
        TextView resultOut = findViewById(R.id.result);
        ProgressBar Bar = findViewById(R.id.Bar);
        Chance cha = new Chance();

//        for (int i = 0; i < 5; i++) {
//            ran = cha.get(4);
//            switch (ran){
//                case 0:
//                    resultOut.setText("lose");
//                    break;
//                case 1:
//                    resultOut.setText("win");
//                    break;
//                case 20:
//                    resultOut.setText("BONUS");
//                    break;
//            }
//            TimeUnit.MILLISECONDS.sleep(1000);
//        }


        if (balance >= price) {
            Bar.setVisibility(view.VISIBLE);
            int i = 0;
            while (i <= 50) {
                Bar.setProgress(Bar.getProgress()+2);
                timer.start();
                i++;
            }

            balance -= price;
            koef += ran;
            price += 10;

            koefout.setText("price 1: " + price);
            koefread.setText("$ per click: " + koef);
            ShopA.setText("Your $: " + balance);
        }
        else{

        }
    }

        public void onClickButton50 (View view){
            TextView koefout = findViewById(R.id.Price50Shop);
            TextView koefread = findViewById(R.id.KoefOutShop);
            TextView ShopA = findViewById(R.id.ShopA);
            Chance cha = new Chance();

            if (balance >= price2) {
                int b = cha.get(2);
                balance -= price2;
                koef += b;
                price2 += 20;

                koefout.setText("price 2: " + price2);
                koefread.setText("$ per click: " + koef);
                ShopA.setText("Your $: " + balance);
            }
            else{
//                d.onCreateDialog(savedInstanceState);
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

    private CountDownTimer timer = new CountDownTimer(Long.MAX_VALUE,  10) {

        public void onTick(long millisUntilFinished) {
            time+=10;
            if(time>=speed){
                speed += speed*0.05;
                timer.cancel();
            }

        }

        public void onFinish() {
        }

    };

    }