package com.optiontrade.br.ui.strategy.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.optiontrade.br.databinding.ItemStrategyBinding
import com.optiontrade.br.ent.Strategy
import kotlin.collections.ArrayList

class StrategyAdapter(
    private val items: ArrayList<Strategy>,
    private val onClick: ((strategy: Strategy) -> Unit)
) :
    RecyclerView.Adapter<StrategyAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            parent.context,
            ItemStrategyBinding
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
        private val binding: ItemStrategyBinding,
        private val onClick: ((strategy: Strategy) -> Unit)
    ) :
        RecyclerView.ViewHolder(binding.root) {

        @SuppressLint("SetTextI18n")
        fun bind(strategy: Strategy) {
            with(binding) {
                tvTitle.text = strategy.title
                tvDate.text = strategy.date
                val c = if (strategy.cur.size > 2) 2 else 1
                rvCurrency.layoutManager =
                    StaggeredGridLayoutManager(c, LinearLayoutManager.HORIZONTAL)
                rvCurrency.adapter = ParamAdapter(strategy.cur)
                rvTimeframe.layoutManager =
                    LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                rvTimeframe.adapter = ParamAdapter(strategy.tf)
                root.setOnClickListener {
                    onClick(strategy)
                }
                rvCurrency.suppressLayout(true)
                rvTimeframe.suppressLayout(true)
            }
        }
    }

}