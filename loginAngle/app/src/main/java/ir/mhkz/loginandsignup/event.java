package ir.mhkz.loginandsignup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class event extends AppCompatActivity {
    CardView param_info,savneet;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        savneet = findViewById(R.id.savneet_info);
        savneet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(event.this , ir.mhkz.loginandsignup.savneet_activity.class);
                startActivity(i);
            }
        });

        param_info=findViewById(R.id.param_info);
        param_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(event.this , ir.mhkz.loginandsignup.param_info.class);
                startActivity(i);
            }
        });
    }
}
