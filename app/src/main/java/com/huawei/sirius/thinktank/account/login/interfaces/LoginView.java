package com.huawei.sirius.thinktank.account.login.interfaces;

import com.huawei.sirius.thinktank.shared.ui.interfaces.LoadingView;
import com.huawei.sirius.thinktank.data.model.UserAccount;

public interface LoginView extends LoadingView {
    public void loginSuccess(UserAccount userAccount);
}
