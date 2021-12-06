package com.vti.charityprojectmock11.view.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.tabs.TabLayoutMediator
import com.vti.charityprojectmock11.adapter.DetailDonateFragmentAdapter
import com.vti.charityprojectmock11.databinding.FragmentDetailDonateBinding



class DetailDonateFragment : Fragment() {

    private lateinit var binding: FragmentDetailDonateBinding

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
        val tabNames = arrayOf("Nội Dung", "Nhà Hảo Tâm", "Quyên Góp")

        val adapter = DetailDonateFragmentAdapter(this)
        binding.viewPager.adapter = adapter

        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = tabNames[position]
        }.attach()
    }
}