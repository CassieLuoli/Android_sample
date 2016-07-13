package com.huawei.sirius.thinktank.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.EditText;

import com.huawei.sirius.thinktank.R;
import com.huawei.sirius.thinktank.home.HomeActivity;
import com.huawei.sirius.thinktank.login.interfaces.LoginView;
import com.huawei.sirius.thinktank.model.UserAccount;
import com.huawei.sirius.thinktank.shared.ui.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity implements LoginView {

    @BindView(R.id.login_username)
    EditText username;

    @BindView(R.id.login_password)
    EditText password;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
    }

    @Override
    public void initPresenter() {
        presenter = new LoginPresenterImp(this);
    }

    @OnClick(R.id.login_submit)
    void submit() {
        ((LoginPresenterImp) presenter).login(username.getText().toString(), password.getText().toString());
    }

    @Override
    public void loginSuccess(UserAccount userAccount) {
        startActivity(new Intent(this, HomeActivity.class));
        finish();
    }
}
