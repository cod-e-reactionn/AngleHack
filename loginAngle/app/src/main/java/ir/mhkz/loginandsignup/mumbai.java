package ir.mhkz.loginandsignup;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;

public class mumbai extends AppCompatActivity {
CardView param_info,sid_info;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mumbai);
        param_info= findViewById(R.id.param_info);
        param_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(mumbai.this, ir.mhkz.loginandsignup.param_info.class);
                startActivity(i);
            }
        });
        sid_info = findViewById(R.id.sid_card);
        sid_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(mumbai.this, ir.mhkz.loginandsignup.sid_info.class);
                startActivity(i);
            }
        });
    }
}
