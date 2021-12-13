package com.vti.charityprojectmock11.view.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.vti.charityprojectmock11.base.BaseFragment
import com.vti.charityprojectmock11.databinding.FragmentHelpDonateBinding
import com.vti.charityprojectmock11.viewmodel.home.HelpDonateViewModel

class HelpDonateFragment : BaseFragment<FragmentHelpDonateBinding>() {
    private val viewModel: HelpDonateViewModel by viewModels()

    override fun createBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): FragmentHelpDonateBinding =
        FragmentHelpDonateBinding.inflate(layoutInflater, container, false)

    override fun initComponent() {
        binding.viewModel = viewModel
    }

}