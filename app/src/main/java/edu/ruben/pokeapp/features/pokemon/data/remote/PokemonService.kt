package edu.ruben.pokeapp.features.pokemon.data.remote

import edu.ruben.pokeapp.features.pokemon.domain.Pokemon
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonService {

    @GET("pokemon/ditto")
    suspend fun requestPokemonList(): Response<List<Pokemon>>

    @GET("pokemon/{name}")
    suspend fun requestPokemonByName(@Path("name") name: String): Pokemon

}