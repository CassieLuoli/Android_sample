package com.sirius.thinktank.account.login.interfaces;

import com.sirius.thinktank.data.model.UserAccount;

import rx.Subscriber;

public interface LoginDataProvider {
    void login(String userName, String password, Subscriber<UserAccount> subscriber);
}
