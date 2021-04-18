package com.example.loginapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

public class VerifyOTPActivity extends AppCompatActivity {

    EditText inputotp1,inputotp2,inputotp3,inputotp4,inputotp5,inputotp6;
    TextView mobilenumber;
    String getotpbackend;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify_o_t_p);

        Button verifybuttonclick=findViewById(R.id.buttonenteredotp);
        inputotp1=findViewById(R.id.inputotp1);
        inputotp2=findViewById(R.id.inputotp2);
        inputotp3=findViewById(R.id.inputotp3);
        inputotp4=findViewById(R.id.inputotp4);
        inputotp5=findViewById(R.id.inputotp5);
        inputotp6=findViewById(R.id.inputotp6);

        mobilenumber=findViewById(R.id.mobilenumber);
        mobilenumber.setText(String.format(
                "+91-%s",
                getIntent().getStringExtra("mobile"))
        );
        getotpbackend=getIntent().getStringExtra("backendotp");

        final ProgressBar progressBarverifyotp=findViewById(R.id.progressbar_verify_otp);
        verifybuttonclick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!inputotp1.getText().toString().trim().isEmpty() && !inputotp2.getText().toString().trim().isEmpty() && !inputotp3.getText().toString().trim().isEmpty() && !inputotp4.getText().toString().trim().isEmpty() && !inputotp5.getText().toString().trim().isEmpty() && !inputotp6.getText().toString().trim().isEmpty()){
                  String entercodeotp=inputotp1.getText().toString()+
                          inputotp2.getText().toString()+
                          inputotp3.getText().toString()+
                          inputotp4.getText().toString()+
                          inputotp5.getText().toString()+
                          inputotp6.getText().toString();

                  if(getotpbackend != null){
                        progressBarverifyotp.setVisibility(View.VISIBLE);
                        verifybuttonclick.setVisibility(View.INVISIBLE);

                      PhoneAuthCredential phoneAuthCredential= PhoneAuthProvider.getCredential(getotpbackend,entercodeotp);
                      FirebaseAuth.getInstance().signInWithCredential(phoneAuthCredential)
                              .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                  @Override
                                  public void onComplete(@NonNull Task<AuthResult> task) {
                                      progressBarverifyotp.setVisibility(View.VISIBLE);
                                      verifybuttonclick.setVisibility(View.INVISIBLE);

                                      if(task.isSuccessful())
                                      {
                                          Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                                          intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|intent.FLAG_ACTIVITY_CLEAR_TASK);
                                          startActivity(intent);
                                      }
                                  }
                              });
                  }else{
                      Toast.makeText(VerifyOTPActivity.this,"please check internet connection",Toast.LENGTH_SHORT).show();

                  }

                    //  Toast.makeText(VerifyOTPActivity.this,"otp verify",Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(VerifyOTPActivity.this,"please enter correct otp",Toast.LENGTH_SHORT).show();

                }

            }
        });

        numberotpmove();

    }

    private void numberotpmove() {
        inputotp1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                    if(!s.toString().trim().isEmpty()){
                        inputotp2.requestFocus();
                    }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        inputotp2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(!s.toString().trim().isEmpty()){
                    inputotp3.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        inputotp3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(!s.toString().trim().isEmpty()){
                    inputotp4.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        inputotp4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(!s.toString().trim().isEmpty()){
                    inputotp5.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        inputotp5.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(!s.toString().trim().isEmpty()){
                    inputotp6.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }


}