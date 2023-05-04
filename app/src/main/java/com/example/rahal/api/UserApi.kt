package com.example.rahal.api

import com.example.rahal.data.ForgetPasswordRequest
import com.example.rahal.data.RegisterUserRequest
import com.example.rahal.data.UserRequest
import com.example.rahal.data.UserResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface UserApi {

    @POST("users/login")
    fun login(
        @Body userRequest: UserRequest
    ): Call<UserResponse>

    @POST("users/signup")
    fun signup(
        @Body registerUserRequest: RegisterUserRequest
    ): Call<UserResponse>

    @POST("users/forgetpassword")
    fun forgetpassword(
        @Body forgetPasswordRequest: ForgetPasswordRequest
    )
}