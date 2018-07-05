package ir.mhkz.loginandsignup;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

public class advertisment extends AppCompatActivity {
    private DrawerLayout mDrawer;
    private ActionBarDrawerToggle mToggle;
    private Toolbar mToolbar;
    ImageView searchButton;
    CardView delhi,mumbai,hyd_people,banglore_page,fashion_click,nagpur,agra_info,event_click,cafe_click,ngo_click;

TextView tv;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advertisment);
        mDrawer=(DrawerLayout)findViewById(R.id.drawer_layout);
        searchButton = findViewById(R.id.searchButton);

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
                Intent i = new Intent(advertisment.this ,banglore.class);
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
                Intent i = new Intent(advertisment.this , agra.class);
                startActivity(i);
            }
        });
        fashion_click=  findViewById(R.id.fashion_click);
        fashion_click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(advertisment.this , fashion_cat.class);
                startActivity(i);
            }
        });
        event_click=findViewById(R.id.event_click);
        event_click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(advertisment.this , event.class);
                startActivity(i);
            }
        });
        cafe_click = findViewById(R.id.cafe);
        cafe_click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(advertisment.this , cafe.class);
                startActivity(i);
            }
        });







        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(advertisment.this,Promoters_list.class);
                startActivity(i);
            }
        });
        mToggle=new ActionBarDrawerToggle(this, mDrawer,R.string.open,R.string.close);
        mDrawer.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tv =findViewById(R.id.textView3);
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
    private static long back_pressed;





    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if(mToggle.onOptionsItemSelected(item)){
            return true;
        }
        int id = item.getItemId();
        if(id==R.id.home_click){
            Intent intent = new Intent(this,advertisment.class);
            startActivity(intent);
            return true;
        }
        if(id==R.id.ad_status){
            Intent intent = new Intent(this,adstatus.class);
            startActivity(intent);
            return true;
        }

        if (id==R.id.logout){
            Intent intent = new Intent(this,Second_Activity.class);
            startActivity(intent);
            return true;
        }
        if(id==R.id.req){
            Intent intent = new Intent(this,req.class);
            startActivity(intent);
            return true;
        }
        if(id==R.id.ad_create){
            Intent intent = new Intent( this,create_ad.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
















