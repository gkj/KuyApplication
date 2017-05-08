package com.kuy.application.features.register;

import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.kuy.application.api.KuyService;
import com.kuy.application.features.BasePresenter;
import com.kuy.application.features.login.LoginActivity;
import com.kuy.application.features.main.MainActivity;
import com.kuy.application.models.LoginResponse;
import com.kuy.application.models.RegisterResponse;
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
 * Created by gilang on 5/9/17.
 */

public class RegisterPresenter extends BasePresenter<RegisterView> {
    @Override
    protected void onAttachView(@NonNull RegisterView view) {
        super.onAttachView(view);

        Preferences.getInstance().setContext(getActivity());
        if (Preferences.getInstance().isUserLogin()) {
            navigateTo(MainActivity.class);
            finishActivity();
            return;
        }

        registerObservable(getView().onLoginButtonClicked().subscribe(new Action1<Void>() {
            @Override
            public void call(Void aVoid) {
                navigateTo(LoginActivity.class);
                finishActivity();
            }
        }));

        registerObservable(getView().onRegisterButtonClicked().subscribe(new Action1<Void>() {
            @Override
            public void call(Void aVoid) {
                String name = getView().getUserName();
                String email = getView().getEmail();
                String password = getView().getPassword();

                if (!name.isEmpty() && !email.isEmpty() && !password.isEmpty()) {
                    registerUser(name, email, password);
                } else {
                    Toast.makeText(getActivity(),
                            "Please enter your details!", Toast.LENGTH_LONG)
                            .show();
                }
            }
        }));
    }

    private void registerUser(String name, String email, String password) {
        showProgressDialog("Registering...");

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(KuyService.BASE_URL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();

        KuyService service = retrofit.create(KuyService.class);
        Call<String> call = service.register(getRequestBody(getView().getUserName()), getRequestBody(getView().getEmail()), getRequestBody(getView().getPassword()));

        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                String result = response.body();
                Gson gson = new Gson();
                RegisterResponse registerResponse = gson.fromJson(result, RegisterResponse.class);

                hideProgressDialog();

                if (registerResponse.isError())
                {
                    showMessage(registerResponse.getErrorMessage());
                }
                else
                {
                    getView().clearInput();
                    showToast("User successfully registered. Try login now!");
                    navigateTo(MainActivity.class);
                    finishActivity();
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                hideProgressDialog();
                t.printStackTrace();
            }
        });
    }

    private RequestBody getRequestBody(String value) {
        return RequestBody.create(MediaType.parse("text/plain"), value);
    }

}
