package be.brussel.boujdainiahmed.teampokemon.pokeList

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import be.brussel.boujdainiahmed.teampokemon.pokeAPI.DexApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.lang.Exception


class PokeViewModel : ViewModel() {

    //private val _response = MutableLiveData<String>()

    private val _status = MutableLiveData<String>()

    val status: LiveData<String>
        get() = _status

     private val _pokemons = MutableLiveData<List<Pokemon>>()

    val pokemons: LiveData<List<Pokemon>>
        get() = _pokemons

    private val _navigateToSelectedPokemon = MutableLiveData<Pokemon>()

    val navigateToSelectedPokemon: LiveData<Pokemon>
        get() = _navigateToSelectedPokemon



    private var viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    init {
        getPokemons()
        //_status.value = "test"
    }


        private fun getPokemons() {
            coroutineScope.launch {

                var getPokemonDeferred = DexApi.retrofitService.getPokemon()
                try {
                    var listResult = getPokemonDeferred.await()
                    _status.value = "Succes: ${listResult.size} Pokemon properties retrieved"
                    if (listResult.size > 0) {
                        _pokemons.value = listResult
                    }
                } catch (e: Exception) {
                    _status.value = "Failure: ${e.message}"
                }

            }
        }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

    fun displayPokemonTeam(pokemon: Pokemon) {
        _navigateToSelectedPokemon.value = pokemon
    }

    fun displayPokemonTeamComplete() {
        _navigateToSelectedPokemon.value = null
    }
}






/*class PokeViewModel : ViewModel() {

    private val pokemonDAO: PokemonDAO = App.database.PokemonDAO()

    init {
        initNetworkRequest()
    }

    private fun initNetworkRequest() {
        val call = API.pokemonService.get()
        call.enqueue(object : Callback<List<Pokemon>?> {
            override fun onResponse(
                call: Call<List<Pokemon>?>?,
                response: Response<List<Pokemon>?>?
            ) {
                response?.body()?.let { pokemons: List<Pokemon> ->
                    thread {
                        pokemonDAO.add(pokemons)
                    }
                }
            }

            override fun onFailure(call: Call<List<Pokemon>?>?, t: Throwable?) {
                // TODO handle failure
            }
        })

    }

    fun getListPokemon(): LiveData<List<Pokemon>> {
        return pokemonDAO.all()
    }

}
}
 */