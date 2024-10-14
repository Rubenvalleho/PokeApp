package edu.ruben.pokeapp.features.pokemon.data

import edu.ruben.pokeapp.features.pokemon.data.local.PokemonXmlLocalDataSource
import edu.ruben.pokeapp.features.pokemon.data.remote.PokemonMockRemoteDataSource
import edu.ruben.pokeapp.features.pokemon.domain.Pokemon
import edu.ruben.pokeapp.features.pokemon.domain.PokemonRepository

class PokemonDataRepository(
    private val remote: PokemonMockRemoteDataSource,
    private val local: PokemonXmlLocalDataSource
) : PokemonRepository {

    override fun getPokemonList(): List<Pokemon> {
        val pokemonsFromLocal = local.getPokemonList()
        if (pokemonsFromLocal.isEmpty()) {
            val pokemonsFromRemote = remote.getPokemonList()
            local.saveAllPokemon(pokemonsFromRemote)
            return pokemonsFromRemote
        } else {
            return pokemonsFromLocal
        }
    }

    override fun getPokemonById(id: String): Pokemon? {
        val pokemonFromLocal = local.getPokemonById(id)
        if (pokemonFromLocal == null) {
            val pokemonFromRemote = remote.getPokemonById(id)
            pokemonFromRemote?.let {
                local.savePokemon(it)
                return it
            }
        }
        return pokemonFromLocal
    }
}