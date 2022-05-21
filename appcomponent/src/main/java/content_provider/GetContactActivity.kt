package content_provider

import android.database.Cursor
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import androidx.annotation.RequiresApi
import com.krossmanzs.appcomponent.R

// Learn it from https://www.youtube.com/watch?v=nld7_twh9cA

class GetContactActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_get_contact)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onResume() {
        super.onResume()
        getContacts()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun getContacts() {
        val cursor = contentResolver.query(
            ContactsContract.Contacts.CONTENT_URI,
            null,
            null,
            null
        ) as Cursor
        if(cursor.moveToFirst()) {
            do {
                cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME).also {
                    if (it >= 0) {
                        val name = cursor.getString(it)
                        Log.d("ContactsLog", name)
                    }
                }
            } while (cursor.moveToNext())
            cursor.close()
        }
    }
}