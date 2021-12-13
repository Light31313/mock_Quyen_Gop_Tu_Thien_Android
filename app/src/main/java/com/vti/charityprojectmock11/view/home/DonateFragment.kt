package com.vti.charityprojectmock11.view.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController

import com.vti.charityprojectmock11.base.BaseFragment
import com.vti.charityprojectmock11.databinding.FragmentDonateBinding
import com.vti.charityprojectmock11.model.DonateProgram
import com.vti.charityprojectmock11.view.home.adapter.DonateProgramAdapter
import com.vti.charityprojectmock11.view.home.adapter.IDonateProgramAdapter
import com.vti.charityprojectmock11.viewmodel.home.DonateViewModel


class DonateFragment : BaseFragment<FragmentDonateBinding>(), IDonateProgramAdapter {
    private val viewModel: DonateViewModel by viewModels()
    private lateinit var donateProgramAdapter: DonateProgramAdapter
    override fun createBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): FragmentDonateBinding = FragmentDonateBinding.inflate(layoutInflater, container, false)

    override fun observerLiveData() {
        viewModel.donatePrograms.observe(viewLifecycleOwner, { donatePrograms ->
            donateProgramAdapter.submitList(donatePrograms)
        })
    }

    override fun initView() {
        donateProgramAdapter = DonateProgramAdapter(this)
        binding.rvDonatePrograms.adapter = donateProgramAdapter
    }

    override fun initComponent() {
        viewModel.getAllDonatePrograms()
        binding.viewModel = viewModel

    }

    override fun initEvent() {

    }

    override fun onClickShowDetail(donateProgram: DonateProgram) {
        val action =
            DonateFragmentDirections.actionNavigationDonateToDetailDonateFragment(donateProgram)
        findNavController().navigate(action)
    }


}