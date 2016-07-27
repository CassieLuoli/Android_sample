package com.huawei.sirius.thinktank.data.localstorage;


import com.huawei.sirius.thinktank.data.model.UserAccount;

public interface UserLocalStorage {
    public void save(UserAccount userAccount);
}
