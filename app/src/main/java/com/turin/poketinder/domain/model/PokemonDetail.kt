package com.turin.poketinder.domain.model

import com.google.gson.annotations.SerializedName
import com.turin.poketinder.data.database.entities.MyPokemonEntity
import com.turin.poketinder.data.model.PokemonDetailModel

data class PokemonDetail (
    val id: Int,
    val base_experience: Int,
    val height: Int,
    val weight: Int,
    val stats: List<Stats>,
    val types: List<Types>,
    val abilities: List<Abilities>
) {


    fun PokemonDetailModel.toDomain() = PokemonDetail(
        id = id,
        base_experience = base_experience,
        height = height,
        weight = weight,
        stats = stats,
        types = types,
        abilities = abilities
    )
}
