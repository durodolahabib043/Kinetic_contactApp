package com.durodola.mobile.kinetic_contact_app.Services;

import com.durodola.mobile.kinetic_contact_app.ContactResult;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by mobile on 2016-04-21.
 */
public interface ContactServiceApi {

    @GET("/1.0")
    Call<ContactResult> getdetailedContact();

}
