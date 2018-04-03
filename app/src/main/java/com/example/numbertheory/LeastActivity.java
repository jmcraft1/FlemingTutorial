package com.example.numbertheory;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class LeastActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE3 = "com.example.numbertheory.MESSAGE";
    int a, b, gcd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_least);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String message = intent.getStringExtra(GreatestActivity.EXTRA_MESSAGE2);

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

        String y = "   The least common multiple of   \n";
        y += "   " + first + " and " + second + "   \n";
        y += "   is ";
        y += getLCM(a, b);
        if (y.charAt(y.length() - 2) == '.')
        {
            y = y.substring(0, y.length() - 2);
        }
        // Capture the layout's TextView and set the string as its text
        TextView textView = findViewById(R.id.textView);
        textView.setText(y);
    }

    public double getLCM(int a, int b)
    {
        double s = 0;
        double t = 1;
        double r = b;
        double oldS = 1;
        double oldT = 0;
        double oldR = a;
        while(r != 0)
        {
            int quotient = (int)(oldR/r);
            double temp = r;
            r = oldR - quotient * r;
            oldR = temp;
            temp = s;
            s = oldS - quotient * s;
            oldS = temp;
            temp = t;
            t = oldT - quotient * t;
            oldT = temp;
        }
        double g = (a/oldR) * b;
        return g;
    }

    /** Called when the user taps the GCD button */
    public void sendGCD(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, GreatestActivity.class);
        String z = "";
        z += a + "," + b;
        intent.putExtra(EXTRA_MESSAGE3, z);
        startActivity(intent);
    }

    /** Called when the user taps the newNums button */
    public void sendNewNums(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, GCDActivity.class);
        startActivity(intent);
    }

    /** Called when the user taps the Home button */
    public void sendHome(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
