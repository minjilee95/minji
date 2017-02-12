package com.example.devmachine.logintest;

import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telecom.Call;
import android.widget.TextView;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import android.content.Intent;

import org.w3c.dom.Text;

public class MainActivity extends FragmentActivity {

    LoginButton loginButton;
    TextView textView;
    CallbackManager callbackManager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            FacebookSdk.sdkInitialize(this.getApplicationContext());
            setContentView(R.layout.activity_main);
            callbackManager = CallbackManager.Factory.create();
            LoginButton loginButton = (LoginButton) findViewById(R.id.fb_login_bn);
            textView = (TextView) findViewById(R.id.textView);
            callbackManager = CallbackManager.Factory.create();
            loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
                @Override
                public void onSuccess(LoginResult loginResult) {

                    textView.setText("Login Success \n" +
                        loginResult.getAccessToken().getUserId()+
                        "\n"+loginResult.getAccessToken().getToken());
                }

                @Override
                public void onCancel() {

                    textView.setText("Login Cancelled");
                }

                @Override
                public void onError(FacebookException error) {

                }
            });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){

        callbackManager.onActivityResult(requestCode, resultCode, data);


    }
}
