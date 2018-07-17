package ir.mhkz.loginandsignup;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class setupActivity extends AppCompatActivity {

    EditText first_name,last_name,email_add,contact_number;
    LinearLayout submit_info;
    DatabaseReference userref;
    FirebaseAuth firebaseAuth;
    String currentUserId;
    private ProgressDialog loadingbar;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup);
        first_name = findViewById(R.id.first_name);
        last_name=findViewById(R.id.last_name);
        email_add= findViewById(R.id.email_add);
        contact_number=findViewById(R.id.email_add);
        submit_info = findViewById(R.id.submit_info);
        progressDialog = new ProgressDialog(this);
        loadingbar = new ProgressDialog(this);
       firebaseAuth= FirebaseAuth.getInstance();
       currentUserId=firebaseAuth.getCurrentUser().getUid();
       userref= FirebaseDatabase.getInstance().getReference().child("Users").child(currentUserId);

        submit_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SaveAccountInfo();



            }
        });

    }

    private void SaveAccountInfo() {
        String fname = first_name.getText().toString();
        String lname = last_name.getText().toString();
        String email = email_add.getText().toString();
        String contact = contact_number.getText().toString();
        if (TextUtils.isEmpty(fname)){
            Toast.makeText(this,"Please Enter First Name",Toast.LENGTH_SHORT).show();
        }
        if (TextUtils.isEmpty(lname)){
            Toast.makeText(this,"Please Enter Last Name",Toast.LENGTH_SHORT).show();
        }
        if (TextUtils.isEmpty(email)){
            Toast.makeText(this,"Please Enter Email",Toast.LENGTH_SHORT).show();
        }
        if (TextUtils.isEmpty(contact)){
            Toast.makeText(this,"Please Enter Contact Number",Toast.LENGTH_SHORT).show();
        }
        else
        {
            loadingbar.setTitle("Saving Information");
            loadingbar.setMessage("Please wait, while we saving your information");
            loadingbar.show();
            loadingbar.setCanceledOnTouchOutside(true);

            HashMap usermap = new HashMap();
            usermap.put("firstname",fname);
            usermap.put("lastname",lname);
            usermap.put("email",email);
            usermap.put("contactNumber",contact);
            usermap.put("advertiserLogin","Total Ad:");
            usermap.put("InfluncerLogin","Total Ad Requested:");
            usermap.put("AdReach","Total Viwves:");
            userref.updateChildren(usermap).addOnCompleteListener(new OnCompleteListener() {
                @Override
                public void onComplete(@NonNull Task task)
                {
                    if(task.isSuccessful())
                    {
                        senduserToMainActivity();
                        Toast.makeText(setupActivity.this,"Your Account is Created Successfully",Toast.LENGTH_LONG).show();
                        loadingbar.dismiss();
                    }
                    else
                    {

                        String messege = task.getException().getMessage();
                        Toast.makeText(setupActivity.this,"Error"+messege,Toast.LENGTH_SHORT).show();
                        loadingbar.dismiss();
                    }

                }
            });
        }
    }

    private void senduserToMainActivity()
    {
        Intent sendUserToMain = new Intent(setupActivity.this,Second_Activity.class);
        sendUserToMain.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(sendUserToMain);
        finish();
    }
}
