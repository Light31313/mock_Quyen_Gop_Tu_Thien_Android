package com.vti.charityprojectmock11.view.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.vti.charityprojectmock11.base.BaseFragment
import com.vti.charityprojectmock11.databinding.FragmentDoneDonateBinding
import com.vti.charityprojectmock11.viewmodel.home.DoneDonateViewModel

class DoneDonateFragment : BaseFragment<FragmentDoneDonateBinding>() {
    private val viewModel: DoneDonateViewModel by viewModels()

    override fun createBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): FragmentDoneDonateBinding =
        FragmentDoneDonateBinding.inflate(layoutInflater, container, false)

    override fun initComponent() {
        binding.viewModel = viewModel
    }

}