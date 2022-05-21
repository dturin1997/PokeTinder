package com.turin.poketinder.data

import com.turin.poketinder.data.model.PokemonListModel
import com.turin.poketinder.data.model.PokemonModel
import com.turin.poketinder.data.network.PokemonService
import com.turin.poketinder.domain.model.Pokemon
import com.turin.poketinder.domain.model.toDomain
import javax.inject.Inject

class PokemonRepository @Inject constructor(
    private val pokemonService: PokemonService
) {
    suspend fun getAllPokemonFromApi(): List<Pokemon>{
        val listResponse: PokemonListModel=pokemonService.getPokemons()
        val response: List<PokemonModel> = listResponse.results
        return response.map {it.toDomain()}
    }
}