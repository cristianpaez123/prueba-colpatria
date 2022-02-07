package com.example.pruebatecnica.presentation.view

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.example.pruebatecnica.databinding.ActivityMainBinding
import com.example.pruebatecnica.presentation.viewmodel.HeroViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: HeroViewModel by viewModel()
    private val getDataHeroState: HeroViewModel by viewModel()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getDataHero()
    }

    fun getDataHero() {
        viewModel.getDataHero()
    }

    private fun setupObserver() {
        getDataHeroState.getDataHeroState().observe(
            this,
            Observer {
                when (it) {
                    is HeroViewModel.GetDataHeroState.Loading -> {
                        showLoading()
                    }
                    is HeroViewModel.GetDataHeroState.DataLoaded -> {
                        hideLoading()
                    }
                    is HeroViewModel.GetDataHeroState.Error -> {
                    }
                }
            }
        )
    }

    fun showLoading() {
        binding.progressLoadingDataHero.setVisibility(View.VISIBLE)
    }

    fun hideLoading() {
        binding.progressLoadingDataHero.setVisibility(View.GONE)
    }

    fun initRecyclerView() {
        binding.recyclerHero.layoutManager = GridLayoutManager(this, 3)

    }
}
