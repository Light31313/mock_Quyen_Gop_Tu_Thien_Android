package com.vti.charityprojectmock11.view.detail.tabdetail

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.vti.charityprojectmock11.R
import com.vti.charityprojectmock11.base.BaseFragment
import com.vti.charityprojectmock11.databinding.FragmentDonateBinding
import com.vti.charityprojectmock11.databinding.FragmentDonatorBinding
import com.vti.charityprojectmock11.view.detail.tabdetail.adapter.DonateAdapter
import com.vti.charityprojectmock11.view.home.adapter.DonateProgramAdapter
import com.vti.charityprojectmock11.viewmodel.detail.DetailDonateViewModel


class DonatorFragment : BaseFragment<FragmentDonatorBinding>() {

    private val viewModel: DetailDonateViewModel by viewModels(ownerProducer = { requireParentFragment() })
    private lateinit var donateAdapter: DonateAdapter

    override fun createBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): FragmentDonatorBinding = FragmentDonatorBinding.inflate(layoutInflater, container, false)

    override fun observerLiveData() {
        viewModel.donate.observe(viewLifecycleOwner, { donates ->
            donateAdapter.submitList(donates)
        })
    }

    override fun initView() {
        donateAdapter = DonateAdapter()
        binding.rvDonateList.adapter = donateAdapter
    }

    override fun initComponent() {
        viewModel.getDonatesByProgram(viewModel.donateProgram.value!!.id)
        binding.viewModel = viewModel
    }

    override fun initEvent() {

    }

}