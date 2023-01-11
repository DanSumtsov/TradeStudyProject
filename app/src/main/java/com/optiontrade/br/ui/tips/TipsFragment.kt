package com.optiontrade.br.ui.tips

import android.annotation.SuppressLint
import android.content.Intent
import com.optiontrade.br.R
import com.optiontrade.br.base.BaseFragment
import com.optiontrade.br.databinding.FragmentStrategyBinding
import com.optiontrade.br.databinding.FragmentTipsBinding
import com.optiontrade.br.toJson
import com.optiontrade.br.ui.MainActivity
import com.optiontrade.br.ui.open.OpenActivity
import com.optiontrade.br.ui.tips.adapter.TipAdapter
import kotlinx.coroutines.*

class TipsFragment :
    BaseFragment<FragmentTipsBinding, MainActivity>(R.layout.fragment_tips) {

    @SuppressLint("SetTextI18n")
    override fun init() {
        with(binding){
            rvTips.adapter = TipAdapter(app.tips){
                val intent = Intent(requireContext(), OpenActivity::class.java)
                intent.action = OpenActivity.actionTip
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