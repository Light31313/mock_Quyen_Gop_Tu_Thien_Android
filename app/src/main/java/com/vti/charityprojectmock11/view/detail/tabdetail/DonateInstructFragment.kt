package com.vti.charityprojectmock11.view.detail.tabdetail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.vti.charityprojectmock11.R
import com.vti.charityprojectmock11.databinding.FragmentDonateInstructBinding
import com.vti.charityprojectmock11.viewmodel.detail.DetailDonateViewModel


class DonateInstructFragment : Fragment() {

    private val viewModel: DetailDonateViewModel by viewModels(ownerProducer = { requireParentFragment() })
    private lateinit var binding: FragmentDonateInstructBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDonateInstructBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.donateProgram.observe(viewLifecycleOwner, { donateProgram ->
            binding.txtTitle.text = donateProgram.content
        })
    }

}