package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ReadActivity extends AppCompatActivity {

    public String Text = "text";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read);

        Intent getIntent = getIntent();
        String Text = getIntent.getStringExtra("Text");

        TextView TextOut = (TextView)findViewById(R.id.textView2);
        TextOut.setText(Text);
    }
//    public void onClickShow(View view){
//        Intent getIntent = getIntent();
//        String Text = getIntent.getStringExtra("Text");
//
//        TextView TextOut = (TextView)findViewById(R.id.textView2);
//        TextOut.setText(Text);
//    }
}
