package com.optiontrade.br.ent

data class Strategy(
    val id: Int,
    val title: String,
    val date: String,
    val text: String,
    val cur: ArrayList<String>,
    val tf: ArrayList<String>
)

data class Tip(
    val id: Int,
    val title: String,
    val text: String
)

data class Vocabulary(
    val letter: String,
    val content: ArrayList<VocContent>
)

data class VocContent(
    val id: Int,
    val title: String,
    val desc: String
)

data class Saved(
    val str: ArrayList<Strategy>,
    val tips: ArrayList<Tip>,
    val vocs: ArrayList<VocContent>
)