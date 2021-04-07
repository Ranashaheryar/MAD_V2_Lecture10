package com.rsk.mad_v2_lecture10;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class Login extends AppCompatActivity {

    EditText etEmail,etPassword;
    Button btnSignin, btnSignUp;
    final static int SIGNUP_ACTIVITY=1;
    ArrayList<User> users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
        btnSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String userEmail=etEmail.getText().toString().trim();
                String userPassword=etPassword.getText().toString();

                boolean flag=true;
                for (User u:users) {
                    if(userEmail.equals(u.getEmail()) && userPassword.equals(u.getPassword()))
                    {
                        flag=false;
                        Intent intent= new Intent(Login.this,Home.class);
                        intent.putExtra("userEmail",userEmail);
                        startActivity(intent);

                    }

                }
                if(flag)
                {
                    Toast.makeText(Login.this,"User Does not Exist ",Toast.LENGTH_SHORT).show();

                }




            }
        });
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Login.this,com.rsk.mad_v2_lecture10.SignUp.class);
                startActivityForResult(intent,SIGNUP_ACTIVITY);



            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode==SIGNUP_ACTIVITY)
        {
            if (resultCode==RESULT_OK)
            {
                User u=new User();
                u.setUserName(data.getStringExtra("userName"));
                u.setEmail(data.getStringExtra("email"));
                u.setPassword(data.getStringExtra("password"));
                users.add(u);
                Toast.makeText(this,"Register Successfully ",Toast.LENGTH_SHORT).show();


            }
            else if(resultCode==RESULT_CANCELED)
            {
                Toast.makeText(this,"You Did not Sign UP ",Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void init() {
        etEmail=findViewById(R.id.etEmail);
        etPassword=findViewById(R.id.etPassword);
        btnSignin=findViewById(R.id.btnSignin);
        btnSignUp=findViewById(R.id.btnSignUp);
        users=new ArrayList<>();

    }
}