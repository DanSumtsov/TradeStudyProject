package com.optiontrade.br.ui.voc.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.optiontrade.br.databinding.ItemTipBinding
import com.optiontrade.br.databinding.ItemVocContentBinding
import com.optiontrade.br.ent.Tip
import com.optiontrade.br.ent.VocContent
import kotlin.collections.ArrayList

class VocContentAdapter(
    private val items: ArrayList<VocContent>,
    private val onClick: ((vocContent: VocContent) -> Unit)
) :
    RecyclerView.Adapter<VocContentAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            parent.context,
            ItemVocContentBinding
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
        private val binding: ItemVocContentBinding,
        private val onClick: ((vocContent: VocContent) -> Unit)
    ) :
        RecyclerView.ViewHolder(binding.root) {

        @SuppressLint("SetTextI18n")
        fun bind(vocContent: VocContent) {
            with(binding) {
                tvTitle.text = vocContent.title
                root.setOnClickListener {
                    onClick(vocContent)
                }
            }
        }
    }

}