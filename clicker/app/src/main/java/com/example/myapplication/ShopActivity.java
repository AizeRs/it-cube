package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

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
    ProgressBar Bar;
    TextView koefout;
    TextView koefread;
    TextView ShopA;
    TextView resultOut;
    Chance cha = new Chance();
    int chann;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.savedInstanceState = savedInstanceState;
        Intent intent = getIntent();
        setContentView(R.layout.activity_shop);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        koefout = findViewById(R.id.Price25Shop);
        koefread = findViewById(R.id.KoefOutShop);
        ShopA = findViewById(R.id.ShopA);
        resultOut = findViewById(R.id.result);

        balance = intent.getIntExtra("balance", 0);
        koef = intent.getIntExtra("koef", 1);
        chance = intent.getIntExtra("chance", 3);
        chance2 = intent.getIntExtra("chance2", 2);
        price = intent.getIntExtra("price", 10);
        price2 = intent.getIntExtra("price2", 20);
        Bar = findViewById(R.id.Bar);
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

        if (balance >= price) {
            chann = 4;
            Bar.setVisibility(view.VISIBLE);
            timer.start();

        }
        else{
//      тут будет диалоговое окно(не скоро)
        }
    }

        public void onClickButton50 (View view){
            TextView koefout = findViewById(R.id.Price50Shop);
            TextView koefread = findViewById(R.id.KoefOutShop);
            TextView ShopA = findViewById(R.id.ShopA);
            Chance cha = new Chance();

            if (balance >= price2) {
                chann = 2;
                timer.start();
            }
            else{
//          тут будет диалоговое окно(не скоро)
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

    private CountDownTimer timer = new CountDownTimer(Long.MAX_VALUE, speed) {

        public void onTick(long millisUntilFinished) {

//                *= 1.05;
                i++;
                ran = cha.get(chann);
                switch (ran){
                    case 0:
                        resultOut.setText("lose");
                        break;
                    case 1:
                        resultOut.setText("win");
                        break;
                    case 20:
                        resultOut.setText("BONUS");
                        break;
                }
                Bar.setProgress(Bar.getProgress()+2);
                if(i>=50){
                    balance -= price;
                    koef += ran;
                    price += 10;
                    koefout.setText("price 1: " + price);
                    koefread.setText("$ per click: " + koef);
                    ShopA.setText("Your $: " + balance);
                    timer.cancel();
                    i = 0;
                }
        }

        public void onFinish() {
            speed = 120;
        }
    };
}