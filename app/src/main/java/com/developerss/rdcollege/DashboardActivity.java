package com.developerss.rdcollege;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class DashboardActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        GoogleSignInClient

        mAuth = FirebaseAuth.getInstance();

    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        updateUI(currentUser);
    }

    private void updateUI(FirebaseUser user) {
        if (user != null){

        } else {
            toast("Please login first!");
            signIn();
        }
    }

    private void signIn(){
        AlertDialog.Builder mBUilder = new AlertDialog.Builder(DashboardActivity.this);
        View mView = getLayoutInflater().inflate(R.layout.activity_login, null);
        Button registerBtn = mView.findViewById(R.id.register_btn);
        SignInButton googleSignInBtn = mView.findViewById(R.id.sign_in_button);

        googleSignInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signInIntent =
            }
        });

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashboardActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

        mBUilder.setView(mView);
        AlertDialog dialog = mBUilder.create();
        dialog.setTitle("Sign in");
        dialog.setCancelable(false);
        dialog.show();
    }

    public void toast(String str){
        Toast.makeText(DashboardActivity.this, str, Toast.LENGTH_SHORT).show();
    }
}



// diskutil eject /dev/disk2