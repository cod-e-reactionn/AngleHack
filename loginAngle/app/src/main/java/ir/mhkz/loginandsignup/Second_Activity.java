package ir.mhkz.loginandsignup;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Second_Activity extends AppCompatActivity {

ImageView adddd,pro;
    private FirebaseAuth firebaseAuth;
    private DatabaseReference user_ref;

    String currentUserID;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_);

        firebaseAuth =FirebaseAuth.getInstance();
        currentUserID = firebaseAuth.getCurrentUser().getUid();
        user_ref = FirebaseDatabase.getInstance().getReference().child("Users");


     adddd=findViewById(R.id.addd);
        adddd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(Second_Activity.this, advertisment.class);
                startActivity(intent);
            }


        });
        pro =findViewById(R.id.pram);
        pro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Second_Activity.this, pramoter.class);
                startActivity(intent);
            }
        });

        }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser currentuser = firebaseAuth.getCurrentUser();
        if (currentuser ==null)
        {
            sendtoLogin();
        }
        else{
            checkuserexistence();
        }
    }

    private void sendtoLogin() {
        Intent loginIntent = new Intent(Second_Activity.this, MainActivity.class);
        loginIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(loginIntent);
        finish();
    }

    private void checkuserexistence() {
        final String current_user_id=firebaseAuth.getCurrentUser().getUid();
        user_ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(!dataSnapshot.hasChild(current_user_id))
                {
                    sedusertoSetup();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

    private void sedusertoSetup() {
        Intent setupIntent = new Intent(Second_Activity.this, setupActivity.class);
        setupIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(setupIntent);
        finish();
    }




}

