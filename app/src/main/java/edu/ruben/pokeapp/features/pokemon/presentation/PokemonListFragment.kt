package edu.ruben.pokeapp.features.pokemon.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import edu.ruben.pokeapp.databinding.FragmentPokemonListBinding
import edu.ruben.pokeapp.features.pokemon.domain.Pokemon

class PokemonListFragment: Fragment() {
    private lateinit var pokemonFactory: PokemonFactory
    private lateinit var viewModel: PokemonListViewModel

    private var _binding: FragmentPokemonListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPokemonListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        pokemonFactory = PokemonFactory(requireContext())
        viewModel = pokemonFactory.getPokemonListViewModel()


    }

    private fun bindData(pokemons: List<Pokemon>) {
        TODO("Not yet implemented")
    }

    private fun setUpObserver() {
        TODO("Not yet implemented")
    }

    private fun navigateToPokemonDetail(pokemonId: String) {
        TODO("Not yet implemented")

    }
}