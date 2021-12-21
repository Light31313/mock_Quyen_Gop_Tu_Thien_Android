package com.vti.charityprojectmock11.repository


import com.vti.charityprojectmock11.api.API
import com.vti.charityprojectmock11.api.DonateProgramService


object DonateProgramRepository {
    private val donateProgramService = API.buildService(DonateProgramService::class.java)
    fun getAllDonatePrograms() = donateProgramService.getAllDonatePrograms()

}