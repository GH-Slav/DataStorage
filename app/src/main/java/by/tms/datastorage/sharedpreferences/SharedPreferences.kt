package by.tms.datastorage.sharedpreferences

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import by.tms.datastorage.R
import kotlinx.android.synthetic.main.activity_shared_preferences.*

const val FILE_NAME = "sharedPref"
class SharedPreferences : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_preferences)

        writeBtn.setOnClickListener(this)
        readBtn.setOnClickListener(this)
        clearBtn.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        val storage = getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE)
        when (v?.id) {
            writeBtn.id -> {
                storage.edit().putInt(editText.text.toString(), (0..10).random()).apply()
                editText.text.clear()
            }
            readBtn.id -> {
                val value = storage.getInt(editText.text.toString(), -1)
                dataTextView.text = value.toString()
                editText.text.clear()
            }
            clearBtn.id -> {
                storage.edit().clear().apply()
                editText.text.clear()
            }
        }
    }
}