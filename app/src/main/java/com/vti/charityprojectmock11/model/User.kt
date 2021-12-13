package com.vti.charityprojectmock11.model

import com.google.gson.annotations.SerializedName
import com.vti.charityprojectmock11.utils.Constant

data class User(
    @SerializedName(Constant.userId)
    val id: Int,
    @SerializedName(Constant.userFullName)
    val fullName: String?,
    @SerializedName(Constant.userAccount)
    val account: String?,
    @SerializedName(Constant.userEmail)
    val email: String?,
    @SerializedName(Constant.userPhoneNumber)
    val phoneNumber: String?,
    @SerializedName(Constant.userAvatar)
    val avatar: String?,
)