package com.optiontrade.br.ui.saved

import android.annotation.SuppressLint
import android.content.Intent
import android.view.View.OnClickListener
import com.optiontrade.br.R
import com.optiontrade.br.base.BaseFragment
import com.optiontrade.br.databinding.FragmentSavedBinding
import com.optiontrade.br.ent.Strategy
import com.optiontrade.br.toJson
import com.optiontrade.br.ui.open.OpenActivity
import com.optiontrade.br.ui.saved.adapter.SavedVocAdapter
import com.optiontrade.br.ui.strategy.adapter.StrategyAdapter
import com.optiontrade.br.ui.tips.TipsFragment
import com.optiontrade.br.ui.tips.adapter.TipAdapter
import com.optiontrade.br.ui.voc.adapter.VocAdapter
import com.optiontrade.br.ui.voc.adapter.VocContentAdapter
import kotlinx.coroutines.*

class SavedFragment :
    BaseFragment<FragmentSavedBinding, OpenActivity>(R.layout.fragment_saved) {

    @SuppressLint("SetTextI18n")
    override fun init() {
        with(binding){
            tvTitle.setOnClickListener { parentActivity.onBackPressedDispatcher.onBackPressed() }
            tvStrategy.setOnClickListener(tabs)
            tvTips.setOnClickListener(tabs)
            tvVocabulary.setOnClickListener(tabs)
            tvStrategy.callOnClick()
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onResume() {
        super.onResume()
        binding.rvSaved.adapter?.notifyDataSetChanged()
    }

    private val tabs = OnClickListener{
        with(binding){
            tvStrategy.setTextColor(requireContext().getColor(R.color.grey))
            tvTips.setTextColor(requireContext().getColor(R.color.grey))
            tvVocabulary.setTextColor(requireContext().getColor(R.color.grey))
            when(it){
                tvStrategy -> {
                    tvStrategy.setTextColor(requireContext().getColor(R.color.blue))
                    rvSaved.adapter = StrategyAdapter(app.saved.str){
                        val intent = Intent(requireContext(), OpenActivity::class.java)
                        intent.action = OpenActivity.actionStrategy
                        intent.putExtra(OpenActivity.keyContent, toJson(it))
                        startActivity(intent)
                    }
                }
                tvTips -> {
                    tvTips.setTextColor(requireContext().getColor(R.color.blue))
                    rvSaved.adapter = TipAdapter(app.saved.tips){
                        val intent = Intent(requireContext(), OpenActivity::class.java)
                        intent.action = OpenActivity.actionTip
                        intent.putExtra(OpenActivity.keyContent, toJson(it))
                        startActivity(intent)
                    }
                }
                tvVocabulary -> {
                    tvVocabulary.setTextColor(requireContext().getColor(R.color.blue))
                    rvSaved.adapter = SavedVocAdapter(app.saved.vocs){
                        val intent = Intent(requireContext(), OpenActivity::class.java)
                        intent.action = OpenActivity.actionVocabulary
                        intent.putExtra(OpenActivity.keyContent, toJson(it))
                        startActivity(intent)
                    }
                }
            }
        }
    }

}