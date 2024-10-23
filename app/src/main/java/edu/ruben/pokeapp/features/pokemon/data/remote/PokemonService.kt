package edu.ruben.pokeapp.features.pokemon.data.remote

import edu.ruben.pokeapp.features.pokemon.domain.Pokemon
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonService {

    @GET("all.json")
    suspend fun requestPokemonList(): Response<List<Pokemon>>

    @GET("")
    suspend fun requestPokemonByName(@Path("id") name: String): Pokemon

}