package com.vti.charityprojectmock11.view.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.vti.charityprojectmock11.base.BaseFragment
import com.vti.charityprojectmock11.databinding.FragmentStopDonateProgramBinding
import com.vti.charityprojectmock11.model.DonateProgram
import com.vti.charityprojectmock11.view.home.adapter.IDonateProgramAdapter
import com.vti.charityprojectmock11.view.home.adapter.StopDonateProgramAdapter
import com.vti.charityprojectmock11.viewmodel.home.StopDonateProgramViewModel

class StopDonateProgramFragment : BaseFragment<FragmentStopDonateProgramBinding>(), IDonateProgramAdapter {
    private val viewModel: StopDonateProgramViewModel by viewModels()
    private lateinit var stopDonateProgramAdapter: StopDonateProgramAdapter


    override fun createBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): FragmentStopDonateProgramBinding =
        FragmentStopDonateProgramBinding.inflate(layoutInflater, container, false)


    override fun observerLiveData() {
        viewModel.stopDonatePrograms.observe(viewLifecycleOwner, { donatePrograms ->

            stopDonateProgramAdapter.submitList(donatePrograms)

        })
    }

    override fun initView() {
        stopDonateProgramAdapter = StopDonateProgramAdapter(this)

        binding.rvDonatePrograms.adapter = stopDonateProgramAdapter

    }


    override fun onClickShowDetail(donateProgram: DonateProgram) {
        val action =
            StopDonateProgramFragmentDirections.actionNavigationDoneDonateToDetailDonateFragment(
                donateProgram
            )
        findNavController().navigate(action)
    }

}