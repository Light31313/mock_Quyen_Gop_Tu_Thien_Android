package com.vti.charityprojectmock11.view.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup

import androidx.recyclerview.widget.RecyclerView
import com.vti.charityprojectmock11.databinding.ItemNewDonateProgramBinding
import com.vti.charityprojectmock11.model.DonateProgram


class NewDonateProgramAdapter(
    private val newDonatePrograms: List<DonateProgram>,
    private val iDonateProgramAdapter: IDonateProgramAdapter
) :
    RecyclerView.Adapter<NewDonateProgramAdapter.NewDonateProgramViewHolder>() {
    companion object {
        const val NUMBER_OF_PROGRAMS = 4
    }

    inner class NewDonateProgramViewHolder(val binding: ItemNewDonateProgramBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewDonateProgramViewHolder {
        val binding =
            ItemNewDonateProgramBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NewDonateProgramViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NewDonateProgramViewHolder, position: Int) {
        val newDonateProgram = newDonatePrograms[position]

        holder.binding.donateProgram = newDonateProgram
        holder.binding.flProgram.setOnClickListener {
            iDonateProgramAdapter.onClickShowDetail(newDonateProgram)
        }
    }

    override fun getItemCount(): Int = newDonatePrograms.size
}