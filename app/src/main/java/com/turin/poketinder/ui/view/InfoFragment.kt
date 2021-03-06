package com.turin.poketinder.ui.view

import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.viewModels
import com.turin.poketinder.databinding.FragmentInfoBinding
import com.turin.poketinder.ui.viewmodel.InfoViewModel

class InfoFragment:BaseFragment<FragmentInfoBinding>(FragmentInfoBinding::inflate) {
    //private lateinit var viewModel: InfoViewModel
    private val viewModel: InfoViewModel by viewModels()

    private lateinit var webview: WebView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        webview =binding.wvMain
        webview.settings.javaScriptEnabled=true
        webview.webViewClient = PokemonWebClient()
        viewModel.getUrlPokemon().observe(viewLifecycleOwner){
            webview.loadUrl(it)
        }

    /*
        val url = "https://pokemongolive.com/es/"
        webview =binding.wvMain
        webview!!.settings.javaScriptEnabled=true
        webview!!.webViewClient = PokemonWebClient()
        webview!!.loadUrl(url)
    */
    }

    inner class PokemonWebClient: WebViewClient(){
        override fun onPageFinished(view: WebView?, url: String?) {
            super.onPageFinished(view, url)
            webview!!.loadUrl("javascript:(function(){"+
                    "document.getElementsByClassName('navbar top')[0].style.display='none';})()");
        }
    }
}