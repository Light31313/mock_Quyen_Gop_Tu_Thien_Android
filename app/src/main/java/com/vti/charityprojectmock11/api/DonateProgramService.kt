package com.vti.charityprojectmock11.api

import com.vti.charityprojectmock11.model.DonateProgram
import retrofit2.http.GET
import retrofit2.Call

interface DonateProgramService {
    @GET("/donateProgram")
    fun getAllDonatePrograms(): Call<List<DonateProgram>>
}