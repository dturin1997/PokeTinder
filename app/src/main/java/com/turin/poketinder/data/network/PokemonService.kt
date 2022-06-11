package com.turin.poketinder.data.network

import com.turin.poketinder.data.model.PokemonDetailModel
import com.turin.poketinder.data.model.PokemonListModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject

class PokemonService @Inject constructor(private val pokemonApi: PokemonApi) {
    suspend fun getPokemons():PokemonListModel{
        return withContext(Dispatchers.IO){
            val res: Response<PokemonListModel> =pokemonApi.getPokemons()
            res.body()!!
        }
    }

    suspend fun getPokemonById(id:String): PokemonDetailModel {
        return withContext(Dispatchers.IO){
            val res: Response<PokemonDetailModel> =pokemonApi.getDetailPokemon(id)
            res.body()!!
        }
    }
}