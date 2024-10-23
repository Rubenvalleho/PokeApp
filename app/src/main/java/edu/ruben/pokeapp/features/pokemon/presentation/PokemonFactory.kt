package edu.ruben.pokeapp.features.pokemon.presentation

import android.content.Context
import edu.ruben.pokeapp.app.data.ApiClient
import edu.ruben.pokeapp.features.pokemon.data.PokemonDataRepository
import edu.ruben.pokeapp.features.pokemon.data.local.PokemonXmlLocalDataSource
import edu.ruben.pokeapp.features.pokemon.data.remote.PokemonApiRemoteDataSource
//import edu.ruben.pokeapp.features.pokemon.data.remote.PokemonMockRemoteDataSource
import edu.ruben.pokeapp.features.pokemon.domain.GetPokemonListUseCase
import edu.ruben.pokeapp.features.pokemon.domain.GetPokemonUseCase

class PokemonFactory(private val context: Context) {

    private val pokemonApiRemoteDataSource = getPokemonApiRemoteDataSource()
    private val pokemonXmlLocalDataSource = PokemonXmlLocalDataSource(context)
    //private val pokemonMockRemoteDataSource = PokemonMockRemoteDataSource()
    private val pokemonDataRepository =
        PokemonDataRepository(pokemonApiRemoteDataSource, pokemonXmlLocalDataSource)
    private val getPokemonListUseCase = GetPokemonListUseCase(pokemonDataRepository)
    private val getPokemonUseCase = GetPokemonUseCase(pokemonDataRepository)

    fun getPokemonListViewModel() = PokemonListViewModel(getPokemonListUseCase)

    fun getPokemonDetailViewModel() = PokemonDetailViewModel(getPokemonUseCase)

    private fun getPokemonApiRemoteDataSource(): PokemonApiRemoteDataSource {
        val pokemonService = ApiClient.providePokemonService()
        return PokemonApiRemoteDataSource(pokemonService)
    }
}