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

class DonateProgramViewModel : ViewModel() {
    init {
        DonateProgramRepository.getAllDonatePrograms().enqueue(object :
            Callback<List<DonateProgram>> {
            override fun onResponse(
                call: Call<List<DonateProgram>>,
                response: Response<List<DonateProgram>>
            ) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        _runningDonatePrograms.value = it
                            .filter { donateProgram -> donateProgram.state == "running" }
                    }

                    Log.d("DonateProgramRepository", "onResponse: ${response.body()?.get(0)}")
                }

            }

            override fun onFailure(call: Call<List<DonateProgram>>, t: Throwable) {
                Log.d("DonateProgramRepository", "onFailure: ${t.message}")
            }

        })
    }


    private val _runningDonatePrograms = MutableLiveData<List<DonateProgram>>()
    val runningDonatePrograms: LiveData<List<DonateProgram>>
        get() = _runningDonatePrograms


    val totalRunningPrograms
        get() = _runningDonatePrograms.value?.size


}