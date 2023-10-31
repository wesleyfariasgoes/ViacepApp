package com.wfghc.viacepapp.presenter.list.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.wfghc.viacepapp.databinding.ItemAddressBinding
import com.wfghc.viacepapp.domain.model.Address

class AddressAdapter: ListAdapter<Address, AddressAdapter.ViewHolder>(DIF_CALLBACK) {

    companion object {
        private val DIF_CALLBACK = object : DiffUtil.ItemCallback<Address>() {
            override fun areItemsTheSame(
                oldItem: Address,
                newItem: Address
            ): Boolean {
                return oldItem.cep == newItem.cep
            }

            override fun areContentsTheSame(
                oldItem: Address,
                newItem: Address
            ): Boolean {
                return oldItem == newItem
            }

        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemAddressBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val address = getItem(position)
        holder.binding.textAddress.text = address.getFullAddress()
        holder.binding.viewFlipper.displayedChild = 1
    }

    inner class ViewHolder(val binding: ItemAddressBinding): RecyclerView.ViewHolder(binding.root)
}