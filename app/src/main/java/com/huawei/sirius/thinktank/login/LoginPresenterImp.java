package com.huawei.sirius.thinktank.login;

import android.text.TextUtils;

import com.huawei.sirius.thinktank.login.interfaces.LoginPresenter;
import com.huawei.sirius.thinktank.login.interfaces.LoginView;
import com.huawei.sirius.thinktank.model.UserAccount;

import java.util.Timer;
import java.util.TimerTask;

public class LoginPresenterImp implements LoginPresenter {
    private LoginView loginView;

    public LoginPresenterImp(LoginView loginView) {
        this.loginView = loginView;
    }

    @Override
    public void login(String username, String password) {
        loginView.showLoading();

        if (TextUtils.isEmpty(password)) {
            loginView.showError("Password should not be empty!");
            return;
        }

        if (TextUtils.isEmpty(username)) {
            loginView.showError("username should not be empty!");
            return;
        }

        sendLoginRequest(username, password);

    }

    private void sendLoginRequest(String username, String password) {
        //TODO login request

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                loginView.loginSuccess(new UserAccount());
            }
        }, 2000);
    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void destroy() {

    }
}
