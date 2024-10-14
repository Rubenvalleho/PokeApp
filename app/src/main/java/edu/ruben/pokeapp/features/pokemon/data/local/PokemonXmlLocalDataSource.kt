package edu.ruben.pokeapp.features.pokemon.data.local

import android.content.Context
import com.google.gson.Gson
import edu.ruben.pokeapp.features.pokemon.data.PokemonDataSource
import edu.ruben.pokeapp.features.pokemon.domain.Pokemon

class PokemonXmlLocalDataSource(private val context: Context) : PokemonDataSource {

    private val sharedPreferences = context.getSharedPreferences("pokemon", Context.MODE_PRIVATE)

    private val gson = Gson()

    override fun getPokemonList(): List<Pokemon> {
        val pokemons = mutableListOf<Pokemon>()
        val mapPokemon = sharedPreferences.all
        mapPokemon.values.forEach {
            val pokemon = gson.fromJson(it as String, Pokemon::class.java)
            pokemons.add(pokemon)
        }
        return pokemons
    }

    override fun getPokemonById(id: String): Pokemon? {
        return sharedPreferences.getString(id, null)?.let { pokemon ->
            gson.fromJson(pokemon, Pokemon::class.java)
        }
    }

    fun saveAllPokemon(pokemons: List<Pokemon>) {
        pokemons.forEach { pokemon ->
            val pokemonJson = gson.toJson(pokemon)
            sharedPreferences.edit().putString(pokemon.id, pokemonJson).apply()
        }
    }

    fun savePokemon(pokemon: Pokemon) {
        val pokemonJson = gson.toJson(pokemon)
        sharedPreferences.edit().putString(pokemon.id, pokemonJson).apply()
    }

    fun deletePokemon(pokemon: Pokemon) {
        sharedPreferences.edit().remove(pokemon.id).apply()
    }

    fun deleteAll() {
        sharedPreferences.edit().clear().apply()
    }

}