package com.vti.charityprojectmock11.view.detail.tabdetail

import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
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

        binding.btnDonate.setOnClickListener{
            if (binding.etMoney.text.isEmpty()) {
                Toast.makeText(activity, "Hãy nhập số tiền quyên góp", Toast.LENGTH_SHORT)
            } else {
                showDialog(binding.etMoney.text.toString())
            }
        }
    }

    private fun showDialog(title: String) {
        val dialog = Dialog(activity!!)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(true)
        dialog.setContentView(R.layout.dialog)
        val body = dialog.findViewById(R.id.tv_message) as TextView
        body.text = "Bạn muốn quyên góp " + title + " vnđ ?"
        val confirmBtn = dialog.findViewById(R.id.btn_confirm) as Button
        val icon = dialog.findViewById(R.id.iv_icon) as ImageView
        icon.setImageResource(R.drawable.ic_baseline_error_outline_24)
        confirmBtn.setOnClickListener {
            Toast.makeText(
                activity!!,
                "Cảm ơn bạn đã ủng hộ chuong trình " + title + " vnđ",
                Toast.LENGTH_LONG
            )
            dialog.dismiss()
        }
    }

}