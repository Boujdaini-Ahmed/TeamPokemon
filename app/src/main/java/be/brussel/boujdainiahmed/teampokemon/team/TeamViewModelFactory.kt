package be.brussel.boujdainiahmed.teampokemon.team

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import be.brussel.boujdainiahmed.teampokemon.pokeList.Pokemon

class TeamViewModelFactory (

    private val pokemon: Pokemon,
    private val application: Application): ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if ( modelClass.isAssignableFrom(TeamViewModel::class.java)) {
            return  TeamViewModel(pokemon,application) as T
        }
        throw  IllegalArgumentException("Unknown ViewModel Class")
    }

}
