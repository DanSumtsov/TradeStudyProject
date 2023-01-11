package com.optiontrade.br.ui.strategy

import android.annotation.SuppressLint
import android.content.Intent
import com.optiontrade.br.R
import com.optiontrade.br.base.BaseFragment
import com.optiontrade.br.databinding.FragmentStrategyBinding
import com.optiontrade.br.toJson
import com.optiontrade.br.ui.MainActivity
import com.optiontrade.br.ui.open.OpenActivity
import com.optiontrade.br.ui.open.OpenFragment
import com.optiontrade.br.ui.strategy.adapter.StrategyAdapter
import com.optiontrade.br.ui.tips.adapter.TipAdapter
import kotlinx.coroutines.*

class StrategyFragment :
    BaseFragment<FragmentStrategyBinding, MainActivity>(R.layout.fragment_strategy) {

    @SuppressLint("SetTextI18n")
    override fun init() {
        with(binding){
            rvStrategy.adapter = StrategyAdapter(app.strategy){
                val intent = Intent(requireContext(), OpenActivity::class.java)
                intent.action = OpenActivity.actionStrategy
                intent.putExtra(OpenActivity.keyContent, toJson(it))
                startActivity(intent)
            }
            ivSave.setOnClickListener {
                val intent = Intent(requireContext(), OpenActivity::class.java)
                intent.action = OpenActivity.actionSaved
                startActivity(intent)
            }
        }
    }

}