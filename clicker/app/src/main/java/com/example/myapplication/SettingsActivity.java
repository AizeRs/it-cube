package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
public class SettingsActivity extends AppCompatActivity {
    public SharedPreferences sPref;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
    }
    public void onClickRestart(View view){
        sPref = getSharedPreferences("save", MODE_PRIVATE);
        SharedPreferences.Editor ed = sPref.edit();

        ed.putInt("a", 0);
        ed.putInt("koef", 1);
        ed.putInt("chance", 3);
        ed.putInt("chance2", 2);
        ed.putInt("price", 10);
        ed.putInt("price2", 20);

        ed.commit();
    }
    public void onClickSettingsBack(View view) {
        Intent Gintent = new Intent(this, MainActivity.class);
        startActivity(Gintent);
    }
}
