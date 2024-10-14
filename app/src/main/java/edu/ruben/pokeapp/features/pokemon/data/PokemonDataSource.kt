package edu.ruben.pokeapp.features.pokemon.data

import edu.ruben.pokeapp.features.pokemon.domain.Pokemon

interface PokemonDataSource {
    fun getPokemonList(): List<Pokemon>
    fun getPokemonById(id: String): Pokemon?

}