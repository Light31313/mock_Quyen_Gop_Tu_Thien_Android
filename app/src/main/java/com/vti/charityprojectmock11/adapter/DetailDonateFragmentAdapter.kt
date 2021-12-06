package com.vti.charityprojectmock11.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.vti.charityprojectmock11.view.detail.tabdetail.DonateInstructFragment
import com.vti.charityprojectmock11.view.detail.tabdetail.DonatorFragment
import com.vti.charityprojectmock11.view.detail.tabdetail.ProgramFragment

class DetailDonateFragmentAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> ProgramFragment()
            1 -> DonatorFragment()
            2 -> DonateInstructFragment()
            else -> ProgramFragment()
        }
    }
}