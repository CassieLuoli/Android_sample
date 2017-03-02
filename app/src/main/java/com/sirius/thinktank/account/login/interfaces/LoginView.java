package com.sirius.thinktank.account.login.interfaces;

import com.sirius.thinktank.shared.ui.interfaces.LoadingView;
import com.sirius.thinktank.data.model.UserAccount;

public interface LoginView extends LoadingView {
    public void loginSuccess(UserAccount userAccount);
}
