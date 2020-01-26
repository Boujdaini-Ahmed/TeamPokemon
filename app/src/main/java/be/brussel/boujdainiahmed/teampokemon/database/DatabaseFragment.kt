package be.brussel.boujdainiahmed.teampokemon.database


import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [FinalTeam::class], version = 1, exportSchema = false)
abstract class DatabaseFragment : RoomDatabase() {

    abstract val pokemonDAO : PokemonDAO


}
