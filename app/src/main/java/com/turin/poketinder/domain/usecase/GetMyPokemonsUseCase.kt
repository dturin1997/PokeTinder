package com.turin.poketinder.domain.usecase

import com.turin.poketinder.data.PokemonRepository
import com.turin.poketinder.domain.model.MyPokemon
import javax.inject.Inject

class GetMyPokemonsUseCase @Inject constructor(
    private val pokemonRepository: PokemonRepository
) {
    suspend operator fun invoke():List<MyPokemon>{
        return pokemonRepository.getMyPokemonsFromDatabase()
    }
}