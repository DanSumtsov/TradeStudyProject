package com.optiontrade.br.ui.tips.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.optiontrade.br.databinding.ItemTipBinding
import com.optiontrade.br.ent.Tip
import kotlin.collections.ArrayList

class TipAdapter(
    private val items: ArrayList<Tip>,
    private val onClick: ((tip: Tip) -> Unit)
) :
    RecyclerView.Adapter<TipAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            parent.context,
            ItemTipBinding
                .inflate(
                    LayoutInflater
                        .from(parent.context), parent, false
                ), onClick
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
        private val binding: ItemTipBinding,
        private val onClick: ((tip: Tip) -> Unit)
    ) :
        RecyclerView.ViewHolder(binding.root) {

        @SuppressLint("SetTextI18n")
        fun bind(tip: Tip) {
            with(binding) {
                tvTitle.text = tip.title
                tvText.text = tip.text
                root.setOnClickListener {
                    onClick(tip)
                }
            }
        }
    }

}