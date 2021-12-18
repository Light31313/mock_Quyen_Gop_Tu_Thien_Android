package com.vti.charityprojectmock11.view.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.vti.charityprojectmock11.databinding.ItemNewDonateProgramBinding
import com.vti.charityprojectmock11.model.DonateProgram

class NewDonateProgramAdapter(val iDonateProgramAdapter: IDonateProgramAdapter) :
    ListAdapter<DonateProgram, NewDonateProgramAdapter.DonateProgramViewHolder>(DiffCallback) {

    inner class DonateProgramViewHolder(
        private val binding: ItemNewDonateProgramBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(donateProgram: DonateProgram) = with(binding) {
            this.donateProgram = donateProgram
            clDonateProgram.setOnClickListener {
                iDonateProgramAdapter.onClickShowDetail(donateProgram)
            }


        }

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DonateProgramViewHolder {
        val binding =
            ItemNewDonateProgramBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DonateProgramViewHolder(binding)

    }

    override fun onBindViewHolder(holder: DonateProgramViewHolder, position: Int) {
        holder.bind(currentList[position])
    }


    companion object {
        private val DiffCallback = object : DiffUtil.ItemCallback<DonateProgram>() {
            override fun areItemsTheSame(oldItem: DonateProgram, newItem: DonateProgram): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(
                oldItem: DonateProgram,
                newItem: DonateProgram
            ): Boolean {
                return oldItem == newItem
            }
        }
    }
}