package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
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

        onCreateDialog().show();

        sPref = getSharedPreferences("save", MODE_PRIVATE);



    }
    public void onClickAdmin(View view){
        sPref = getSharedPreferences("save", MODE_PRIVATE);
        SharedPreferences.Editor ed = sPref.edit();

        ed.putInt("balance", +1000000);
        ed.commit();
    }
    public void onClickSettingsBack(View view) {
        Intent Gintent = new Intent(this, MainActivity.class);
        startActivity(Gintent);
    }
    public Dialog onCreateDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Do you really want to delete all your progress?");
            builder.setPositiveButton("ОK!", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    SharedPreferences.Editor ed = sPref.edit();

                    ed.putInt("balance", 0);
                    ed.putInt("koef", 1);
                    ed.putInt("chance", 3);
                    ed.putInt("chance2", 2);
                    ed.putInt("price", 10);
                    ed.putInt("price2", 20);
                    ed.commit();
                    dialog.cancel();
                }
            });
            builder.setNegativeButton("I changed my mind", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });

        return builder.create();
    }
}

