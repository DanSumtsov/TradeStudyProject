package com.optiontrade.br.ui.voc

import android.annotation.SuppressLint
import android.content.Intent
import com.optiontrade.br.R
import com.optiontrade.br.base.BaseFragment
import com.optiontrade.br.databinding.FragmentStrategyBinding
import com.optiontrade.br.databinding.FragmentTipsBinding
import com.optiontrade.br.databinding.FragmentVocabularyBinding
import com.optiontrade.br.toJson
import com.optiontrade.br.ui.MainActivity
import com.optiontrade.br.ui.open.OpenActivity
import com.optiontrade.br.ui.tips.adapter.TipAdapter
import com.optiontrade.br.ui.voc.adapter.VocAdapter
import kotlinx.coroutines.*

class VocabularyFragment :
    BaseFragment<FragmentVocabularyBinding, MainActivity>(R.layout.fragment_vocabulary) {

    @SuppressLint("SetTextI18n")
    override fun init() {
        with(binding){
            rvVocabulary.adapter = VocAdapter(app.vocs){
                val intent = Intent(requireContext(), OpenActivity::class.java)
                intent.action = OpenActivity.actionVocabulary
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