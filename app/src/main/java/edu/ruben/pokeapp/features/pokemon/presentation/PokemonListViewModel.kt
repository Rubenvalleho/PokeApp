package edu.ruben.pokeapp.features.pokemon.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.ruben.pokeapp.features.pokemon.domain.GetPokemonListUseCase
import edu.ruben.pokeapp.features.pokemon.domain.Pokemon
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PokemonListViewModel(private val getPokemonListUseCase: GetPokemonListUseCase) : ViewModel() {

    private val _pokemonList = MutableLiveData<UiState>()
    val uiState: LiveData<UiState> = _pokemonList

    fun loadPokemonList() {
        viewModelScope.launch(Dispatchers.IO) {
            val pokemonList = getPokemonListUseCase.invoke()
            _pokemonList.postValue(UiState(pokemonList = pokemonList))
        }
    }

    data class UiState(
        val isLoading: Boolean = false,
        val pokemonList: List<Pokemon>? = null,
        val error: String? = null
    )

}