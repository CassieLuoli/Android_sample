package com.hw.sirius.thinktank.account.login;

import android.content.Context;

import com.hw.sirius.thinktank.account.login.interfaces.LoginView;
import com.hw.sirius.thinktank.data.model.UserAccount;

import org.junit.Test;

/**
 * Created by Luoli on 8/26/16.
 */
public class LoginPresenterImpTest {

    @Test
    public void testLogin() throws Exception {

    }

    @Test
    public void testRememberAccount() throws Exception {

    }

    class LoginViewForTest implements LoginView {

        private String errorMessage;

        @Override
        public void loginSuccess(UserAccount userAccount) {

        }

        @Override
        public void showLoading() {

        }

        @Override
        public void hideLoading() {

        }

        @Override
        public void showRetry() {

        }

        @Override
        public void hideRetry() {

        }

        @Override
        public void showError(String message) {
            errorMessage = message;
        }

        @Override
        public Context context() {
            return null;
        }
    }
}