package edu.ruben.pokeapp.features.pokemon.domain

class GetPokemonListUseCase(private val pokemonRepository: PokemonRepository) {
    operator fun invoke(): List<Pokemon> {
        return pokemonRepository.getPokemonList()
    }

}