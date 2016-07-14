package com.huawei.sirius.thinktank.login;

import android.text.TextUtils;

import com.huawei.sirius.thinktank.login.interfaces.LoginPresenter;
import com.huawei.sirius.thinktank.login.interfaces.LoginView;
import com.huawei.sirius.thinktank.model.UserAccount;
import com.huawei.sirius.thinktank.data.UserCloudStorage;

import rx.Subscriber;

public class LoginPresenterImp implements LoginPresenter {
    private LoginView loginView;

    public LoginPresenterImp(LoginView loginView) {
        this.loginView = loginView;
    }

    @Override
    public void login(String username, String password) {
        loginView.showLoading();

        if (TextUtils.isEmpty(username)) {
            loginView.showError("username should not be empty!");
            return;
        }

        if (TextUtils.isEmpty(password)) {
            loginView.showError("Password should not be empty!");
            return;
        }

        sendLoginRequest(username, password);

    }

    private void sendLoginRequest(String username, String password) {

        new UserCloudStorage().login(username, password, new Subscriber<UserAccount>() {
            @Override
            public void onCompleted() {
                loginView.hideLoading();
            }

            @Override
            public void onError(Throwable e) {
                loginView.showError(e.getMessage());
            }

            @Override
            public void onNext(UserAccount userAccount) {
                loginView.loginSuccess(new UserAccount());
            }
        });
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
