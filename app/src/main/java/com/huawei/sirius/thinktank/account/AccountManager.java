package com.huawei.sirius.thinktank.account;

import android.text.format.DateUtils;

import com.huawei.sirius.thinktank.model.UserAccount;

import java.util.Date;

public class AccountManager {
    private static AccountManager instance = new AccountManager();
    private Date loginTime;

    private AccountManager() {
    }

    public static AccountManager getInstance() {
        return instance;
    }

    public void cache(UserAccount userAccount) {
        loginTime = new Date();
    }

    public boolean isExpire() {
        // TODO: to apply business logic
        boolean valid = loginTime != null
                && System.currentTimeMillis() - loginTime.getTime() < DateUtils.DAY_IN_MILLIS;
        return true;
    }

    public void expire(String username) {
        loginTime = null;
    }
}
