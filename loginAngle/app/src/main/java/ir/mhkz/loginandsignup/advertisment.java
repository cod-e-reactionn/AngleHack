package ir.mhkz.loginandsignup;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class advertisment extends AppCompatActivity {

    private DrawerLayout mdrawer;
    private ActionBarDrawerToggle mtoggle;
    NavigationView navigation;
    RecyclerView postLine;

    ImageView searchButton,addpost;
    CardView delhi,mumbai,hyd_people,banglore_page,fashion_click,nagpur,agra_info,event_click,cafe_click,ngo_click;

TextView tv;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advertisment);


        navigation=findViewById(R.id.navigation_view);
        mdrawer = findViewById(R.id.drawer_layout);
        mtoggle = new ActionBarDrawerToggle(this, mdrawer, R.string.open, R.string.close);
        mdrawer.addDrawerListener(mtoggle);
        mtoggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        navigation.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                UserMenuIterm(item);
                return false;
            }
        });











        delhi = findViewById(R.id.delhi);
        delhi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(advertisment.this, delhi_people.class);
                startActivity(i);
            }
        });
        mumbai = findViewById(R.id.mumbai_card);
        mumbai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(advertisment.this, ir.mhkz.loginandsignup.mumbai.class);
                startActivity(i);
            }
        });
        hyd_people = findViewById(R.id.hyd_info);
        hyd_people.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(advertisment.this, ir.mhkz.loginandsignup.hydrabad.class);
                startActivity(i);
            }
        });
        banglore_page = findViewById(R.id.banglore_page);
        banglore_page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(advertisment.this, banglore.class);
                startActivity(i);
            }
        });
        nagpur = findViewById(R.id.nagpur);
        nagpur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(advertisment.this, ir.mhkz.loginandsignup.nagpur.class);
                startActivity(i);
            }
        });
        agra_info = findViewById(R.id.agra_info);
        agra_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(advertisment.this, agra.class);
                startActivity(i);
            }
        });
        fashion_click = findViewById(R.id.fashion_click);
        fashion_click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(advertisment.this, fashion_cat.class);
                startActivity(i);
            }
        });
        event_click = findViewById(R.id.event_click);
        event_click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(advertisment.this, event.class);
                startActivity(i);
            }
        });
        cafe_click = findViewById(R.id.cafe);
        cafe_click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(advertisment.this, cafe.class);
                startActivity(i);
            }
        });
        addpost = findViewById(R.id.addpost);
        addpost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(advertisment.this, Promoters_list.class);
                startActivity(i);
            }
        });
        searchButton = findViewById(R.id.search);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(advertisment.this, Promoters_list.class);
                startActivity(i);
            }
        });


        tv = findViewById(R.id.textView3);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(advertisment.this, Promoters_list.class);
                startActivity(intent);

            }
        });
        ngo_click = findViewById(R.id.ngo);
        ngo_click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(advertisment.this, ngp.class);
                startActivity(i);
            }
        });




    }

    private void UserMenuIterm(MenuItem item) {
        switch (item.getItemId()){
            case R.id.ad_create:
               Intent i = new Intent(advertisment.this, create_ad.class);
               startActivity(i);
                break;

            case R.id.home_click:
                Intent intent= new Intent(this, advertisment.class);
                startActivity(intent);
                break;
            case R.id.req:
                Intent i2 =new Intent(advertisment.this,req.class);
                startActivity(i2);
                break;
            case R.id.ad_status:
                Intent i3 = new Intent(advertisment.this, adstatus.class);
                startActivity(i3);
                break;
            case R.id.payment_his:
                Intent i4= new Intent(advertisment.this, payment_history.class);
                startActivity(i4);
                break;
            case R.id.acc_switch:
                Intent i5= new Intent(advertisment.this ,Second_Activity.class );
                startActivity(i5);
                break;
            case R.id.seating:
               Toast.makeText(this, "Seating Loading",Toast.LENGTH_SHORT).show();
               break;
            case R.id.logout:
                Intent i6=new Intent(advertisment.this, MainActivity.class);
                startActivity(i6);
                break;
        }
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(mtoggle.onOptionsItemSelected(item)){
            return true ;

        }
        return super.onOptionsItemSelected(item);
    }




    boolean doubleBackToExitPressedOnce = false;
    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce = false;
            }
        }, 2000);
    }









 }

















