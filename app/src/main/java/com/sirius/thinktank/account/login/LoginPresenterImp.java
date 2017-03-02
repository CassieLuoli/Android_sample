package com.hw.sirius.thinktank.account.login;

import android.text.TextUtils;
import android.util.Log;

import com.hw.sirius.thinktank.data.AccountManager;
import com.hw.sirius.thinktank.data.localstorage.UserLocalStorageImp;
import com.hw.sirius.thinktank.data.remotestorage.useraccount.UserCloudStorage;
import com.hw.sirius.thinktank.account.login.interfaces.LoginPresenter;
import com.hw.sirius.thinktank.account.login.interfaces.LoginView;
import com.hw.sirius.thinktank.data.model.UserAccount;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class LoginPresenterImp implements LoginPresenter {
    public static final String TAG = LoginPresenterImp.class.getName();
    private LoginView loginView;
    private boolean remember;

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

    @Override
    public void rememberAccount(boolean remember) {
        this.remember = remember;
    }

    private void sendLoginRequest(String username, String password) {
        Observable<UserAccount> login = new UserCloudStorage().login(username, password);
        login.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<UserAccount>() {
                    @Override
                    public void onCompleted() {
                        Log.d(TAG, "login onCompleted");
                        loginView.hideLoading();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "login onError: " + e.toString());
                        loginView.showError(e.toString());
                    }

                    @Override
                    public void onNext(UserAccount userAccount) {
                        Log.d(TAG, "login onSuccess");
                        AccountManager.getInstance().cache(userAccount);
                        loginView.loginSuccess(userAccount);

                        if (remember) {
                            new UserLocalStorageImp().save(userAccount);
                        }
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
