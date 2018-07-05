package ir.mhkz.loginandsignup;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;

public class banglore extends AppCompatActivity {
    CardView joshi_info;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banglore);

        joshi_info = findViewById(R.id.joshi_info);
        joshi_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(banglore.this, ir.mhkz.loginandsignup.joshi_info.class);
                startActivity(i);
            }
        });



    }
}
