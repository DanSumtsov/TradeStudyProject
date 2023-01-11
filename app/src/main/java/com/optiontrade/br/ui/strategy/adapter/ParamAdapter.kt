package com.optiontrade.br.ui.strategy.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.optiontrade.br.databinding.ItemChipBinding
import com.optiontrade.br.ent.Strategy
import kotlin.collections.ArrayList

class ParamAdapter(
    private val items: ArrayList<String>
) :
    RecyclerView.Adapter<ParamAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            parent.context,
            ItemChipBinding
                .inflate(
                    LayoutInflater
                        .from(parent.context), parent, false
                )
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class MyViewHolder(
        private val context: Context,
        private val binding: ItemChipBinding
    ) :
        RecyclerView.ViewHolder(binding.root) {

        @SuppressLint("SetTextI18n")
        fun bind(s: String) {
            with(binding) {
                tvTitle.text = s
            }
        }
    }

}