package com.turin.poketinder.domain.usecase

import com.turin.poketinder.data.PokemonRepository
import com.turin.poketinder.domain.model.Pokemon
import javax.inject.Inject

class GetPokemonsUseCase @Inject constructor(
    private val repository:PokemonRepository){

    suspend operator fun invoke():List<Pokemon>{

        val myPokemonList = repository.getMyPokemonsFromDatabase()

        val allPokemon = repository.getAllPokemonFromApi()

        val myPokemonListIds = myPokemonList.map{it.idPokemon}

        //return repository.getAllPokemonFromApi()
        return allPokemon.filter{it.getPokemonId() !in myPokemonListIds}
    }
}