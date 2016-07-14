package com.huawei.sirius.thinktank.data;

import android.util.Log;

import com.huawei.sirius.thinktank.account.AccountManager;
import com.huawei.sirius.thinktank.data.rest.RestClient;
import com.huawei.sirius.thinktank.data.rest.UserApi;
import com.huawei.sirius.thinktank.model.UserAccount;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class UserCloudStorage {
    private static final String TAG = UserCloudStorage.class.getName();

    public void login(String usrname, String password, final Subscriber<UserAccount> subscriber){
        UserApi userApi = RestClient.getInstance().getUserApi();

        //TODO: to apply right api
//        Observable<UserAccount> loginObservable = userApi.login(usrname, password);
        Observable<UserAccount> loginObservable = userApi.login();
        loginObservable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<UserAccount>() {
                    @Override
                    public void onCompleted() {
                        Log.d(TAG, "login onCompleted");
                        subscriber.onCompleted();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "login onError: " + e.toString());

                        subscriber.onError(e);
                    }

                    @Override
                    public void onNext(UserAccount userAccount) {
                        Log.d(TAG, "login onSuccess");
                        AccountManager.getInstance().cache(userAccount);
                        subscriber.onNext(userAccount);
                    }
                });
    }
}
