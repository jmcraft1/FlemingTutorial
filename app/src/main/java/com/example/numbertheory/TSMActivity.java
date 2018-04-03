package com.example.numbertheory;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class TSMActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tsm);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String message = intent.getStringExtra(EulerActivity.EXTRA_MESSAGE6);
        int comma = 0;
        int length = 0;
        for (int i = message.length() - 1; i >= 0; i--)
        {
            if (message.charAt(i) == ',')
            {
                comma = i;
                break;
            }
        }
        String isP2 = message.substring(comma + 1);
        message = message.substring(0, comma);
        int number = Integer.parseInt(message);
        int sigma = 0;
        int tau = 0;
        ArrayList<Integer> fact = new ArrayList<>();
        for (int i = 1; i <= number; i++)
        {
            if (number % i == 0)
            {
                fact.add(i);
                tau += 1;
                sigma += i;
            }
        }
        int mobius;
        if (number == 1)
        {
            mobius = 1;
        }
        else if (isP2.equals("t"))
        {
            mobius = 0;
        }
        else
        {
            length = Integer.parseInt(isP2);
            mobius = (int)Math.pow(-1, length);
        }

        String reply = "   τ(" + number + ") = " + tau + "\n";
        reply += "   σ(" + number + ") = " + sigma + "\n";
        reply += "   μ(" + number + ") = " + mobius;
        // Capture the layout's TextView and set the string as its text
        TextView textView = findViewById(R.id.textView6);
        textView.setText(reply);

    }

    /** Called when the user taps the Send button */
    public void enterNewNums(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, PrimesActivity.class);
        startActivity(intent);
    }

    /** Called when the user taps the Send button */
    public void goHome(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
