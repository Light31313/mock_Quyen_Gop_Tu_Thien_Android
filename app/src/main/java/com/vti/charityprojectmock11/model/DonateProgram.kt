package com.vti.charityprojectmock11.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.vti.charityprojectmock11.utils.Constant
import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
data class DonateProgram(
    @SerializedName(Constant.donateProgramId)
    val id: Int,
    @SerializedName(Constant.donateProgramName)
    val name: String?,
    @SerializedName(Constant.donateProgramContent)
    val content: String?,
    @SerializedName(Constant.donateProgramMainImage)
    val mainImage: String?,
    @SerializedName(Constant.donateProgramSubImage1)
    val subImage1: String?,
    @SerializedName(Constant.donateProgramSubImage2)
    val subImage2: String?,
    @SerializedName(Constant.donateProgramSubImage3)
    val subImage3: String?,
    @SerializedName(Constant.donateProgramStartDate)
    val startDate: Date?,
    @SerializedName(Constant.donateProgramEndDate)
    val endDate: Date?,
    @SerializedName(Constant.donateProgramTargetMoney)
    val targetMoney: Float?,
    @SerializedName(Constant.donateProgramCurrentMoney)
    val currentMoney: Float?,
    @SerializedName(Constant.donateProgramState)
    val state: String?,
) : Parcelable