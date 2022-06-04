package com.turin.poketinder.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.turin.poketinder.domain.usecase.GetMyPokemonDetailUseCase
import com.turin.poketinder.domain.usecase.GetPokemonsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokemonDetailViewModel@Inject constructor(
    private val getMyPokemonDetailUseCase: GetMyPokemonDetailUseCase
): ViewModel(){
    fun onCreate(){
        viewModelScope.launch{
            val result=getMyPokemonDetailUseCase()
        }
    }
}