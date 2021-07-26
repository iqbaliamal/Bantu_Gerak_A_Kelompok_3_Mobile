package com.example.bantugerak_mobile.app

import com.example.bantugerak_mobile.model.ResponModel
import retrofit2.Call
import retrofit2.http.*

interface ApiService {
    @FormUrlEncoded
    @POST("register")
    fun register(
        @Field("name") name: String,
        @Field("email") email: String,
        @Field("password") password: String,
        @Field("password_confirmation") confirm_password: String
    ): retrofit2.Call<ResponModel>

    @FormUrlEncoded
    @POST("login")
    fun login(
        @Field("email") email: String,
        @Field("password") password: String,
    ): retrofit2.Call<ResponModel>

    @GET("campaign")
    fun getCampaign():retrofit2.Call<ResponModel>

    @GET("donation/{id}")
    fun getDonation(
            @Path("id") id: Int
    ): Call<ResponModel>

}