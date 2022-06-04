package com.turin.poketinder.ui.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.turin.poketinder.R
import com.turin.poketinder.databinding.ItemPokemonBinding
import com.turin.poketinder.databinding.ItemPokemonSavedBinding
import com.turin.poketinder.domain.model.MyPokemon
import com.turin.poketinder.ui.holder.MyPokemonsHolder
import com.turin.poketinder.util.formatNumberTo3Digits
import com.turin.poketinder.util.inflate

class MyPokemonsAdapter(val list: List<MyPokemon>):
    RecyclerView.Adapter<MyPokemonsHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyPokemonsHolder {
        val view = parent.inflate(R.layout.item_pokemon_saved)
        return MyPokemonsHolder(view)
    }

    override fun onBindViewHolder(holder: MyPokemonsHolder, position: Int) {
        val item =list[position]
        holder.bind(item)
    }

    override fun getItemCount():Int = list.size


    }
