package com.example.pruebatecnica.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.pruebatecnica.R
import com.example.pruebatecnica.data.data.Results
import com.example.pruebatecnica.tools.urlImage
import com.squareup.picasso.Picasso

class HeroAdapter : RecyclerView.Adapter<HeroAdapter.HeroHolder>() {

    var dataHeros: List<Results> = emptyList()
    fun setHero(dataHeros: List<Results>) {
        this.dataHeros = dataHeros
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.adapter_hero, parent, false)
        return HeroHolder(view)
    }

    override fun onBindViewHolder(holder: HeroHolder, position: Int) {
        val hero = dataHeros[position]
        holder.render(hero)
    }

    override fun getItemCount(): Int = dataHeros.size

    class HeroHolder(v: View) : RecyclerView.ViewHolder(v) {

        private var imageHero: ImageView = v.findViewById(R.id.imageHero)

        fun render(heroResults: Results) {
            var image: String =
                heroResults.thumbnail.path + urlImage + heroResults.thumbnail.extension
            val urlImage: String = image.substring(0, 4) + "s" + image.substring(4)
            Picasso.get().load(urlImage).into(this.imageHero)
        }
    }
}
