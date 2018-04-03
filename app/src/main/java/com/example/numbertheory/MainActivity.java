package com.example.numbertheory;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /** Called when the user taps the GCD/LCM button */
    public void sendGCD(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, GCDActivity.class);
        startActivity(intent);
    }

    /** Called when the user taps the Primes button */
    public void sendPrimes(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, PrimesActivity.class);
        startActivity(intent);
    }
}
