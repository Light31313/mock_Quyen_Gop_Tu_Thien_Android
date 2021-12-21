package com.vti.charityprojectmock11.form

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.vti.charityprojectmock11.utils.Constant
import kotlinx.parcelize.Parcelize

@Parcelize
data class DonateForm(
    @SerializedName(Constant.donateId)
    val id: Int
): Parcelable