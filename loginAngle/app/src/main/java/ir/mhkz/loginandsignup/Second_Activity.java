package ir.mhkz.loginandsignup;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class Second_Activity extends AppCompatActivity {

ImageView adddd,pro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_);
     adddd=findViewById(R.id.addd);
     pro=findViewById(R.id.pram);
        adddd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(Second_Activity.this,advertisment.class);
                startActivity(intent);
            }


        });

        }



    }

