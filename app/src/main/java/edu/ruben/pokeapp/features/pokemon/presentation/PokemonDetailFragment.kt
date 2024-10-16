package edu.ruben.pokeapp.features.pokemon.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import edu.ruben.pokeapp.app.extensions.loadUrl
import edu.ruben.pokeapp.databinding.FragmentPokemonDetailBinding
import edu.ruben.pokeapp.features.pokemon.domain.Pokemon

class PokemonDetailFragment : Fragment() {

    private lateinit var pokemonFactory: PokemonFactory
    private lateinit var viewModel: PokemonDetailViewModel

    private var _binding: FragmentPokemonDetailBinding? = null
    private val binding get() = _binding!!

    private val pokemonArgs: PokemonDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPokemonDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        pokemonFactory = PokemonFactory(requireContext())
        viewModel = pokemonFactory.getPokemonDetailViewModel()
        val pokemonId = pokemonArgs.pokemonId
        setUpObserver()

        viewModel.loadPokemon(pokemonId)

    }

    private fun setUpObserver() {
        val pokemonObserver = Observer<PokemonDetailViewModel.UiState> { uiState ->
            uiState.pokemon?.let {
                bindData(it)
            }
        }
        viewModel.uiState.observe(viewLifecycleOwner, pokemonObserver)
    }

    private fun bindData(pokemon: Pokemon) {
        binding.apply {
            pokemonImage.loadUrl(pokemon.imageUrl)
            pokemonName.text = pokemon.name
        }
    }
}