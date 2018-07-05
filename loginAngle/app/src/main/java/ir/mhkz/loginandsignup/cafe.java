package ir.mhkz.loginandsignup;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;

public class cafe extends AppCompatActivity {
    CardView khatri_info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cafe);


        khatri_info = findViewById(R.id.khatri_info);
        khatri_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(cafe.this, ir.mhkz.loginandsignup.khatri_info.class);
                startActivity(i);
            }
        });
    }

}