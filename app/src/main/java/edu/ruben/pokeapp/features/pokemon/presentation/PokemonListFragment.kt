package edu.ruben.pokeapp.features.pokemon.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import edu.ruben.pokeapp.app.extensions.loadUrl
import edu.ruben.pokeapp.databinding.FragmentPokemonListBinding
import edu.ruben.pokeapp.features.pokemon.domain.Pokemon

class PokemonListFragment : Fragment() {
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

        setUpObserver()
        viewModel.loadPokemonList()

    }

    private fun bindData(pokemons: List<Pokemon>) {
        binding.apply {
            pokemonImage1.loadUrl(pokemons[0].imageUrl)
            pokemonName1.text = pokemons[0].name
            pokemonType1.text = pokemons[0].type
            pokemonImage1.setOnClickListener {
                navigateToPokemonDetail(pokemons[0].pokemonId)
            }
        }
    }

    private fun setUpObserver() {
        val observer = Observer<PokemonListViewModel.UiState> { uiState ->
            uiState.pokemonList?.let {
                bindData(it)
            }

            uiState.errorApp?.let {
                println(it)
            } ?: run {

            }

            if (uiState.isLoading) {
                //Muestro cargando
            } else {
                //Oculto cargando
            }
        }
        viewModel.uiState.observe(viewLifecycleOwner, observer)
    }

    private fun navigateToPokemonDetail(pokemonId: String) {
        findNavController().navigate(
            PokemonListFragmentDirections.actionFromPokemonListToPokemonDetail(
                pokemonId
            )
        )
    }
}