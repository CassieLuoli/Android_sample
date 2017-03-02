package com.sirius.thinktank.data.localstorage;


import com.sirius.thinktank.data.model.UserAccount;

public interface UserLocalStorage {
    public void save(UserAccount userAccount);
}
