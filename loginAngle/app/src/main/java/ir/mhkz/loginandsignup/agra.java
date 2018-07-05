package ir.mhkz.loginandsignup;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;

public class agra extends AppCompatActivity {

    CardView athrv,khatri_info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agra);
        athrv = findViewById(R.id.athrav_info);
        athrv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(agra.this , athrav_info.class);
                startActivity(i);
            }
        });
        khatri_info = findViewById(R.id.khatri_info);
        khatri_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(agra.this, ir.mhkz.loginandsignup.khatri_info.class);
                startActivity(i);
            }
        });
    }
}
