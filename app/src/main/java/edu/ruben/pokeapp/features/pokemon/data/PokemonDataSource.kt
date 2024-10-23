package edu.ruben.pokeapp.features.pokemon.data

import edu.ruben.pokeapp.features.pokemon.domain.Pokemon

interface PokemonDataSource {
    suspend fun getPokemonList(): List<Pokemon>
    suspend fun getPokemonByName(name: String): Pokemon?

}