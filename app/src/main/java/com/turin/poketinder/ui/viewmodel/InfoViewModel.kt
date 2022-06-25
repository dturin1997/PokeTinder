package com.turin.poketinder.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.turin.poketinder.data.FirebaseRemoteConfigRepository

class InfoViewModel: ViewModel() {

    private var firebaseRemoteConfigRepository = FirebaseRemoteConfigRepository()

    init{
      firebaseRemoteConfigRepository.init()
    }

    fun getUrlPokemon(): MutableLiveData<String>{
        return firebaseRemoteConfigRepository.getUrlPokemonLiveData
    }
}