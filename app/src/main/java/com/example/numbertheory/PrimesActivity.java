package com.example.numbertheory;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class PrimesActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE4 = "com.example.relativeprimes.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_primes);
    }

    /** Called when the user taps the Submit button */
    public void sendMessage(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, PrimeFactActivity.class);
        EditText editText2 = (EditText) findViewById(R.id.editText3);
        String message = editText2.getText().toString();

        if (message.isEmpty())
        {
            Toast.makeText(this, "You did not enter an integer", Toast.LENGTH_SHORT).show();
        }
        else
        {
            while (message.charAt(0) == '0' && message.length() > 1)
            {
                message = message.substring(1);
            }
            if (message.equals("1"))
            {
                Toast.makeText(this, "1 does not have a prime factorization", Toast.LENGTH_SHORT).show();
            }
            else if (message.equals("0"))
            {
                Toast.makeText(this, "0 does not have a prime factorization", Toast.LENGTH_SHORT).show();
            }
            else
            {
                intent.putExtra(EXTRA_MESSAGE4, message);
                startActivity(intent);
            }
        }



    }
}
