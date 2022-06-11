package com.turin.poketinder.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.turin.poketinder.data.model.PokemonDetailModel
import com.turin.poketinder.domain.model.Pokemon
import com.turin.poketinder.domain.model.PokemonDetail
import com.turin.poketinder.domain.usecase.GetMyPokemonDetailUseCase
import com.turin.poketinder.domain.usecase.GetPokemonsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokemonDetailViewModel@Inject constructor(
    private val getMyPokemonDetailUseCase: GetMyPokemonDetailUseCase
): ViewModel(){
    val pokemonDetailModel= MutableLiveData<PokemonDetailModel>()
    val isLoading = MutableLiveData<Boolean>()
    //val pokemon = MutableLiveData<PokemonDetail>()
    fun onCreate(idPokemon: String){
        viewModelScope.launch{
            isLoading.postValue(true)
            val result=getMyPokemonDetailUseCase.invoke(idPokemon)
            pokemonDetailModel.postValue(result)
            isLoading.postValue(false)
        }
    }
}