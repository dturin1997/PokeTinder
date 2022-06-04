package com.turin.poketinder.domain.usecase

import com.turin.poketinder.data.PokemonRepository
import com.turin.poketinder.data.database.entities.toDatabase
import com.turin.poketinder.domain.model.MyPokemon
import javax.inject.Inject

class SaveMyPokemonUseCase @Inject constructor(
    private val pokemonRepository: PokemonRepository
){
    suspend operator fun invoke(myPokemon: MyPokemon){
        pokemonRepository.insertMyPokemon(myPokemon.toDatabase())
    }
}