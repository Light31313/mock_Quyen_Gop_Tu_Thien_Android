package com.vti.charityprojectmock11.view.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.google.android.material.tabs.TabLayoutMediator
import com.vti.charityprojectmock11.view.detail.tabdetail.adapter.DetailDonateFragmentAdapter
import com.vti.charityprojectmock11.databinding.FragmentDetailDonateBinding
import com.vti.charityprojectmock11.viewmodel.detail.DetailDonateViewModel


class DetailDonateFragment : Fragment() {

    private lateinit var binding: FragmentDetailDonateBinding
    private val args: DetailDonateFragmentArgs by navArgs()
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
        (activity as AppCompatActivity).supportActionBar?.title = args.donateProgram.name

        val tabNames = arrayOf("Nội Dung", "Nhà Hảo Tâm", "Quyên Góp")
        val adapter = DetailDonateFragmentAdapter(this)
        binding.viewPager.adapter = adapter

        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = tabNames[position]
        }.attach()

        viewModel.setDonateProgram(args.donateProgram)

    }
}