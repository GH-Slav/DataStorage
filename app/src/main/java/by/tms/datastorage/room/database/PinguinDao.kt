package by.tms.datastorage.room.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface PinguinDao {

    @Insert
    suspend fun addPinguin(pinguin: Pinguin)

    @Query("SELECT * FROM Pinguin")
    suspend fun getAllPinguins(): List<Pinguin>

    @Query("SELECT * FROM Pinguin WHERE name = :name")
    suspend fun getAllPinguinsByName(name: String): List<Pinguin>
}