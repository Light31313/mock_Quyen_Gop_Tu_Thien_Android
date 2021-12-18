package com.vti.charityprojectmock11.view.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController

import com.vti.charityprojectmock11.base.BaseFragment
import com.vti.charityprojectmock11.databinding.FragmentDonateBinding
import com.vti.charityprojectmock11.model.DonateProgram
import com.vti.charityprojectmock11.view.home.adapter.DonateProgramAdapter
import com.vti.charityprojectmock11.view.home.adapter.IDonateProgramAdapter
import com.vti.charityprojectmock11.view.home.adapter.NewDonateProgramAdapter
import com.vti.charityprojectmock11.viewmodel.home.DonateViewModel
import kotlinx.coroutines.*


class DonateFragment : BaseFragment<FragmentDonateBinding>(), IDonateProgramAdapter {
    private val viewModel: DonateViewModel by viewModels()
    private lateinit var donateProgramAdapter: DonateProgramAdapter
    private lateinit var newDonateProgramAdapter: NewDonateProgramAdapter
    private lateinit var coroutine: CoroutineScope

    override fun createBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): FragmentDonateBinding = FragmentDonateBinding.inflate(layoutInflater, container, false)

    override fun onStart() {
        super.onStart()
        coroutine = CoroutineScope(Dispatchers.Default)
        coroutine.launch {
            while (true) {
                delay(5000)
                withContext(Dispatchers.Main) {
                    binding.vpNewPrograms.apply {
                        if (currentItem < viewModel.totalPrograms!! - 1)
                            currentItem += 1
                        else
                            currentItem = 0
                    }
                }
            }
        }
    }

    override fun observerLiveData() {
        viewModel.donatePrograms.observe(viewLifecycleOwner, { donatePrograms ->
            donateProgramAdapter.submitList(donatePrograms)
            newDonateProgramAdapter.submitList(donatePrograms)
        })
    }

    override fun initView() {
        donateProgramAdapter = DonateProgramAdapter(this)
        newDonateProgramAdapter = NewDonateProgramAdapter(this)

        binding.rvDonatePrograms.adapter = donateProgramAdapter
        binding.vpNewPrograms.adapter = newDonateProgramAdapter

    }

    override fun initComponent() {
        viewModel.getAllDonatePrograms()
        binding.viewModel = viewModel

    }

    override fun initEvent() {

    }

    override fun onStop() {
        coroutine.cancel()
        super.onStop()
    }

    override fun onClickShowDetail(donateProgram: DonateProgram) {
        val action =
            DonateFragmentDirections.actionNavigationDonateToDetailDonateFragment(donateProgram)
        findNavController().navigate(action)
    }


}