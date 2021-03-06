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

class StopDonateProgramViewModel : ViewModel() {
    init {
        DonateProgramRepository.getAllDonatePrograms().enqueue(object :
            Callback<List<DonateProgram>> {
            override fun onResponse(
                call: Call<List<DonateProgram>>,
                response: Response<List<DonateProgram>>
            ) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        _stopDonatePrograms.value =
                            it.filter { donateProgram -> donateProgram.state == "stop" }
                    }

                    Log.d("DonateProgramRepository", "onResponse: ${response.body()?.get(0)}")
                }

            }

            override fun onFailure(call: Call<List<DonateProgram>>, t: Throwable) {
                Log.d("DonateProgramRepository", "onFailure: ${t.message}")
            }

        })
    }


    private val _stopDonatePrograms = MutableLiveData<List<DonateProgram>>()
    val stopDonatePrograms: LiveData<List<DonateProgram>>
        get() = _stopDonatePrograms


}