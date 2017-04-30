package com.kuy.application.util;

import android.content.Context;
import android.content.SharedPreferences;

import com.kuy.application.models.LoginResponse;
import com.kuy.application.models.User;

/**
 * Created by gilang on 4/29/17.
 */

public class Preferences {

    private static final String IS_USER_LOGIN = "is_user_login";
    private static final String LOGIN_RESPONSE_UID = "user_name";
    private static final String USER_NAME = "user_name";
    private static final String USER_EMAIL = "user_email";
    private static final String USER_CREATED_AT = "user_created_at";
    private static final String USER_UPDATED_AT = "user_updated_at";

    private Context context;
    private SharedPreferences pref;
    private SharedPreferences.Editor editor;

    private Preferences()
    {

    }

    private static class Singleton
    {
        public static final Preferences instance = new Preferences();
    }

    public static Preferences getInstance()
    {
        return Singleton.instance;
    }

    public void setContext(Context context)
    {
        this.context = context;
        this.pref = context.getSharedPreferences(context.getPackageName() + "_preferences", Context.MODE_PRIVATE);
        this.editor = pref.edit();
    }

    public boolean isUserLogin()
    {
        return null == pref ? false : pref.getBoolean(IS_USER_LOGIN, false);
    }

    public void userLoggedIn()
    {
        editor.putBoolean(IS_USER_LOGIN, true);
        editor.commit();
    }

    public void userLoggedOut()
    {
        editor.putBoolean(IS_USER_LOGIN, false);
        editor.commit();
    }

    public void saveLoginResponse(LoginResponse loginResponse) {
        editor.putString(LOGIN_RESPONSE_UID, loginResponse.getUid());
        User user = loginResponse.getUser();
        editor.putString(USER_NAME, user.getName());
        editor.putString(USER_EMAIL, user.getEmail());
        editor.putString(USER_CREATED_AT, user.getCreatedAt());
        editor.putString(USER_UPDATED_AT, user.getUpdatedAt());
        editor.commit();
    }

    public LoginResponse getLoginResponse() {
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setUid(pref.getString(LOGIN_RESPONSE_UID, ""));

        User user = new User();
        user.setName(pref.getString(USER_NAME, ""));
        user.setEmail(pref.getString(USER_EMAIL, ""));
        user.setCreatedAt(pref.getString(USER_CREATED_AT, ""));
        user.setUpdatedAt(pref.getString(USER_UPDATED_AT, ""));

        loginResponse.setUser(user);

        return loginResponse;
    }
}
