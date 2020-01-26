package be.brussel.boujdainiahmed.teampokemon.pokeList


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import be.brussel.boujdainiahmed.teampokemon.R
import be.brussel.boujdainiahmed.teampokemon.databinding.FragmentPokemonListBinding
import be.brussel.boujdainiahmed.teampokemon.databinding.GridViewItemBinding


class PokemonListFragment : Fragment() {

    //private lateinit var viewModel: PokeViewModel
    //private lateinit var binding: FragmentPokemonListBinding

    private val viewModel: PokeViewModel by lazy {
        ViewModelProviders.of(this).get(PokeViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        /*  binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_pokemon_list,
            container,
            false
        )*/

        val binding = FragmentPokemonListBinding.inflate(
            inflater
        )

        //viewModel = ViewModelProviders.of(this).get(PokeViewModel::class.java)

        binding.lifecycleOwner = this

        binding.pokeviewModel = viewModel



        binding.photosGrid.adapter = PhotoPokemonAdapter(PhotoPokemonAdapter.OnClickListener {
            viewModel.displayPokemonTeam(it)
        })

        /*viewModel.navigateToSelectedPokemon.observe(this, Observer {
            if ( null != it) {
                this.findNavController().navigate(PokemonListFragmentDirections.actionPokemonListFragmentToTeamFragment(it))
                viewModel.displayPokemonTeamComplete()
            }
        })*/

        setHasOptionsMenu(true)
        return binding.root
    }
}








/*class PokemonListFragment : Fragment() {

    private lateinit var PokeViewModel : PokeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        PokeViewModel = ViewModelProviders.of(this).get(PokeViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_pokemon_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        PokeViewModel.getListPokemon().observe(viewLifecycleOwner, Observer {
            val pokemons: List<Pokemon> = it
            recyclerView.adapter = PokeAdapterFragment(pokemons, view.context)
            if (pokemons.isNotEmpty())
                progressBar.visibility = View.GONE
        })



 */