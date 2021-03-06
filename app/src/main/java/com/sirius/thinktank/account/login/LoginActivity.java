package com.sirius.thinktank.account.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.CompoundButton;
import android.widget.EditText;

import com.sirius.thinktank.R;
import com.sirius.thinktank.account.login.interfaces.LoginPresenter;
import com.sirius.thinktank.account.login.interfaces.LoginView;
import com.sirius.thinktank.meeting.calendar.CalendarActivity;
import com.sirius.thinktank.data.model.UserAccount;
import com.sirius.thinktank.shared.ui.BaseActivity;

import butterknife.BindView;
import butterknife.OnCheckedChanged;
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
        ((LoginPresenter) presenter).login(username.getText().toString(), password.getText().toString());
    }

    @OnCheckedChanged(R.id.login_remember)
    void remember(CompoundButton button, boolean checked) {
        ((LoginPresenter) presenter).rememberAccount(checked);
    }

    @Override
    public void loginSuccess(UserAccount userAccount) {
        startActivity(new Intent(this, CalendarActivity.class));
        finish();
    }
}
