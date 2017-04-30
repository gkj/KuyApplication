package com.kuy.application.features.profile;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.kuy.application.R;
import com.kuy.application.features.BaseActivity;

public class ProfileActivity extends BaseActivity<ProfilePresenter, ProfileView>
        implements ProfileView {

    private TextView nameTextView;
    private TextView emailTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        initUI();
    }

    private void initUI() {
        nameTextView = (TextView) findViewById(R.id.textview_name);
        emailTextView = (TextView) findViewById(R.id.textview_email);
    }

    @NonNull
    @Override
    public ProfilePresenter providePresenter() {
        return new ProfilePresenter();
    }

    @Override
    public void changeName(String name) {
        nameTextView.setText(name);
    }

    @Override
    public void changeEmail(String email) {
        emailTextView.setText(email);
    }
}
