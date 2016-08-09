package com.hw.sirius.thinktank.data.localstorage;


import com.hw.sirius.thinktank.data.model.UserAccount;

public interface UserLocalStorage {
    public void save(UserAccount userAccount);
}
