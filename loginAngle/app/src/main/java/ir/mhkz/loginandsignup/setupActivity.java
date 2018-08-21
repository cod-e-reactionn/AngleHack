package ir.mhkz.loginandsignup;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

import java.util.HashMap;

import de.hdodenhof.circleimageview.CircleImageView;

public class setupActivity extends AppCompatActivity {

    EditText first_name,last_name,email_add,contact_number;
    LinearLayout submit_info;
    DatabaseReference userref;
    FirebaseAuth firebaseAuth;
    String currentUserId;
    private StorageReference UserProfileImage;

    private ProgressDialog loadingbar;
    private ProgressDialog progressDialog;
    CircleImageView profileImg;
    final static int Gallery_pick=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup);
        first_name = findViewById(R.id.first_name);
        last_name=findViewById(R.id.last_name);
        email_add= findViewById(R.id.email_add);
        contact_number=findViewById(R.id.email_add);
        submit_info = findViewById(R.id.submit_info);
        profileImg=findViewById(R.id.profile_img);
        progressDialog = new ProgressDialog(this);
        loadingbar = new ProgressDialog(this);
       firebaseAuth= FirebaseAuth.getInstance();
       currentUserId=firebaseAuth.getCurrentUser().getUid();
       userref= FirebaseDatabase.getInstance().getReference().child("Users").child(currentUserId);
       UserProfileImage= FirebaseStorage.getInstance().getReference().child("profile Images");

        submit_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SaveAccountInfo();



            }
        });
        profileImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent galleryIntent = new Intent();
                galleryIntent.setAction(Intent.ACTION_GET_CONTENT);
                galleryIntent.setType("image/*");
               startActivityForResult(galleryIntent,Gallery_pick);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==Gallery_pick && resultCode==RESULT_OK && data !=null)
        {
            Uri imageuri= data.getData();
            CropImage.activity()
                    .setGuidelines(CropImageView.Guidelines.ON)
                    .setAspectRatio(1,1)
                    .start(this);
        }

        if(requestCode==CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE)
        {
            CropImage.ActivityResult result = CropImage.getActivityResult(data);
            if (requestCode==RESULT_OK)
            {
                Uri resultUri = result.getUri();
                final StorageReference filePath = UserProfileImage.child(currentUserId+ ".jpg");

                filePath.putFile(resultUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        filePath.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                            @Override
                            public void onSuccess(Uri uri) {
                                final Uri downloadUrl=uri;

                            }
                        });
                    }
                });
                        }
                    }


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
