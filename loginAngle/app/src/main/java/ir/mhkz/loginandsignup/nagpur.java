package ir.mhkz.loginandsignup;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;

public class nagpur extends AppCompatActivity {
    CardView sanket_info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nagpur);
        sanket_info = findViewById(R.id.sanket_info);
        sanket_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(nagpur.this , ir.mhkz.loginandsignup.sanket_info.class);
                startActivity(i);
            }
        });
    }
}
