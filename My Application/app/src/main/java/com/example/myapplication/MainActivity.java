package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Show";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void OnClickShow(View view){
        EditText EnteredText = (EditText) findViewById(R.id.editText);
        String Text = EnteredText.getText().toString();
        Intent intent = new Intent(this, ReadActivity.class);
        intent.putExtra("Text", Text);
        startActivity(intent);
        Log.d(TAG, "Pressed SHOW");
    }
}