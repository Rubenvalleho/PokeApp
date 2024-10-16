package edu.ruben.pokeapp.features.pokemon.presentation

import android.view.View
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import edu.ruben.pokeapp.app.extensions.loadUrl
import edu.ruben.pokeapp.databinding.ViewPokemonItemBinding
import edu.ruben.pokeapp.features.pokemon.domain.Pokemon

class PokemonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private lateinit var binding: ViewPokemonItemBinding

    fun bindData(pokemon: Pokemon) {
        binding = ViewPokemonItemBinding.bind(itemView)

        binding.apply {
            pokemonImage.loadUrl(pokemon.imageUrl)
            pokemonName.text = pokemon.name
            pokemonType.text = pokemon.type
        }
    }
}