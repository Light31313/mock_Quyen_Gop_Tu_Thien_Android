package com.vti.charityprojectmock11.api

import com.vti.charityprojectmock11.model.Donate
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface DonatorService {
    @GET("/donateProgram/{id}/donate")
    fun getDonatorsByProgram(@Path("id") id:Int): Call<List<Donate>>
}