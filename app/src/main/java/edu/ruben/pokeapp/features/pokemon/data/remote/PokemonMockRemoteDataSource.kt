package edu.ruben.pokeapp.features.pokemon.data.remote

import edu.ruben.pokeapp.features.pokemon.data.PokemonDataSource
import edu.ruben.pokeapp.features.pokemon.domain.Pokemon

class PokemonMockRemoteDataSource: PokemonDataSource {

    private val pokemonList = listOf(
        Pokemon("1", "Bulbasaur", "Grass", "https://www.pokemon.com/static-assets/content-assets/cms2/img/pokedex/full/001.png"),
        Pokemon("2", "Ivysaur", "Grass", "https://www.pokemon.com/static-assets/content-assets/cms2/img/pokedex/full/002.png"),
        Pokemon("3", "Venusaur", "Grass", "https://www.pokemon.com/static-assets/content-assets/cms2/img/pokedex/full/003.png"),
        Pokemon("4", "Charmander", "Fire", "https://www.pokemon.com/static-assets/content-assets/cms2/img/pokedex/full/004.png"),
        Pokemon("5", "Charmeleon", "Fire", "https://www.pokemon.com/static-assets/content-assets/cms2/img/pokedex/full/005.png"),
        Pokemon("6", "Charizard", "Fire", "https://www.pokemon.com/static-assets/content-assets/cms2/img/pokedex/full/006.png")
    )

    override fun getPokemonList(): List<Pokemon> {
        return pokemonList
    }

    override fun getPokemonById(id: String): Pokemon? {
        return pokemonList.find {it.pokemonId == id}
    }
}