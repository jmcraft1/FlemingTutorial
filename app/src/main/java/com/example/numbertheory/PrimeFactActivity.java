package com.example.numbertheory;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class PrimeFactActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE5 = "com.example.numbertheory.MESSAGE";
    public String pf = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prime_fact);


        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String message = intent.getStringExtra(PrimesActivity.EXTRA_MESSAGE4);

        int number = Integer.parseInt(message);
        ArrayList<Integer> primes = genPrimes(number);

        String primeFact = getPrimeFact(primes, number);

        // Capture the layout's TextView and set the string as its text
        TextView textView = findViewById(R.id.textView4);
        textView.setText(primeFact);



    }

    public ArrayList<Integer> genPrimes(int number)
    {
        // Generate array of primes
        ArrayList<Integer> primes = new ArrayList<>();
        boolean isPrime;
        primes.add(2);
        primes.add(3);

        for (int i = 5; i <= number; i++)
        {
            isPrime = true;
            for (int j = 2; j * j <= i; j++)
            {
                if (i % j == 0)
                {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime)
            {
                primes.add(i);
            }
        }
        return primes;
    }

    public String getPrimeFact(ArrayList<Integer> primes, int number) {
        // Get the prime factorization

        int numbers = number;
        ArrayList<Integer> primeFact = new ArrayList<>();
        for (int i = 0; i < primes.size(); i++) {
            while (number % primes.get(i) == 0) {
                primeFact.add(primes.get(i));
                number = number/primes.get(i);
            }
        }
        String retMess = "The Prime Factorization of " + numbers + " is:\n";
        for (int i = 0; i < primeFact.size(); i++) {
            int counter = 1;
            pf += primeFact.get(i);
            while (i + 1 < primeFact.size() && primeFact.get(i + 1) == primeFact.get(i)) {
                counter++;
                i++;
            }
            pf += "^" + counter + "*";

        }
        pf = pf.substring(0, pf.length() - 1);
        retMess += pf;
        return retMess;
    }

    /** Called when the user taps the get euler button */
    public void getEuler(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, EulerActivity.class);
        intent.putExtra(EXTRA_MESSAGE5, pf);
        startActivity(intent);
    }

    /** Called when the user taps the Send button */
    public void backHome(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    /** Called when the user taps the Send button */
    public void newNum(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, PrimesActivity.class);
        startActivity(intent);
    }
}
