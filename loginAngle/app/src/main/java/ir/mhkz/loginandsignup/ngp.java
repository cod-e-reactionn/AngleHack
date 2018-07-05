package ir.mhkz.loginandsignup;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;

public class ngp extends AppCompatActivity {
    CardView param,gawali;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ngp);
        param = findViewById(R.id.param_info);
        param.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ngp.this, param_info.class);
                startActivity(i);
            }
        });
        gawali=findViewById(R.id.gawali_info);
        gawali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ngp.this,gawali_info.class);
                startActivity(i);
            }
        });
    }

}
