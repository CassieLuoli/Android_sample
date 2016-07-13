package com.huawei.sirius.thinktank.login.interfaces;

import com.huawei.sirius.thinktank.shared.interfaces.BasePresenter;

public interface LoginPresenter extends BasePresenter {
    public void login(String username, String password);
}
