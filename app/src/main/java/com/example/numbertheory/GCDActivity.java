package com.example.numbertheory;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class GCDActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.numbertheory.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gcd);
    }

    /** Called when the user taps the Send button */
    public void sendGreatest(View view) {
        Intent intent = new Intent(this, GreatestActivity.class);
        EditText editText = (EditText) findViewById(R.id.editText);
        EditText editText2 = (EditText) findViewById(R.id.editText2);
        String message = editText.getText().toString();
        String m2 = editText2.getText().toString();
        if (message.isEmpty() || m2.isEmpty())
        {
            Toast.makeText(this, "At least one integer is missing", Toast.LENGTH_SHORT).show();
        }
        else
        {
            message += "," + m2;
            intent.putExtra(EXTRA_MESSAGE, message);
            startActivity(intent);
        }


    }

    /** Called when the user taps the Send button */
    public void sendLeast(View view) {
        Intent intent = new Intent(this, LeastActivity.class);
        EditText editText = (EditText) findViewById(R.id.editText);
        EditText editText2 = (EditText) findViewById(R.id.editText2);
        String message = editText.getText().toString();
        String m2 = editText2.getText().toString();
        if (message.isEmpty() || m2.isEmpty())
        {
            Toast.makeText(this, "At least one integer is missing", Toast.LENGTH_SHORT).show();
        }
        else
        {
            message += "," + m2;
            intent.putExtra(EXTRA_MESSAGE, message);
            startActivity(intent);
        }
    }
}
