package com.optiontrade.br.base

import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.optiontrade.br.MyApp
import com.optiontrade.br.MyApp.Companion.tagPreferences
import com.optiontrade.br.R

open class BaseActivity<B : ViewDataBinding>() : AppCompatActivity() {

    lateinit var binding: B
    lateinit var preferences: SharedPreferences
    lateinit var app: MyApp

    private var layout_id: Int = -1

    constructor(id : Int) : this(){
        layout_id = id
    }

    open fun init(){}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout_id)
        binding = DataBindingUtil.setContentView(this, layout_id)
        app = application as MyApp
        preferences = getSharedPreferences(tagPreferences, MODE_PRIVATE)
        init()
    }

    fun openFrag(fragment: Fragment, backStack: Boolean) {
        if (fragment.isVisible)
            return
        val transaction = supportFragmentManager
            .beginTransaction()
            .replace(R.id.nav_host_fragment, fragment)
        if (backStack)
            transaction.addToBackStack(null)
        transaction.commitAllowingStateLoss()
    }

    fun openFrag(fragment: Fragment, id: Int, backStack: Boolean) {
        if (fragment.isVisible)
            return
        val transaction = supportFragmentManager
            .beginTransaction()
            .replace(id, fragment)
        if (backStack)
            transaction.addToBackStack(null)
        transaction.commitAllowingStateLoss()
    }

}