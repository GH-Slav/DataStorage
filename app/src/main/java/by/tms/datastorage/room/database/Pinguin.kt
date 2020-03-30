package by.tms.datastorage.room.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Pinguin(
    @PrimaryKey val id: Int,
    val name: String,
    val age: Int
)