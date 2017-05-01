package com.kuy.application.features.login;

import android.support.annotation.NonNull;

import com.google.gson.Gson;
import com.kuy.application.api.KuyService;
import com.kuy.application.features.BasePresenter;
import com.kuy.application.features.main.MainActivity;
import com.kuy.application.models.LoginResponse;
import com.kuy.application.util.Constant;
import com.kuy.application.util.Preferences;


import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import rx.functions.Action1;

/**
 * Created by gilang on 4/26/17.
 */

public class LoginPresenter extends BasePresenter<LoginView> {

    @Override
    protected void onAttachView(@NonNull LoginView view) {
        super.onAttachView(view);

        registerObservable(getView().onLoginButtonClicked().subscribe(new Action1<Void>() {
            @Override
            public void call(Void aVoid) {
                login();
            }
        }));
    }

    private RequestBody getRequestBody(String value) {
        return RequestBody.create(MediaType.parse("text/plain"), value);
    }

    private void login() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(KuyService.BASE_URL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();

        KuyService service = retrofit.create(KuyService.class);
        Call<String> call = service.login(getRequestBody(getView().getEmail()), getRequestBody(getView().getPassword()));

        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                String result = response.body();
                Gson gson = new Gson();
                LoginResponse loginResponse = gson.fromJson(result, LoginResponse.class);
                if (loginResponse.getError())
                {
                    showMessage(loginResponse.getErrorMessage());
                }
                else
                {
                    Preferences.getInstance().setContext(getActivity());
                    Preferences.getInstance().saveLoginResponse(loginResponse);
                    Preferences.getInstance().userLoggedIn();
                    navigateTo(MainActivity.class);
                    finishActivity();
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}
