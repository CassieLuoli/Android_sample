package com.hw.sirius.thinktank.account.login;

import com.hw.sirius.thinktank.data.AccountManager;
import com.hw.sirius.thinktank.account.login.interfaces.LoginDataProvider;
import com.hw.sirius.thinktank.data.model.UserAccount;
import com.hw.sirius.thinktank.data.remotestorage.useraccount.UserCloudStorage;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class LoginDataProviderImp implements LoginDataProvider {
    @Override
    public void login(String userName, String password,
                                         final Subscriber<UserAccount> subscriber) {
        Observable<UserAccount> login = new UserCloudStorage().login(userName, password);
        login.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<UserAccount>() {
                    @Override
                    public void onCompleted() {
                        subscriber.onCompleted();
                    }

                    @Override
                    public void onError(Throwable e) {
                        subscriber.onError(e);
                    }

                    @Override
                    public void onNext(UserAccount userAccount) {
                        AccountManager.getInstance().cache(userAccount);
                        subscriber.onNext(userAccount);
                    }
                });
    }
}
