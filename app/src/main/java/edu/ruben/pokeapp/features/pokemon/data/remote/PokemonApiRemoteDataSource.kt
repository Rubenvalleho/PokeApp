package edu.ruben.pokeapp.features.pokemon.data.remote

import edu.ruben.pokeapp.features.pokemon.data.PokemonDataSource
import edu.ruben.pokeapp.features.pokemon.domain.Pokemon

class PokemonApiRemoteDataSource(private val pokemonService: PokemonService) : PokemonDataSource {

    override suspend fun getPokemonList(): List<Pokemon> {
        val response = pokemonService.requestPokemonList()
        if (response.isSuccessful) {
            return response.body()!!
        } else {
            return emptyList()
        }
    }

    override suspend fun getPokemonByName(name: String): Pokemon {
        return pokemonService.requestPokemonByName(name)
    }
}