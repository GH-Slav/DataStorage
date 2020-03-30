package by.tms.datastorage.room.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database( entities = arrayOf(Pinguin::class), version = 1 )
abstract class PinguinDatabase: RoomDatabase() {
    abstract fun getPinguinDao(): PinguinDao
}