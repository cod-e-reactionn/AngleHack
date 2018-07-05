package ir.mhkz.loginandsignup;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;

public class hydrabad extends AppCompatActivity {
CardView gawali_info;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hydrabad);
        gawali_info= findViewById(R.id.gawali_info);
        gawali_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(hydrabad.this , ir.mhkz.loginandsignup.gawali_info.class);
                startActivity(intent);
            }
        });
    }
}
