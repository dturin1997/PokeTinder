package com.turin.poketinder.domain.model

import com.google.gson.annotations.SerializedName
import com.turin.poketinder.data.model.StatsModel

data class Stats (

    val base_stat: Int,
    val stat: Stat

){/*
    fun StatsModel.toDomain()= Stats(
        base_stat=base_stat,
        //stat = stat.toDomain()
    )
    */
}