package be.brussel.boujdainiahmed.teampokemon.database


import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface PokemonDAO {

    @Insert
    fun insert (finalteam : FinalTeam)


    @Query("SELECT * FROM final_team_table")
    fun getAll(): LiveData<List<FinalTeam>>?

    @Query("DELETE FROM final_team_table")
    fun deleteAll()


}
