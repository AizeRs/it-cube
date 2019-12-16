package com.example.reaction;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.CountDownTimer;
import android.os.SystemClock;
import android.view.View;

import java.util.Random;

public class MyDraw extends View {

    Random random = new Random();
    public int a = 0;
    Paint paint = new Paint();
    public int millis = 0;

    public MyDraw(Context context) {
        super(context);
        paint.setColor(Color.GREEN);
        paint.setStyle(Paint.Style.FILL);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPaint(paint);
    }
}
