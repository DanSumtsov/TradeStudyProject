package com.optiontrade.br.ui.open

import com.optiontrade.br.R
import com.optiontrade.br.base.BaseActivity
import com.optiontrade.br.databinding.ActivityMainBinding
import com.optiontrade.br.databinding.ActivityOpenBinding
import com.optiontrade.br.ent.Strategy
import com.optiontrade.br.ent.Tip
import com.optiontrade.br.ent.VocContent
import com.optiontrade.br.fromJson
import com.optiontrade.br.ui.saved.SavedFragment
import com.optiontrade.br.ui.strategy.StrategyFragment
import com.optiontrade.br.ui.tips.TipsFragment
import com.optiontrade.br.ui.voc.VocabularyFragment

class OpenActivity : BaseActivity<ActivityOpenBinding>(R.layout.activity_open) {

    companion object {
        const val actionSaved = "actionSaved"
        const val actionStrategy = "actionStrategy"
        const val actionTip = "actionTip"
        const val actionVocabulary = "actionVocabulary"

        const val keyContent = "keyContent"
    }

    var content: Any? = null

    override fun init() {
        super.init()
        with(binding) {
            when (intent.action) {
                actionSaved -> openFrag(SavedFragment(), false)
                actionStrategy -> {
                    content =
                        fromJson(
                            intent.getStringExtra(keyContent)!!, Strategy::class.java
                        )
                    openFrag(OpenFragment(), false)
                }
                actionTip -> {
                    content =
                        fromJson(
                            intent.getStringExtra(keyContent)!!, Tip::class.java
                        )
                    openFrag(OpenFragment(), false)
                }
                actionVocabulary -> {
                    content =
                        fromJson(
                            intent.getStringExtra(keyContent)!!, VocContent::class.java
                        )
                    openFrag(OpenFragment(), false)
                }
            }
        }
    }

}