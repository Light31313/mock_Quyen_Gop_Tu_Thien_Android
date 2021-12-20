package com.vti.charityprojectmock11.repository

import com.vti.charityprojectmock11.api.API
import com.vti.charityprojectmock11.api.DonateProgramService
import com.vti.charityprojectmock11.api.DonatorService

object DonatorRepository {
    private val donatorService = API.buildService(DonatorService::class.java)
    fun getDonatesByProgram(id: Int) = donatorService.getDonatorsByProgram(id)
}