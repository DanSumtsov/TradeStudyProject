package com.optiontrade.br.ui.voc.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.optiontrade.br.databinding.ItemTipBinding
import com.optiontrade.br.databinding.ItemVocabularyBinding
import com.optiontrade.br.ent.Tip
import com.optiontrade.br.ent.VocContent
import com.optiontrade.br.ent.Vocabulary
import kotlin.collections.ArrayList

class VocAdapter(
    private val items: ArrayList<Vocabulary>,
    private val onClick: ((vocabulary: VocContent) -> Unit)
) :
    RecyclerView.Adapter<VocAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            parent.context,
            ItemVocabularyBinding
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
        private val binding: ItemVocabularyBinding,
        private val onClick: ((voc: VocContent) -> Unit)
    ) :
        RecyclerView.ViewHolder(binding.root) {

        @SuppressLint("SetTextI18n")
        fun bind(voc: Vocabulary) {
            with(binding) {
                tvTitle.text = voc.letter
                rvVocContent.layoutManager = LinearLayoutManager(context)
                rvVocContent.adapter = VocContentAdapter(voc.content) {
                    onClick(it)
                }
            }
        }
    }

}