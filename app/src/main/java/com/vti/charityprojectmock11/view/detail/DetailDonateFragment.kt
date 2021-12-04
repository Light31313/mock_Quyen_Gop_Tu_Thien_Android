package com.vti.charityprojectmock11.view.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.vti.charityprojectmock11.databinding.FragmentDetailDonateBinding
import com.vti.charityprojectmock11.viewmodel.detail.DetailDonateViewModel


class DetailDonateFragment : Fragment() {

    private lateinit var binding: FragmentDetailDonateBinding
    private val viewModel: DetailDonateViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailDonateBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initComponent()
    }

    private fun initComponent() {
        binding.viewModel = viewModel
    }
}