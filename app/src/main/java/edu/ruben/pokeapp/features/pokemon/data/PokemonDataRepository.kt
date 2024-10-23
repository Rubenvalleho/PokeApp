package edu.ruben.pokeapp.features.pokemon.data

import edu.ruben.pokeapp.features.pokemon.data.local.PokemonXmlLocalDataSource
import edu.ruben.pokeapp.features.pokemon.data.remote.PokemonApiRemoteDataSource
import edu.ruben.pokeapp.features.pokemon.domain.Pokemon
import edu.ruben.pokeapp.features.pokemon.domain.PokemonRepository

class PokemonDataRepository(
    private val remote: PokemonApiRemoteDataSource,
    private val local: PokemonXmlLocalDataSource
) : PokemonRepository {

    override suspend fun getPokemonList(): List<Pokemon> {
        val pokemonsFromLocal = local.getPokemonList()
        if (pokemonsFromLocal.isEmpty()) {
            val pokemonsFromRemote = remote.getPokemonList()
            local.saveAllPokemon(pokemonsFromRemote)
            return pokemonsFromRemote
        } else {
            return pokemonsFromLocal
        }
    }

    override suspend fun getPokemonByName(name: String): Pokemon? {
        val pokemonFromLocal = local.getPokemonByName(name)
        if (pokemonFromLocal == null) {
            val pokemonFromRemote = remote.getPokemonByName(name)
            pokemonFromRemote?.let {
                local.savePokemon(it)
                return it
            }
        }
        return pokemonFromLocal
    }
}