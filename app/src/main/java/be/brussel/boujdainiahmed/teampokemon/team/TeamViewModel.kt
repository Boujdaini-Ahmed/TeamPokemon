package be.brussel.boujdainiahmed.teampokemon.team

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import be.brussel.boujdainiahmed.teampokemon.pokeList.Pokemon


class TeamViewModel (pokemon : Pokemon, app: Application): AndroidViewModel(app) {

    private val _selectedPokemon = MutableLiveData<Pokemon>()

    val selectedPokemon : LiveData<Pokemon>
    get() = _selectedPokemon

    init {
        _selectedPokemon.value = pokemon
    }
}