package com.huawei.sirius.thinktank.data.remotestorage;

import com.huawei.sirius.thinktank.data.model.UserAccount;

import rx.Observable;

public class UserCloudStorage {
    private static final String TAG = UserCloudStorage.class.getName();

    public Observable<UserAccount> login(String usrname, String password){
        UserApi userApi = RestClient.getInstance().getUserApi();

        //TODO: to apply right api
//        Observable<UserAccount> loginObservable = userApi.login(usrname, password);
        Observable<UserAccount> loginObservable = userApi.login();
        return loginObservable;
    }
}
