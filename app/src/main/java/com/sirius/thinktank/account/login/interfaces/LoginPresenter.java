package com.sirius.thinktank.account.login.interfaces;

import com.sirius.thinktank.shared.ui.interfaces.BasePresenter;

public interface LoginPresenter extends BasePresenter {
    public void login(String username, String password);

    void rememberAccount(boolean remember);
}
