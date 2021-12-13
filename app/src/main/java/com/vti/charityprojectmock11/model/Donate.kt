package com.vti.charityprojectmock11.model

import com.google.gson.annotations.SerializedName
import com.vti.charityprojectmock11.utils.Constant
import java.util.*

data class Donate(
    @SerializedName(Constant.donateId)
    val id: Int,
    @SerializedName(Constant.donateMoney)
    val donateMoney: String?,
    @SerializedName(Constant.donateMethod)
    val method: String?,
    @SerializedName(Constant.donateTime)
    val time: Date?,
    @SerializedName(Constant.donateProgram)
    val donateProgram: DonateProgram?,
    @SerializedName(Constant.donateUser)
    val user: User?
)