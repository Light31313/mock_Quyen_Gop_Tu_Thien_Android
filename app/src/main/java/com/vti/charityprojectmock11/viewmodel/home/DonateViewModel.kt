package com.vti.charityprojectmock11.viewmodel.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.vti.charityprojectmock11.model.DonateProgram
import com.vti.charityprojectmock11.repository.DonateProgramRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DonateViewModel : ViewModel() {

    private val _donatePrograms = MutableLiveData<List<DonateProgram>>(listOf())
    val donatePrograms: LiveData<List<DonateProgram>>
        get() = _donatePrograms
    val totalPrograms
        get() = _donatePrograms.value?.size

    fun getAllDonatePrograms(){
        DonateProgramRepository.getAllDonatePrograms().enqueue(object:
                Callback<List<DonateProgram>> {
                override fun onResponse(
                    call: Call<List<DonateProgram>>,
                    response: Response<List<DonateProgram>>
                ) {
                    if(response.isSuccessful){
                        _donatePrograms.value = response.body()!!
                    }

                }

                override fun onFailure(call: Call<List<DonateProgram>>, t: Throwable) {
                    Log.d("DonateProgramRepository", "onFailure: ${t.message}")
                }

            })

    }
}