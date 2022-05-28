package com.turin.poketinder.ui.view

import android.app.FragmentTransaction
import android.os.Bundle
import android.view.View
import android.view.animation.AccelerateInterpolator
import android.view.animation.DecelerateInterpolator
import android.view.animation.LinearInterpolator
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DefaultItemAnimator
import com.turin.poketinder.databinding.FragmentHomeBinding
import com.turin.poketinder.domain.model.Pokemon
import com.turin.poketinder.ui.adapter.PokemonAdapter
import com.turin.poketinder.ui.viewmodel.HomeViewModel
import com.turin.poketinder.ui.viewmodel.InfoViewModel

import com.yuyakaido.android.cardstackview.*
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment: BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate),
    CardStackListener,PokemonAdapter.Callback{

        companion object{
            fun newInstance() = HomeFragment()
        }

        private var listPokemon:List<Pokemon> = emptyList()
        //Tiene que ser val no var
        private val mainViewModel: HomeViewModel by viewModels()
        private val manager by lazy {CardStackLayoutManager(context,this)}
        private val adapter by lazy {PokemonAdapter(listPokemon, this)}

    //var infoFragment=InfoFragment()
    //viewFragment.onPause()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initializeTinderCard()
        observeValues()
        mainViewModel.onCreate()

    }

    private fun observeValues(){
        binding.floatingActionButton.setOnClickListener{
            //Rewind
            val setting = RewindAnimationSetting.Builder()
                .setDirection(Direction.Bottom)
                .setDuration(Duration.Normal.duration)
                .setInterpolator(DecelerateInterpolator())
                .build()
            manager.setRewindAnimationSetting(setting)
            binding.rvTinderPokemon.rewind()
        }

        binding.floatingActionButton2.setOnClickListener{
            //Skip
            val setting = SwipeAnimationSetting.Builder()
                .setDirection(Direction.Left)
                .setDuration(Duration.Normal.duration)
                .setInterpolator(AccelerateInterpolator())
                .build()
            manager.setSwipeAnimationSetting(setting)
            binding.rvTinderPokemon.swipe()
        }

        binding.floatingActionButton3.setOnClickListener{
            //like
            val setting = SwipeAnimationSetting.Builder()
                .setDirection(Direction.Right)
                .setDuration(Duration.Normal.duration)
                .setInterpolator(DecelerateInterpolator())
                .build()
            manager.setSwipeAnimationSetting(setting)
            binding.rvTinderPokemon.swipe()
        }

        mainViewModel.isLoading.observe(this){
            binding.progressBar.isVisible = it
        }

        mainViewModel.pokemonList.observe(this){
            adapter.list = it
            adapter.notifyDataSetChanged()
            binding.floatingActionButton.visibility = View.VISIBLE
            binding.floatingActionButton2.visibility = View.VISIBLE
            binding.floatingActionButton3.visibility = View.VISIBLE
        }

    }

    private fun initializeTinderCard() {
        manager.setStackFrom(StackFrom.None)
        manager.setVisibleCount(3)
        manager.setTranslationInterval(8.0f)
        manager.setScaleInterval(0.95f)
        manager.setSwipeThreshold(0.3f)
        manager.setMaxDegree(20.0f)
        manager.setDirections(Direction.HORIZONTAL)
        manager.setCanScrollHorizontal(true)
        manager.setCanScrollVertical(true)
        manager.setSwipeableMethod(SwipeableMethod.AutomaticAndManual)
        manager.setOverlayInterpolator(LinearInterpolator())


        binding.rvTinderPokemon.layoutManager = manager
        binding.rvTinderPokemon.adapter = adapter
        binding.rvTinderPokemon.itemAnimator.apply {
            if (this is DefaultItemAnimator) {
                supportsChangeAnimations = false
            }
        }
    }
        override fun onClickPokemonInformation(pokemon: Pokemon){

        }
        override fun onCardDragging(direction: Direction?, ratio: Float){
        }
        override fun onCardSwiped(direction: Direction?){
        }
        override fun onCardRewound(){
        }
        override fun onCardCanceled(){
        }
        override fun onCardAppeared(view: View?, position: Int){

        }
        override fun onCardDisappeared(view: View?, position: Int){
        }

}