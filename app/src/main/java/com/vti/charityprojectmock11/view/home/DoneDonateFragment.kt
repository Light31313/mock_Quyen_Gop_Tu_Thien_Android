package com.vti.charityprojectmock11.view.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.vti.charityprojectmock11.databinding.FragmentDoneDonateBinding
import com.vti.charityprojectmock11.viewmodel.home.DoneDonateViewModel

class DoneDonateFragment : Fragment() {
    private val viewModel: DoneDonateViewModel by viewModels()
    private lateinit var binding: FragmentDoneDonateBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentDoneDonateBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel
    }

}