package com.huawei.sirius.thinktank.login.interfaces;

import com.huawei.sirius.thinktank.shared.interfaces.LoadingView;
import com.huawei.sirius.thinktank.model.UserAccount;

public interface LoginView extends LoadingView {
    public void loginSuccess(UserAccount userAccount);
}
