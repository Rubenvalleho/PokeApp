package edu.ruben.pokeapp.app.data

import edu.ruben.pokeapp.features.pokemon.data.remote.PokemonService
import edu.ruben.pokeapp.features.pokemon.domain.Pokemon
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

    private const val BASE_URL_API = "https://pokeapi.co/api/v2/"

    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL_API)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun providePokemonService(): PokemonService {
        return provideRetrofit().create(PokemonService::class.java)
    }
}