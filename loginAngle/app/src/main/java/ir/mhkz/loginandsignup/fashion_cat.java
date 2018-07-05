package ir.mhkz.loginandsignup;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;

public class fashion_cat extends AppCompatActivity {
    CardView joshi_info, gunjan_info,savneet_info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fashion_cat);
        gunjan_info = findViewById(R.id.gunjan_info);
        gunjan_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(fashion_cat.this , ir.mhkz.loginandsignup.gunjan_info.class);
                startActivity(i);
            }
        });
        joshi_info= findViewById(R.id.joshi_info);
        joshi_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(fashion_cat.this, ir.mhkz.loginandsignup.joshi_info.class);
                startActivity(i);
            }
        });
        savneet_info = findViewById(R.id.savneet_info);
        savneet_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent  i = new Intent(fashion_cat.this , savneet_activity.class);
                startActivity(i);
            }
        });
    }
}
