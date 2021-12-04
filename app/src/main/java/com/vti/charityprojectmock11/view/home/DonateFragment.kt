package com.vti.charityprojectmock11.view.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.vti.charityprojectmock11.databinding.FragmentDonateBinding
import com.vti.charityprojectmock11.viewmodel.home.DonateViewModel


class DonateFragment : Fragment() {
    private val viewModel: DonateViewModel by viewModels()
    private lateinit var binding: FragmentDonateBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentDonateBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initComponent()
        initEvent()
    }

    private fun initComponent() {
        binding.viewModel = viewModel

    }

    private fun initEvent() {
        binding.btnDetailDonate.setOnClickListener {
            val title = "Chi Tiết Hoạt Động"
            val action = DonateFragmentDirections.actionNavigationDonateToDetailDonateFragment(title)
            findNavController().navigate(action)
        }
    }
}