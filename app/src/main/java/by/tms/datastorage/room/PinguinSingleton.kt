package by.tms.datastorage.room

import android.content.Context
import androidx.room.Room
import by.tms.datastorage.room.database.PinguinDatabase


class PinguinSingleton(context: Context) {
    val database by lazy {
        Room.databaseBuilder(context,
            PinguinDatabase::class.java,
            "pinguin-database").build()
    }

    companion object {
        fun getInstance(context: Context) = PinguinSingleton(context)
    }

}