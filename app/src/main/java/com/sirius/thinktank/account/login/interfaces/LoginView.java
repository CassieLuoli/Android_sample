package com.hw.sirius.thinktank.account.login.interfaces;

import com.hw.sirius.thinktank.shared.ui.interfaces.LoadingView;
import com.hw.sirius.thinktank.data.model.UserAccount;

public interface LoginView extends LoadingView {
    public void loginSuccess(UserAccount userAccount);
}
