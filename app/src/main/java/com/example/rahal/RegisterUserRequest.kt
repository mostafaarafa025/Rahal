package com.example.rahal

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

 class RegisterUserRequest {

	 @SerializedName("name")
	 @Expose
	 var fullName: String? = null

	 @SerializedName("email")
	 @Expose
	 var email: String? = null

	 @SerializedName("password")
	 @Expose
	 var password: String? = null

	 @SerializedName("passwordConfirm")
	 @Expose
	 var passwordConfirm: String? = null

	 @SerializedName("role")
	 @Expose
	 var role: String? = null

	 @SerializedName("phoneNumber")
	 @Expose
	 var phoneNumber: String? = null

	 @SerializedName("city")
	 @Expose
	 var city: String? = null

	 @SerializedName("gender")
	 @Expose
	 var gender: String? = null

	 @SerializedName("birthDate")
	 @Expose
	 var birthDate: String? = null

 }
