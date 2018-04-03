package com.example.numbertheory;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class GreatestActivity extends AppCompatActivity {


    public static final String EXTRA_MESSAGE2 = "com.example.numbertheory.MESSAGE";
    int gcd, a, b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_greatest);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String message = intent.getStringExtra(GCDActivity.EXTRA_MESSAGE);
        int comma = message.indexOf(",");
        String first = message.substring(0, comma);
        String second = message.substring(comma + 1);

        a = Integer.parseInt(first);
        b = Integer.parseInt(second);
        if ( b > a)
        {
            int tp = a;
            a = b;
            b = tp;
        }
        gcd = getGCD(a, b);
        String great = "   The greatest common divisor of   \n";
        great += "   " + a + " and " + b;
        great += " is " + gcd + ".   ";

        // Capture the layout's TextView and set the string as its text
        TextView textView = findViewById(R.id.textView2);
        textView.setText(great);

    }

    public int getGCD(int a, int b)
    {
        int s = 0;
        int t = 1;
        int r = b;
        int oldS = 1;
        int oldT = 0;
        int oldR = a;
        while(r != 0)
        {
            int quotient = oldR/r;
            int temp = r;
            r = oldR - quotient * r;
            oldR = temp;
            temp = s;
            s = oldS - quotient * s;
            oldS = temp;
            temp = t;
            t = oldT - quotient * t;
            oldT = temp;
        }
        return oldR;
    }

    /** Called when the user taps the Send button */
    public void sendLCM(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, LeastActivity.class);
        String x = "";
        x += a + "," + b;
        intent.putExtra(EXTRA_MESSAGE2, x);
        startActivity(intent);
    }

    /** Called when the user taps the Send button */
    public void sendNewNums(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, GCDActivity.class);
        startActivity(intent);
    }

    /** Called when the user taps the Send button */
    public void sendHome(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    /** Called when the user taps the Send button */
    public void sendDiophantine(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, DiophantineActivity.class);
        String x = "";
        x += a + "," + b;
        intent.putExtra(EXTRA_MESSAGE2, x);
        startActivity(intent);
    }


}
