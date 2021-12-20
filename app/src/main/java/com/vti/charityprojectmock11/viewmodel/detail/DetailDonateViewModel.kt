package com.vti.charityprojectmock11.viewmodel.detail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.vti.charityprojectmock11.model.Donate
import com.vti.charityprojectmock11.model.DonateProgram
import com.vti.charityprojectmock11.repository.DonatorRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailDonateViewModel : ViewModel() {
    private val _donateProgram = MutableLiveData<DonateProgram>()
    private val _donate = MutableLiveData<List<Donate>>()
    val donateProgram: LiveData<DonateProgram>
        get() = _donateProgram
    val donate: LiveData<List<Donate>>
        get() = _donate

    fun setDonateProgram(donateProgram: DonateProgram) {
        _donateProgram.value = donateProgram
    }

    fun getDonatesByProgram(id: Int) {
        DonatorRepository.getDonatesByProgram(id).enqueue(object :
            Callback<List<Donate>> {
            override fun onResponse(
                call: Call<List<Donate>>,
                response: Response<List<Donate>>
            ) {
                if (response.isSuccessful) {
                    _donate.value = response.body()!!
                }
            }

            override fun onFailure(call: Call<List<Donate>>, t: Throwable) {
                Log.d("DonateRepository", "onFailure: ${t.message}")
            }
        })
    }
}