package com.vti.charityprojectmock11.view.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.vti.charityprojectmock11.base.BaseFragment
import com.vti.charityprojectmock11.databinding.FragmentDoneDonateBinding
import com.vti.charityprojectmock11.model.DonateProgram
import com.vti.charityprojectmock11.view.home.adapter.IDonateProgramAdapter
import com.vti.charityprojectmock11.view.home.adapter.StopDonateProgramAdapter
import com.vti.charityprojectmock11.viewmodel.home.DonateViewModel

class DoneDonateFragment : BaseFragment<FragmentDoneDonateBinding>(), IDonateProgramAdapter {
    private val viewModel: DonateViewModel by activityViewModels()
    private lateinit var stopDonateProgramAdapter: StopDonateProgramAdapter


    override fun createBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): FragmentDoneDonateBinding =
        FragmentDoneDonateBinding.inflate(layoutInflater, container, false)


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
            DoneDonateFragmentDirections.actionNavigationDoneDonateToDetailDonateFragment(
                donateProgram
            )
        findNavController().navigate(action)
    }

}