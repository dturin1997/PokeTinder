package com.turin.poketinder.domain.usecase

import com.turin.poketinder.data.PokemonRepository
import javax.inject.Inject

class DeleteAllMyPokemonsUseCase @Inject constructor(
    private val pokemonRepository: PokemonRepository
) {
    suspend operator fun invoke(){
        pokemonRepository.deleteAllMyPokemon()
    }
}