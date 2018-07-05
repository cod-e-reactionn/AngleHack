package ir.mhkz.loginandsignup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class delhi_people extends AppCompatActivity {
    CardView savneet_info,girish_info,gunjan_infoo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delhi_people);

        savneet_info=findViewById(R.id.savneet_info);
        savneet_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(delhi_people.this,savneet_activity.class);
                startActivity(i);

            }
        });
        girish_info = findViewById(R.id.girishInfo);
        girish_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(delhi_people.this,girish_Info.class);
                startActivity(i);
            }
        });
        gunjan_infoo = findViewById(R.id.gunjan_info);
        gunjan_infoo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(delhi_people.this, gunjan_info.class);
                startActivity(i);
            }
        });

    }
}
