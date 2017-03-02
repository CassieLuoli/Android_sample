package com.hw.sirius.thinktank.account.login.interfaces;

import com.hw.sirius.thinktank.shared.ui.interfaces.BasePresenter;

public interface LoginPresenter extends BasePresenter {
    public void login(String username, String password);

    void rememberAccount(boolean remember);
}
