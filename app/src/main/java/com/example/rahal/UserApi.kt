package com.example.rahal

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface UserApi {

    @POST("api/users/login")
    fun login(
        @Body userRequest: UserRequest
    ): Call<UserResponse>

    @POST("/api/users/signup")
    fun signup(
        @Body registerUserRequest: RegisterUserRequest
    ): Call<UserResponse>

    @POST("/api/users/forgetpassword")
    fun forgetpassword(
        @Body forgetPasswordRequest: ForgetPasswordRequest
    )
}