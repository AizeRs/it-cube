package com.example.exploration;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextClock;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exploration_layout);
        final RadioGroup rg = (RadioGroup) findViewById(R.id.radioGroup);
        final RadioButton RBLondon = (RadioButton) findViewById(R.id.radioLondon);
        final RadioButton RBMoscow = (RadioButton) findViewById(R.id.radioMoscow);
        final RadioButton RBNewYork = (RadioButton) findViewById(R.id.radioNewYork);
        final RadioButton RBParis = (RadioButton) findViewById(R.id.radioParis);
        final TextClock Clock = (TextClock) findViewById(R.id.clock);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.radioLondon:
                        Clock.setTimeZone("Europe/London");
                        break;
                    case R.id.radioMoscow:
                        Clock.setTimeZone("Europe/Moscow");
                        break;
                    case R.id.radioNewYork:
                        Clock.setTimeZone("America/New_York");
                        break;
                    case R.id.radioParis:
                        Clock.setTimeZone("Europe/Paris");
                        break;
                }
            }
        });
    }
}
