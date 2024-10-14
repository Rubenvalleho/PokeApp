package edu.ruben.pokeapp.features.pokemon.domain

class GetPokemonUseCase(private val pokemonRepository: PokemonRepository) {

    operator fun invoke(id: String): Pokemon? {
        return pokemonRepository.getPokemonById(id)
    }

}