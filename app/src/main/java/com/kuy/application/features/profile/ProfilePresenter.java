package com.kuy.application.features.profile;

import android.support.annotation.NonNull;

import com.kuy.application.features.BasePresenter;
import com.kuy.application.models.LoginResponse;
import com.kuy.application.models.User;
import com.kuy.application.util.Preferences;

/**
 * Created by gilang on 4/29/17.
 */

public class ProfilePresenter extends BasePresenter<ProfileView> {
    @Override
    protected void onAttachView(@NonNull ProfileView view) {
        super.onAttachView(view);

        Preferences.getInstance().setContext(getActivity());
        LoginResponse loginResponse = Preferences.getInstance().getLoginResponse();
        User user = loginResponse.getUser();

        getView().changeName(user.getName());
        getView().changeEmail(user.getEmail());
    }
}
