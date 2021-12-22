package com.vti.charityprojectmock11.view.home


import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.google.android.material.tabs.TabLayoutMediator

import com.vti.charityprojectmock11.base.BaseFragment
import com.vti.charityprojectmock11.databinding.FragmentDonateProgramBinding
import com.vti.charityprojectmock11.model.DonateProgram
import com.vti.charityprojectmock11.view.home.adapter.DonateProgramAdapter
import com.vti.charityprojectmock11.view.home.adapter.IDonateProgramAdapter
import com.vti.charityprojectmock11.view.home.adapter.NewDonateProgramAdapter
import com.vti.charityprojectmock11.viewmodel.home.DonateProgramViewModel
import kotlinx.coroutines.*


class DonateProgramFragment : BaseFragment<FragmentDonateProgramBinding>(), IDonateProgramAdapter {
    private val viewModel: DonateProgramViewModel by viewModels()
    private lateinit var donateProgramAdapter: DonateProgramAdapter
    private lateinit var newDonateProgramAdapter: NewDonateProgramAdapter

    private val currentNewRunningDonatePrograms = mutableListOf<DonateProgram>()

    private var swipeScreenJob: Job? = null

    override fun createBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): FragmentDonateProgramBinding = FragmentDonateProgramBinding.inflate(layoutInflater, container, false)

    override fun onStart() {
        super.onStart()

        swipeScreenJob = CoroutineScope(Dispatchers.Default).launch {
            while (true) {
                delay(5000)
                withContext(Dispatchers.Main) {
                    if (isActive) {
                        binding.vpNewPrograms.apply {
                            if (viewModel.totalRunningPrograms == null)
                                return@apply
                            if (currentItem < NewDonateProgramAdapter.NUMBER_OF_PROGRAMS - 1)
                                currentItem += 1
                            else
                                currentItem = 0
                        }
                    }
                }
            }
        }
    }


    override fun observerLiveData() {
        viewModel.runningDonatePrograms.observe(viewLifecycleOwner, { donatePrograms ->

            donateProgramAdapter.submitList(donatePrograms)

            if (donatePrograms.size >= 4) {
                currentNewRunningDonatePrograms.clear()
                currentNewRunningDonatePrograms.addAll(donatePrograms.sorted().subList(0, 4))
                newDonateProgramAdapter.notifyItemRangeChanged(0, 4)
            }

        })
    }

    override fun initView() {
        donateProgramAdapter = DonateProgramAdapter(this)

        newDonateProgramAdapter = NewDonateProgramAdapter(currentNewRunningDonatePrograms, this)

        binding.apply {
            rvDonatePrograms.adapter = donateProgramAdapter
            vpNewPrograms.adapter = newDonateProgramAdapter
            TabLayoutMediator(tlNewPrograms, vpNewPrograms) { _, _ -> }.attach()
        }
    }


    override fun onStop() {
        swipeScreenJob?.cancel()
        swipeScreenJob = null
        super.onStop()
    }

    override fun onClickShowDetail(donateProgram: DonateProgram) {
        val action =
            DonateProgramFragmentDirections.actionNavigationDonateToDetailDonateFragment(donateProgram)
        findNavController().navigate(action)
    }

}