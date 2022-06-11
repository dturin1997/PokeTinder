package com.turin.poketinder.domain.usecase

import com.turin.poketinder.data.PokemonRepository
import com.turin.poketinder.data.model.PokemonDetailModel
import com.turin.poketinder.domain.model.Pokemon
import com.turin.poketinder.domain.model.PokemonDetail
import javax.inject.Inject

class GetMyPokemonDetailUseCase @Inject constructor(
    private val repository: PokemonRepository
){
    suspend operator fun invoke(idPokemon:String): PokemonDetailModel {
        return repository.getPokemonDetailFromApi(idPokemon)
    }
}