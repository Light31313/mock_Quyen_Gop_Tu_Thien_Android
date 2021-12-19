package com.vti.charityprojectmock11.view.detail.tabdetail.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.vti.charityprojectmock11.databinding.ContributeItemBinding
import com.vti.charityprojectmock11.model.Donate

class DonateAdapter : ListAdapter<Donate, DonateAdapter.DonateViewHolder>(DiffCallback) {

    inner class DonateViewHolder(
        private val binding: ContributeItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(donate: Donate) = with(binding) {
            this.donate = donate
//            itemDonate.setOnClickListener {
//                iDonateProgramAdapter.onClickShowDetail(donateProgram)
//            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DonateViewHolder {
        val binding =
            ContributeItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DonateViewHolder(binding)

    }

    override fun onBindViewHolder(holder: DonateViewHolder, position: Int) {
        holder.bind(currentList[position])
    }


    companion object {
        private val DiffCallback = object : DiffUtil.ItemCallback<Donate>() {
            override fun areItemsTheSame(oldItem: Donate, newItem: Donate): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(
                oldItem: Donate,
                newItem: Donate
            ): Boolean {
                return oldItem == newItem
            }
        }
    }
}