package com.rsk.mad_v2_lecture10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SignUp extends AppCompatActivity {

    EditText etUserName, etSignupEmail, etSignupPassword, etSignupCPassword;
    Button btnCancel, btnSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        init();

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName,email,password,cPassword;
                userName=etUserName.getText().toString().trim();
                email=etSignupEmail.getText().toString().trim();
                password=etSignupPassword.getText().toString();
                cPassword=etSignupCPassword.getText().toString();

                if (password.equals(cPassword))
                {
                    Intent intent=new Intent();
                    intent.putExtra("userName", userName);
                    intent.putExtra("email", email);
                    intent.putExtra("password", password);

                    setResult(RESULT_OK,intent);
                    finish();

                }
                else{

                    etSignupCPassword.setError("Password Does not match");
                }
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });

    }

    private void init() {
        etUserName=findViewById(R.id.etUserName);
        etSignupEmail=findViewById(R.id.etSignupEmail);
        etSignupPassword=findViewById(R.id.etSignupPassword);
        etSignupCPassword=findViewById(R.id.etSignupCPassword);
        btnCancel=findViewById(R.id.btnCancleSignup);
        btnSignup=findViewById(R.id.btnConfirmSignup);

    }
}