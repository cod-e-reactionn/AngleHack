package ir.mhkz.loginandsignup;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Toolbar;

public class Promoters_list extends AppCompatActivity {

    private DrawerLayout mDrawer;
    private ActionBarDrawerToggle mToggle;
    private Toolbar mToolbar;
    CardView girishInfo,sid_card,athrav_info,gunjan_info,khatri_info,param_info,gawali_info,joshi_info,sanket_info,savneet_info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_promoters_list);
        girishInfo=findViewById(R.id.girishInfo);
        girishInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Promoters_list.this, girish_Info.class);
                startActivity(i);
            }
        });
        sid_card =findViewById(R.id.sid_card);
        sid_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Promoters_list.this ,sid_info.class);
                startActivity(i);
            }
        });
        athrav_info=findViewById(R.id.athrav_info);
        athrav_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Promoters_list.this, ir.mhkz.loginandsignup.athrav_info.class);
                startActivity(i);
            }
        });
        gunjan_info = findViewById(R.id.gunjan_info);
        gunjan_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Promoters_list.this , ir.mhkz.loginandsignup.gunjan_info.class);
                startActivity(i);
            }
        });
        khatri_info = findViewById(R.id.khatri_info);
        khatri_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Promoters_list.this , ir.mhkz.loginandsignup.khatri_info.class);
                startActivity(i);
            }
        });
        param_info= findViewById(R.id.param_info);
        param_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Promoters_list.this, ir.mhkz.loginandsignup.param_info.class);
                startActivity(i);

                }

        });
        gawali_info= findViewById(R.id.gawali_info);
        gawali_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Promoters_list.this, ir.mhkz.loginandsignup.gawali_info.class);
                startActivity(i);
            }
        });

        joshi_info=findViewById(R.id.joshi_info);
        joshi_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Promoters_list.this, ir.mhkz.loginandsignup.joshi_info.class);
                startActivity(i);
            }
        });

        sanket_info = findViewById(R.id.sanket_info);
        sanket_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Promoters_list.this, ir.mhkz.loginandsignup.sanket_info.class);
                startActivity(i);
            }
        });
        savneet_info = findViewById(R.id.savneet_info);
        savneet_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Promoters_list.this, savneet_activity.class);
                startActivity(i);
            }
        });





        }


}
