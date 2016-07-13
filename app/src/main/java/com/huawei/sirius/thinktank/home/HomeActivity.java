package com.huawei.sirius.thinktank.home;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.huawei.sirius.thinktank.R;
import com.huawei.sirius.thinktank.shared.ui.BaseActivity;
import com.huawei.sirius.thinktank.login.LoginPresenterImp;
import com.huawei.sirius.thinktank.login.interfaces.LoginView;
import com.huawei.sirius.thinktank.model.UserAccount;

public class HomeActivity extends BaseActivity implements LoginView {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);
    }

    @Override
    public void initPresenter() {
        this.presenter = new LoginPresenterImp(this);
    }

    @Override
    public void loginSuccess(UserAccount userAccount) {

    }
}
