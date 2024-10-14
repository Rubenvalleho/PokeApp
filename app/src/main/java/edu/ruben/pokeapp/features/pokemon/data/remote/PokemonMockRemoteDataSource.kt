package edu.ruben.pokeapp.features.pokemon.data.remote

import edu.ruben.pokeapp.features.pokemon.data.PokemonDataSource
import edu.ruben.pokeapp.features.pokemon.domain.Pokemon

class PokemonMockRemoteDataSource: PokemonDataSource {

    private val pokemonList = listOf(
        Pokemon("1", "Bulbasaur", "Grass", ""),
        Pokemon("2", "Ivysaur", "Grass", ""),
        Pokemon("3", "Venusaur", "Grass", ""),
        Pokemon("4", "Charmander", "Fire", ""),
        Pokemon("5", "Charmeleon", "Fire", ""),
        Pokemon("6", "Charizard", "Fire", "")
    )

    override fun getPokemonList(): List<Pokemon> {
        return pokemonList
    }

    override fun getPokemonById(id: String): Pokemon? {
        return pokemonList.find {it.id == id}
    }
}