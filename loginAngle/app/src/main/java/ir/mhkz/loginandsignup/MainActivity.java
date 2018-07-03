package ir.mhkz.loginandsignup;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class MainActivity extends AppCompatActivity {
    public static final String USERNAME = "Name";
    public static final String FIRST_NAME = "First_Name";
    public static final String LAST_NAME = "Last_name";
    public static final String EMAIL_ADD = "Email_add";
    private FirebaseAuth firebaseAuth;
    //to save user data
    private DocumentReference saveuserdata = FirebaseFirestore.getInstance().document("User/UserInfo");


    EditText username, password, reg_username, reg_password,
            reg_firstName, reg_lastName, reg_email, reg_confirmemail;
    Button login, signUp, reg_register;
    TextInputLayout txtInLayoutUsername, txtInLayoutPassword, txtInLayoutRegPassword;
    CheckBox rememberMe;
    private ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.username);
        password=findViewById(R.id.password);
        login = findViewById(R.id.login);
        signUp = findViewById(R.id.signUp);
        txtInLayoutUsername = findViewById(R.id.txtInLayoutUsername);
        txtInLayoutPassword = findViewById(R.id.txtInLayoutPassword);
        rememberMe = findViewById(R.id.rememberMe);
        firebaseAuth =FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(this);

        ClickLogin();


        //SignUp's Button for showing registration page
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClickSignUp();
            }
        });


    }

    //This is method for doing operation of check login
    private void ClickLogin() {




        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String email = username.getText().toString().trim();
                final String pwd = password.getText().toString().trim();

                if (username.getText().toString().trim().isEmpty()) {

                    Snackbar snackbar = Snackbar.make(view, "Please fill out these fields",
                            Snackbar.LENGTH_LONG);
                    View snackbarView = snackbar.getView();
                    snackbarView.setBackgroundColor(getResources().getColor(R.color.red));
                    snackbar.show();
                    txtInLayoutUsername.setError("Username should not be empty");
                } else {
                    //Here you can write the codes for checking username
                }
                if (password.getText().toString().trim().isEmpty()) {
                    Snackbar snackbar = Snackbar.make(view, "Please fill out these fields",
                            Snackbar.LENGTH_LONG);
                    View snackbarView = snackbar.getView();
                    snackbarView.setBackgroundColor(getResources().getColor(R.color.red));
                    snackbar.show();
                    txtInLayoutPassword.setError("Password should not be empty");
                } else {
                    //Here you can write the codes for checking password
                }

                if (rememberMe.isChecked()) {
                    //Here you can write the codes if box is checked
                } else {
                    //Here you can write the codes if box is not checked
                }
                progressDialog.setMessage("Registering Please Wait...");
                progressDialog.show();
                firebaseAuth.signInWithEmailAndPassword(email,pwd)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (!task.isSuccessful()) {


                                    Toast.makeText(MainActivity.this, "Login successfull", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(MainActivity.this,Second_Activity.class);
                                    startActivity(intent);
                                }
                                progressDialog.dismiss();


                            }
                        });


                }

        });

    }

    //The method for opening the registration page and another processes or checks for registering
    private void ClickSignUp() {


        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.register, null);
        dialog.setView(dialogView);
        firebaseAuth = FirebaseAuth.getInstance();
        reg_username = dialogView.findViewById(R.id.reg_username);
        reg_password = dialogView.findViewById(R.id.reg_password);
        reg_firstName = dialogView.findViewById(R.id.reg_firstName);
        reg_lastName = dialogView.findViewById(R.id.reg_lastName);
        reg_email = dialogView.findViewById(R.id.reg_email);
        reg_confirmemail = dialogView.findViewById(R.id.reg_confirmemail);
        reg_register = dialogView.findViewById(R.id.reg_register);
        txtInLayoutRegPassword = dialogView.findViewById(R.id.txtInLayoutRegPassword);


        reg_register.setOnClickListener(new View.OnClickListener() {







            @Override
            public void onClick(View view) {
                String email = reg_email.getText().toString().trim();
                String password  = reg_password.getText().toString().trim();
                String name = reg_firstName.getText().toString().trim();
                String username =reg_username.getText().toString().trim();
                String lastname = reg_lastName.getText().toString().trim();



                if (reg_username.getText().toString().trim().isEmpty()) {

                    reg_username.setError("Please fill out this field");
                } else {
                    //Here you can write the codes for checking username
                }
                if (reg_password.getText().toString().trim().isEmpty()) {
                    txtInLayoutRegPassword.setPasswordVisibilityToggleEnabled(false);
                    reg_password.setError("Please fill out this field");
                } else {
                    txtInLayoutRegPassword.setPasswordVisibilityToggleEnabled(true);
                    //Here you can write the codes for checking password
                }
                if (reg_firstName.getText().toString().trim().isEmpty()) {

                    reg_firstName.setError("Please fill out this field");
                } else {
                    //Here you can write the codes for checking firstname

                }
                if (reg_lastName.getText().toString().trim().isEmpty()) {

                    reg_lastName.setError("Please fill out this field");
                } else {
                    //Here you can write the codes for checking lastname
                }
                if (reg_email.getText().toString().trim().isEmpty()) {

                    reg_email.setError("Please fill out this field");
                } else {
                    //Here you can write the codes for checking email
                }
                if (reg_confirmemail.getText().toString().trim().isEmpty()) {

                    reg_confirmemail.setError("Please fill out this field");
                } else {
                    //Here you can write the codes for checking confirmemail
                }
                firebaseAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful()){
                                    //display some message here
                                    Toast.makeText(MainActivity.this,"Successfully registered",Toast.LENGTH_LONG).show();
                                }else{
                                    //display some message here
                                    Toast.makeText(MainActivity.this,"Registration Error",Toast.LENGTH_LONG).show();
                                }
                            }
                        });
            }
        });




        dialog.show();


    }




    }


