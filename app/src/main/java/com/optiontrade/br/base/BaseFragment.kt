package com.optiontrade.br.base

import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil.inflate
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.optiontrade.br.MyApp

open class BaseFragment<BindingType : ViewDataBinding,
        ParentType : BaseActivity<*>>() : Fragment() {

    lateinit var binding: BindingType
    lateinit var parentActivity: ParentType
    private var viewRoot: View? = null
    lateinit var preferences: SharedPreferences
    lateinit var app: MyApp

    private var layout_id: Int = 0

    constructor(id : Int) : this(){
        layout_id = id
    }

    open fun init() {}

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        parentActivity = activity as ParentType
        app = parentActivity.app
        preferences = parentActivity.preferences
        return if (viewRoot != null) {
            viewRoot!!
        } else {
            binding = inflate(inflater, layout_id, container, false)
            viewRoot = binding.root
            viewRoot!!
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    fun replaceFrag(fragment: Fragment, backStack: Boolean) {
        parentActivity.openFrag(fragment, backStack)
    }

}