package com.saveme.testetesteteste;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUp extends AppCompatActivity {

    //Variáveis
    TextInputLayout regName, regUsername, regEmail, regPhoneNo, regPassword;
    Button regBtn, regToLoginBtn;

    FirebaseDatabase rootNode;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_sign_up);

        //Hooks to all xml elements in activity_sign_up.xml
                    regName = findViewById(R.id.reg_name);
                    regUsername = findViewById(R.id.reg_username);
                    regEmail = findViewById(R.id.reg_email);
                    regPhoneNo = findViewById(R.id.reg_phoneNo);
                    regPassword = findViewById(R.id.reg_password);
                    regBtn = findViewById(R.id.reg_btn);
                    regToLoginBtn = findViewById(R.id.reg_login_btn);

                    //Save data in Firebase on button click
        regBtn.setOnClickListener(new View.OnClickListener(){
            @Override
                    public void onClick(View view) {
                rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference("saveme-30b01-default-rtdb");

                //Get all the values
                String name = regName.getEditText().getText().toString();
                String username = regUsername.getEditText().getText().toString();
                String email = regEmail.getEditText().getText().toString();
                String phoneNo = regPhoneNo.getEditText().getText().toString();
                String password = regPassword.getEditText().getText().toString();

                UserHelperClass helperClass = new UserHelperClass(name, username, email, phoneNo, password);

                reference.child(phoneNo).setValue(helperClass);
            }
        });
    }
}