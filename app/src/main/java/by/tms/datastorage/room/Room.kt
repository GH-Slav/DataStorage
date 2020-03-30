package by.tms.datastorage.room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import by.tms.datastorage.R
import by.tms.datastorage.room.database.Pinguin
import kotlinx.android.synthetic.main.activity_room.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class Room : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room)

        writeBtn.setOnClickListener(this)
        readBtn.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        val database = PinguinSingleton.getInstance(this).database
        when (v?.id) {
            writeBtn.id -> {
                CoroutineScope(Dispatchers.IO).launch {
                    database.getPinguinDao().addPinguin(
                        Pinguin(editText.text.toString().toInt(),
                        "Vasya", 36)
                    )

                    withContext(Dispatchers.Main) {
                        editText.text.clear()
                    }
                }
            }
            readBtn.id -> {
                CoroutineScope(Dispatchers.IO).launch {
                    val allPinguins = database.getPinguinDao().getAllPinguins()
                    withContext(Dispatchers.Main) {
                        dataTextView.text = allPinguins.toString()
                    }
                }
                editText.text.clear()
            }
        }
    }
}


