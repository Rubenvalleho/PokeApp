package edu.ruben.pokeapp.features.pokemon.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import edu.ruben.pokeapp.R
import edu.ruben.pokeapp.features.pokemon.domain.Pokemon

class PokemonAdapter(private val onPokemonClicked: (Pokemon) -> Unit) :
    RecyclerView.Adapter<PokemonViewHolder>() {

    private val dataList: MutableList<Pokemon> = mutableListOf()

    fun setDataList(pokemonList: List<Pokemon>) {
        dataList.clear()
        addDataList(pokemonList)
    }

    private fun addDataList(pokemonList: List<Pokemon>) {
        dataList.addAll(pokemonList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.view_pokemon_item, parent, false)
        return PokemonViewHolder(view)
    }

    override fun getItemCount(): Int = dataList.size

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        holder.bindData(dataList[position])

        holder.itemView.setOnClickListener {
            onPokemonClicked(dataList[position])
        }
    }
}