package com.optiontrade.br.ui.open

import android.annotation.SuppressLint
import android.content.Intent
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.optiontrade.br.R
import com.optiontrade.br.base.BaseFragment
import com.optiontrade.br.databinding.FragmentOpenBinding
import com.optiontrade.br.databinding.FragmentStrategyBinding
import com.optiontrade.br.ent.Strategy
import com.optiontrade.br.ent.Tip
import com.optiontrade.br.ent.VocContent
import com.optiontrade.br.log
import com.optiontrade.br.ui.MainActivity
import com.optiontrade.br.ui.open.OpenActivity
import com.optiontrade.br.ui.strategy.adapter.ParamAdapter
import com.optiontrade.br.ui.strategy.adapter.StrategyAdapter
import com.optiontrade.br.ui.tips.adapter.TipAdapter
import kotlinx.coroutines.*

class OpenFragment :
    BaseFragment<FragmentOpenBinding, OpenActivity>(R.layout.fragment_open) {

    @SuppressLint("SetTextI18n")
    override fun init() {
        with(binding) {
            tvTitle.setOnClickListener {
                parentActivity.onBackPressedDispatcher.onBackPressed()
            }
            val action = parentActivity.intent.action
            val content = parentActivity.content
            ivSave.tag = false
            when (action) {
                OpenActivity.actionStrategy -> content(content as Strategy)
                OpenActivity.actionTip -> content(content as Tip)
                OpenActivity.actionVocabulary -> content(content as VocContent)
            }
            if (ivSave.tag == true)
                ivSave.setImageResource(R.drawable.ic_bookmark)
            ivSave.setOnClickListener {
                when (action) {
                    OpenActivity.actionStrategy -> {
                        if (ivSave.tag == true) {
                            var i = -1
                            app.saved.str.forEachIndexed { index, s ->
                                if (s.id == (content as Strategy).id)
                                    i = index
                            }
                            log("$i")
                            if (i > -1)
                                app.saved.str.removeAt(i)
                            ivSave.tag = false
                            ivSave.setImageResource(R.drawable.ic_bookmark_unch)
                        } else {
                            app.saved.str.add(0, content as Strategy)
                            ivSave.tag = true
                            ivSave.setImageResource(R.drawable.ic_bookmark)
                        }
                        app.save()
                    }
                    OpenActivity.actionTip -> {
                        if (ivSave.tag == true) {
                            var i = -1
                            app.saved.tips.forEachIndexed { index, t ->
                                if (t.id == (content as Tip).id)
                                    i = index
                            }
                            if (i > -1)
                                app.saved.tips.removeAt(i)
                            ivSave.tag = false
                            ivSave.setImageResource(R.drawable.ic_bookmark_unch)
                        } else {
                            app.saved.tips.add(0, content as Tip)
                            ivSave.tag = true
                            ivSave.setImageResource(R.drawable.ic_bookmark)
                        }
                        app.save()
                    }
                    OpenActivity.actionVocabulary -> {
                        if (ivSave.tag == true) {
                            var i = -1
                            app.saved.vocs.forEachIndexed { index, v ->
                                if (v.id == (content as VocContent).id)
                                    i = index
                            }
                            if (i > -1)
                                app.saved.vocs.removeAt(i)
                            ivSave.tag = false
                            ivSave.setImageResource(R.drawable.ic_bookmark_unch)
                        } else {
                            app.saved.vocs.add(0, content as VocContent)
                            ivSave.tag = true
                            ivSave.setImageResource(R.drawable.ic_bookmark)
                        }
                        app.save()
                    }
                }
            }

        }
    }

    private fun content(s: Strategy) {
        with(binding) {
            tvTitle.text = getString(R.string.strategy)
            tvContentTitle.text = s.title
            tvDesc.text = s.text
            clParams.visibility = View.VISIBLE
            val c = if (s.cur.size > 2) 2 else 1
            rvCurrency.layoutManager =
                StaggeredGridLayoutManager(c, LinearLayoutManager.HORIZONTAL)
            rvCurrency.adapter = ParamAdapter(s.cur)
            rvTimeframe.layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            rvTimeframe.adapter = ParamAdapter(s.tf)
            app.saved.str.forEach {
                if (it.id == s.id)
                    ivSave.tag = true
            }
        }
    }

    private fun content(t: Tip) {
        with(binding) {
            tvTitle.text = getString(com.optiontrade.br.R.string.tips)
            tvContentTitle.text = t.title
            tvDesc.text = t.text
            clParams.visibility = View.GONE
            app.saved.tips.forEach {
                if (it.id == t.id)
                    ivSave.tag = true
            }
        }
    }

    private fun content(v: VocContent) {
        with(binding) {
            tvTitle.text = getString(com.optiontrade.br.R.string.vocabulary)
            tvContentTitle.text = v.title
            tvDesc.text = v.desc
            clParams.visibility = View.GONE
            app.saved.vocs.forEach {
                if (it.id == v.id)
                    ivSave.tag = true
            }
        }
    }

}