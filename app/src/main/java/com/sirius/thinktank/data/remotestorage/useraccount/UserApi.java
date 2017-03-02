package com.hw.sirius.thinktank.data.remotestorage.useraccount;

import com.hw.sirius.thinktank.data.model.UserAccount;

import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import rx.Observable;

public interface UserApi {
    @POST("/login")
    Observable<UserAccount> login(@Header("email") String username,
                                  @Header("password") String password);

    @GET("/facebook/react-native/master/docs/MoviesExample.json")
    Observable<UserAccount> login();
}
