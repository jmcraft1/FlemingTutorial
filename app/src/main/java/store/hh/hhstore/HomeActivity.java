package store.hh.hhstore;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class HomeActivity extends AppCompatActivity {

    private String message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Intent intent = getIntent();
        message = intent.getStringExtra(AccountActivity.EXTRA_MESSAGE1);
    }

    public void addItem(View view){

    }

    public void delItem(View view){

    }

    public void changePrice(View view){

    }

    public void seeOrders(View view){

    }
}
