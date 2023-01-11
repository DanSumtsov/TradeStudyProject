package com.optiontrade.br

import android.app.Application
import android.content.SharedPreferences
import com.optiontrade.br.ent.*

class MyApp : Application() {

    companion object {
        const val tagPreferences = "OptionTradeBRSharedPreferences"
        const val keySaved = "keySaved"
    }

    private lateinit var preferences: SharedPreferences

    var strategy = ArrayList<Strategy>()
    var tips = ArrayList<Tip>()
    var vocs = ArrayList<Vocabulary>()

    lateinit var saved: Saved

    override fun onCreate() {
        super.onCreate()
        preferences = getSharedPreferences(tagPreferences, MODE_PRIVATE)
        val s = preferences.getString(keySaved, null)
        saved = if (s != null)
            fromJson(s, Saved::class.java)
        else
            Saved(ArrayList(), ArrayList(), ArrayList())
        strategy()
        tips()
        vocs()
        save()
    }

    fun save() {
        preferences.edit().putString(keySaved, toJson(saved)).apply()
    }

    private fun strategy() {
        val st = resources.getStringArray(R.array.str_title)
        val sc = resources.getStringArray(R.array.str_cur)
        val stf = resources.getStringArray(R.array.str_tf)
        val stx = resources.getStringArray(R.array.str_text)
        st.forEachIndexed { i, s ->
            val cur = ArrayList(sc[i].split(" "))
            val tf = ArrayList(stf[i].split(" "))
            strategy.add(Strategy(i, s, "08.12.2022", stx[i], cur, tf))
        }
    }

    private fun tips() {
        val tt = resources.getStringArray(R.array.tip_title)
        val ttx = resources.getStringArray(R.array.tip_text)
        tt.forEachIndexed { i, s ->
            tips.add(Tip(i, s, ttx[i]))
        }
    }

    private fun vocs() {
        val vt = resources.getStringArray(R.array.voc_title)
        val vd = resources.getStringArray(R.array.voc_desc)
        var l = vt.first().first()
        var v = Vocabulary(l.toString(), ArrayList())
        vt.forEachIndexed { i, s ->
            if (s.first() != l) {
                l = s.first()
                vocs.add(v)
                v = Vocabulary(l.toString(), ArrayList())
            }
            v.content.add(VocContent(i, s, vd[i]))
        }
        vocs.add(v)
        log(toJson(vocs))
    }

}