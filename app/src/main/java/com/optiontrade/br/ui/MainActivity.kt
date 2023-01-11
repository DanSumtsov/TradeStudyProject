package com.optiontrade.br.ui

import com.optiontrade.br.R
import com.optiontrade.br.base.BaseActivity
import com.optiontrade.br.databinding.ActivityMainBinding
import com.optiontrade.br.ui.strategy.StrategyFragment
import com.optiontrade.br.ui.tips.TipsFragment
import com.optiontrade.br.ui.voc.VocabularyFragment

class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {

    private val strategyFragment = StrategyFragment()
    private val tipsFragment = TipsFragment()
    private val vocsFragment = VocabularyFragment()

    override fun init() {
        super.init()
        with(binding) {
            bnv.setOnItemSelectedListener {
                when (it.itemId) {
                    R.id.strategy -> openFrag(strategyFragment, false)
                    R.id.tips -> openFrag(tipsFragment, false)
                    R.id.vocabulary -> openFrag(vocsFragment, false)
                }
                true
            }
            bnv.selectedItemId = R.id.strategy
        }
    }

}