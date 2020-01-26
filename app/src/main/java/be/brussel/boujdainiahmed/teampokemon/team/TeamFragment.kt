package be.brussel.boujdainiahmed.teampokemon.team


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import be.brussel.boujdainiahmed.teampokemon.databinding.FragmentTeamBinding


class TeamFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        @Suppress("UNUSED_VARIABLE")
        val application = requireNotNull(activity).application
        val binding = FragmentTeamBinding.inflate(inflater)

        binding.setLifecycleOwner(this)


        /*val pokemon = TeamFragmentArgs.fromBundle(arguments!!).selectedPokemon


        //val viewModelFactory = TeamViewModelFactory(pokemon, application)

        binding.teamViewModel = ViewModelProviders.of(
            this, viewModelFactory).get(TeamViewModel::class.java)*/


        return binding.root

    }


}
