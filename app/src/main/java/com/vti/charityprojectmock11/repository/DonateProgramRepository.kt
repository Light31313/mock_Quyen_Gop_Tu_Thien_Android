package com.vti.charityprojectmock11.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.vti.charityprojectmock11.api.API
import com.vti.charityprojectmock11.api.DonateProgramService
import com.vti.charityprojectmock11.model.DonateProgram
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object DonateProgramRepository {
    private val donateProgramService = API.buildService(DonateProgramService::class.java)
    fun getAllDonatePrograms() = donateProgramService.getAllDonatePrograms()

}