package edu.ruben.pokeapp.features.pokemon.domain

class GetPokemonUseCase(private val pokemonRepository: PokemonRepository) {

    suspend operator fun invoke(name: String): Pokemon? {
        return pokemonRepository.getPokemonByName(name)
    }

}