package be.brussel.boujdainiahmed.teampokemon.home


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import be.brussel.boujdainiahmed.teampokemon.R
import be.brussel.boujdainiahmed.teampokemon.databinding.FragmentEnterGameBinding


class EnterGameFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: FragmentEnterGameBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_enter_game, container, false
        )

        binding.Start.setOnClickListener { view: View ->
            Navigation.findNavController(view)
                .navigate(R.id.action_enterGameFragment_to_pokemonListFragment)
        }
        return binding.root

    }
}
