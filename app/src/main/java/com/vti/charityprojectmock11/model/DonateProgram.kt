package com.vti.charityprojectmock11.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.vti.charityprojectmock11.form.DonateForm
import com.vti.charityprojectmock11.utils.Constant
import kotlinx.parcelize.IgnoredOnParcel
import kotlinx.parcelize.Parcelize
import java.util.*


@Parcelize
data class DonateProgram(
    @SerializedName(Constant.donateProgramId)
    val id: Int,
    @SerializedName(Constant.donateProgramName)
    val name: String?,
    @SerializedName(Constant.donateProgramContent)
    val content: String?,
    @SerializedName(Constant.donateProgramReceiver)
    val receiver: String?,
    @SerializedName(Constant.donateProgramMainImage)
    val mainImage: String?,
    @SerializedName(Constant.donateProgramSubImage)
    val subImages: List<String>?,
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
    @SerializedName(Constant.donateProgramDonates)
    val donates: List<DonateForm> = listOf()
) : Parcelable {
    @IgnoredOnParcel
    val donateTimes: String
        get() = donates.size.toString()
}