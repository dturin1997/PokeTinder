package com.turin.poketinder.ui.view

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.turin.poketinder.R
import com.turin.poketinder.databinding.ActivityMainBinding
import com.turin.poketinder.databinding.ActivityPokemonDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PokemonDetailActivity: BaseActivity<ActivityPokemonDetailBinding>(ActivityPokemonDetailBinding::inflate) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_pokemon_detail)

        val pokemonId = intent?.extras?.getString("ID_POKEMON", null)
        if(pokemonId != null){
            Toast.makeText(this,"PokemonId: $pokemonId",Toast.LENGTH_SHORT).show()
        }
        //binding.baseExp=
    }
}