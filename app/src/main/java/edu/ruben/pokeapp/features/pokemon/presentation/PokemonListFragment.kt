package edu.ruben.pokeapp.features.pokemon.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import edu.ruben.pokeapp.databinding.FragmentPokemonListBinding
import edu.ruben.pokeapp.features.pokemon.domain.Pokemon

class PokemonListFragment : Fragment() {
    private lateinit var pokemonFactory: PokemonFactory
    private lateinit var viewModel: PokemonListViewModel

    private var _binding: FragmentPokemonListBinding? = null
    private val binding get() = _binding!!

    private val pokemonAdapter = PokemonAdapter {
        navigateToPokemonDetail(it.name)
    }

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

        setUpView()
        setUpObserver()
        viewModel.loadPokemonList()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    /*private fun bindData(pokemons: List<Pokemon>) {
        binding.apply {
            pokemonImage1.loadUrl(pokemons[0].imageUrl)
            pokemonName1.text = pokemons[0].name
            pokemonType1.text = pokemons[0].type
            pokemonImage1.setOnClickListener {
                navigateToPokemonDetail(pokemons[0].pokemonId)
            }
        }
    }*/


    private fun bind(pokemonList: List<Pokemon>) {
        Log.d("PokemonAdapter", "Número de Pokémon: ${pokemonList.size}")
        pokemonAdapter.setDataList(pokemonList)
    }

    private fun setUpView() {
        binding.apply {
            pokemonRecycler.layoutManager = LinearLayoutManager(
                requireContext(),
                LinearLayoutManager.VERTICAL, false
            )
            pokemonRecycler.adapter = pokemonAdapter
        }
    }

    private fun setUpObserver() {
        val observer = Observer<PokemonListViewModel.UiState> { uiState ->
            uiState.pokemonList?.let {
                bind(it)
                Log.d("PokemonAdapter", "Número de Pokémon: ${it.size}")
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

    private fun navigateToPokemonDetail(name: String) {
        findNavController().navigate(
            PokemonListFragmentDirections.actionFromPokemonListToPokemonDetail(
                name
            )
        )
    }
}