package edu.ruben.pokeapp.features.pokemon.domain

interface PokemonRepository {
    suspend fun getPokemonList(): List<Pokemon>
    suspend fun getPokemonByName(name: String): Pokemon?
}