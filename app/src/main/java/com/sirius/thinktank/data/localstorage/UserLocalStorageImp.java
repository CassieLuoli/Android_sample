package com.sirius.thinktank.data.localstorage;

import com.sirius.thinktank.data.model.UserAccount;
import com.sirius.thinktank.shared.utils.PreferenceUtil;

public class UserLocalStorageImp implements UserLocalStorage {
    @Override
    public void save(UserAccount userAccount) {
        PreferenceUtil.save(PreferenceUtil.USER_ACCOUNT, userAccount.getUserName());
    }
}
