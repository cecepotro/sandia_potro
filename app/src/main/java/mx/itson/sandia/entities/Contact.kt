package mx.itson.sandia.entities

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.util.Log
import mx.itson.sandia.persistence.SandiaDB

class Contact {

    fun save(context: Context, name: String, phone: String, email: String) {
        try {
            val sandiaDB = SandiaDB(context, "SandiaDB", null, 1)
            val dataBase : SQLiteDatabase = sandiaDB.writableDatabase
             val values = ContentValues()

            values.put("name", name)
            values.put("phone", phone)
            values.put("email", email)

            dataBase.insert("Contacts", null, values)
        } catch(ex: Exception){
            Log.e("Error saving Contact", ex.message.toString())
        }
    }

}