package com.turin.poketinder.ui.view

import android.os.Bundle
import androidx.fragment.app.viewModels
import com.turin.poketinder.databinding.FragmentFavoriteBinding
import com.turin.poketinder.domain.model.MyPokemon
import com.turin.poketinder.ui.adapter.MyPokemonsAdapter
import com.turin.poketinder.ui.viewmodel.FavoriteViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoriteFragment:BaseFragment<FragmentFavoriteBinding>(FragmentFavoriteBinding::inflate) {
    private var listMyPokemon = mutableListOf<MyPokemon>()
    private val adapter by lazy { MyPokemonsAdapter(listMyPokemon)}
    private val viewModel: FavoriteViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        viewModel.onCreate()
        binding.rvPokemons.adapter = adapter

        viewModel.myPokemonList.observe(this){
            //Se agrego esto semana 14
            listMyPokemon.clear()
            listMyPokemon.addAll(it)
            adapter.notifyDataSetChanged()
        }

        binding.floatingActionDelete.setOnClickListener{
            viewModel.deleteAllPokemon()
            listMyPokemon.clear()
            adapter.notifyDataSetChanged()
            //viewModel.onCreate()
        }
/*
        viewModel.isLDeleteAllPokemon.observe(this){
            viewModel.onCreate()
        }
 */
    }
}