package edu.ruben.pokeapp.features.pokemon.domain

interface PokemonRepository {
    fun getPokemonList(): List<Pokemon>
    fun getPokemonById(id: String): Pokemon?
}