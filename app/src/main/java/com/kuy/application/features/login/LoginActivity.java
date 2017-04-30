package com.kuy.application.features.login;

import android.support.annotation.NonNull;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.jakewharton.rxbinding.view.RxView;
import com.kuy.application.R;
import com.kuy.application.features.BaseActivity;

import rx.Observable;

public class LoginActivity extends BaseActivity<LoginPresenter, LoginView>
        implements LoginView {

    private EditText emailEditText, passwordEditText;
    private Button loginButton, registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initUI();
    }

    private void initUI() {
        emailEditText = (EditText) findViewById(R.id.edittext_email);
        passwordEditText = (EditText) findViewById(R.id.edittext_password);
        loginButton = (Button) findViewById(R.id.button_login);
        registerButton = (Button) findViewById(R.id.button_register);
    }

    @NonNull
    @Override
    public LoginPresenter providePresenter() {
        return new LoginPresenter();
    }

    @Override
    public Observable<Void> onLoginButtonClicked()
    {
        return RxView.clicks(loginButton);
    }

    @Override
    public String getEmail() {
        return emailEditText.getText().toString();
    }

    @Override
    public String getPassword() {
        return passwordEditText.getText().toString();
    }
}
