package com.vti.charityprojectmock11.viewmodel.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.vti.charityprojectmock11.model.DonateProgram

class DetailDonateViewModel : ViewModel() {
    private val _donateProgram = MutableLiveData<DonateProgram>()
    val donateProgram: LiveData<DonateProgram>
        get() = _donateProgram
    fun setDonateProgram(donateProgram: DonateProgram){
        _donateProgram.value = donateProgram
    }
}