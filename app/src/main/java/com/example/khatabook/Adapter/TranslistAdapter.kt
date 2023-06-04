package com.example.khatabook.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.khatabook.Model.TransModal
import com.example.khatabook.databinding.TransItemBinding

class TranslistAdapter : RecyclerView.Adapter<TranslistAdapter.TransListHolder>() {

    var transList = ArrayList<TransModal>()

    class TransListHolder(itemView: TransItemBinding) : ViewHolder(itemView.root) {

        var binding = itemView


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransListHolder {

        var binding = TransItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TransListHolder(binding)
    }

    override fun getItemCount(): Int {
        return 5

    }

    override fun onBindViewHolder(holder: TransListHolder, position: Int) {
        holder.binding.apply {
            transList.get(position).apply {

                txtCategory.text = category
                txtNotes.text = note
                txtAmt.text = amt.toString()
            }
        }

    }

    fun setTrans(transList: ArrayList<TransModal>) {

        this.transList = transList
    }
}