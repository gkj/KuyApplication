package com.kuy.application.features.register;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.jakewharton.rxbinding.view.RxView;
import com.kuy.application.R;
import com.kuy.application.features.BaseActivity;

import rx.Observable;

public class RegisterActivity extends BaseActivity<RegisterPresenter, RegisterView> implements RegisterView {

    private EditText nameEditText;
    private EditText emailEditText;
    private EditText passwordEditText;
    private Button loginButton;
    private Button registerButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initUI();
    }

    private void initUI() {
        nameEditText = (EditText) findViewById(R.id.edittext_name);
        emailEditText = (EditText) findViewById(R.id.edittext_email);
        passwordEditText = (EditText) findViewById(R.id.edittext_password);
        loginButton = (Button) findViewById(R.id.button_login);
        registerButton = (Button) findViewById(R.id.button_register);
    }

    @NonNull
    @Override
    public RegisterPresenter providePresenter() {
        return new RegisterPresenter();
    }

    @Override
    public String getUserName() {
        return nameEditText.getText().toString().trim();
    }

    @Override
    public String getEmail() {
        return emailEditText.getText().toString().trim();
    }

    @Override
    public String getPassword() {
        return passwordEditText.getText().toString().trim();
    }

    @Override
    public Observable<Void> onLoginButtonClicked() {
        return RxView.clicks(loginButton);
    }

    @Override
    public Observable<Void> onRegisterButtonClicked() {
        return RxView.clicks(registerButton);
    }

    @Override
    public void clearInput() {
        nameEditText.setText("");
        emailEditText.setText("");
        passwordEditText.setText("");
    }
}
