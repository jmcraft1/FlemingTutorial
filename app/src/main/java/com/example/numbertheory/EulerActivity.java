package com.example.numbertheory;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class EulerActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE6 = "com.example.numbertheory.MESSAGE";
    private int number = 1;
    private int howMany = 0;
    boolean isP2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_euler);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String message = intent.getStringExtra(PrimeFactActivity.EXTRA_MESSAGE5);
        String euler = eulerPhi(message);
        // Capture the layout's TextView and set the string as its text
        TextView textView3 = findViewById(R.id.textView5);

        textView3.setText(euler);
    }

    public void homeAgain(View view)
    {
        // Do something in response to button
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }



    public void tsm(View view)
    {
        // Do something in response to button
        Intent intent = new Intent(this, TSMActivity.class);
        String pf = "";
        pf += number + ",";
        if (isP2)
        {
            pf += "t";
        }
        else
        {
            pf += howMany;
        }
        intent.putExtra(EXTRA_MESSAGE6, pf);
        startActivity(intent);
    }

    public void newNum(View view)
    {
        // Do something in response to button
        Intent intent = new Intent(this, PrimesActivity.class);
        startActivity(intent);
    }

    public String eulerPhi(String primeFact)
    {
        isP2 = false;
        double product = 1;
        double product2 = 1;
        int a = 0;
        String gwar = "";
        while (primeFact.length() > 0)
        {
            gwar = "";
            for (int i = 0; i < primeFact.length(); i++)
            {
                if (primeFact.charAt(i) != '^')
                {
                    a = i;
                    gwar += primeFact.charAt(i);
                }
                else
                {
                    break;
                }
            }
            int base = Integer.parseInt(gwar);
            howMany += 1;
            primeFact = primeFact.substring(a + 2);


            gwar = "";
            int b = 0;
            for (int i = 0; i < primeFact.length(); i++)
            {
                if (primeFact.charAt(i) != '*')
                {
                    b = i;
                    gwar += primeFact.charAt(i);
                }
                else
                {
                    break;
                }
            }
            int exp = Integer.parseInt(gwar);
            if  (exp > 1)
            {
                isP2 = true;
            }
            number *= Math.pow(base, exp);
            product2 = product2 * Math.pow(base, exp);
            product = product * (Math.pow(base, exp) - Math.pow(base, exp - 1));
            if (b + 1 == primeFact.length())
            {
                primeFact = "";
            }
            else
            {
                primeFact = primeFact.substring(b + 2);
            }
        }
        int answer = (int)product;
        gwar = "";
        gwar = "   There are ";
        gwar += answer;
        gwar += " numbers that are \n   relatively prime to and less than " + (int)product2 + ".   ";
        return gwar;
    }

}
