package com.example.pruebatecnica.presentation.view

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.pruebatecnica.databinding.ActivityMainBinding
import com.example.pruebatecnica.presentation.adapter.HeroAdapter
import com.example.pruebatecnica.presentation.viewmodel.HeroViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: HeroViewModel by viewModel()
    private val getDataHeroState: HeroViewModel by viewModel()
    private lateinit var binding: ActivityMainBinding

    private var heroAdapter: HeroAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerView()
        setupObserver()
        getDataHero()
    }

    fun getDataHero() {
        viewModel.getDataHero()
    }

    private fun setupObserver() {
        getDataHeroState.getDataHeroState().observe(
            this,
            { state ->
                when (state) {
                    is HeroViewModel.GetDataHeroState.Loading -> {
                        showLoading()
                    }
                    is HeroViewModel.GetDataHeroState.DataLoaded -> {
                        hideLoading()
                        heroAdapter?.setHero(state.heroResponseResult)
                    }
                    is HeroViewModel.GetDataHeroState.Error -> {
                        state.message
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
        heroAdapter = HeroAdapter()

        with(binding.recyclerHero) {
            layoutManager = GridLayoutManager(this@MainActivity, 3)
            adapter = heroAdapter
        }
    }
}
