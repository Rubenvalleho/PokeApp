package edu.ruben.pokeapp.features.pokemon.domain

class GetPokemonListUseCase(private val pokemonRepository: PokemonRepository) {
    suspend operator fun invoke(): List<Pokemon> {
        return pokemonRepository.getPokemonList()
    }

}