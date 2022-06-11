package com.turin.poketinder.data

import com.turin.poketinder.data.database.dao.PokemonDao
import com.turin.poketinder.data.database.entities.MyPokemonEntity
import com.turin.poketinder.data.model.PokemonDetailModel
import com.turin.poketinder.data.model.PokemonListModel
import com.turin.poketinder.data.model.PokemonModel
import com.turin.poketinder.data.network.PokemonService
import com.turin.poketinder.domain.model.MyPokemon
import com.turin.poketinder.domain.model.Pokemon
import com.turin.poketinder.domain.model.PokemonDetail
import com.turin.poketinder.domain.model.toDomain
import javax.inject.Inject

class PokemonRepository @Inject constructor(
    private val pokemonService: PokemonService,

    private val pokemonDao: PokemonDao
) {
    suspend fun getAllPokemonFromApi(): List<Pokemon>{
        val listResponse: PokemonListModel=pokemonService.getPokemons()
        val response: List<PokemonModel> = listResponse.results
        return response.map {it.toDomain()}
    }

    suspend fun getPokemonDetailFromApi(idPokemon:String): PokemonDetailModel{
        //val response =pokemonService.getPokemonsById(idPokemon)
        //return response.map {it.toDomain()}
        return pokemonService.getPokemonById(idPokemon)
    }

    suspend fun getMyPokemonsFromDatabase():List<MyPokemon>{
        val response:List<MyPokemonEntity> = pokemonDao.getAllPokemons()
        return response.map{it.toDomain()}
    }

    suspend fun insertMyPokemon(myPokemon:MyPokemonEntity){
        pokemonDao.insert(myPokemon)
    }
}