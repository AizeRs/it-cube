package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

//    Intent intent = new Intent(this, MainActivity.class);
//    Intent GetIntent = getIntent();
//    Integer a = intent.getIntExtra("a", 0);
//    Integer koef = intent.getIntExtra("koef", 1);
//    Integer chance = intent.getIntExtra("chance", 3);
//    Integer chance2 = intent.getIntExtra("chance2", 2);

  private String LOG = "buy";
  public int a = 0;
  public int koef = 1;
  public int chance = 3;
  public int chance2 = 2;
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
    public void onClickButtonShop(View view){
        Intent intent = new Intent(this, ShopActivity.class);
        intent.putExtra("a", a);
        intent.putExtra("koef", koef);
        intent.putExtra("chance", chance);
        intent.putExtra("chance2", chance2);
        startActivity(intent);
    }

    public void onClickButtonADM(View view){
        chance = 1;
        chance2 = 1;
    }
}