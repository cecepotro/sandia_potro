package mx.itson.sandia.entities

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.util.Log
import mx.itson.sandia.persistence.SandiaDB

class Contact {

    var id = 0
    var name : String? = null
    var phone : String? = null
    var email : String? = null

    constructor()

    constructor(id: Int, name: String, phone: String, email: String){
        this.id = id
        this.name = name
        this.phone = phone
        this.email = email
    }

    fun get(context: Context) : List<Contact> {
        var contacts : MutableList<Contact> = ArrayList()
        try {
            val sandiaDB = SandiaDB(context, "SandiaDB", null, 1)
            val dataBase: SQLiteDatabase = sandiaDB.readableDatabase

            val resultSet = dataBase.rawQuery("SELECT id, name,phone, email FROM Contacts", null)
            while(resultSet.moveToNext()){
                val contact = Contact(resultSet.getInt(0), resultSet.getString(1),
                    resultSet.getString(2), resultSet.getString(3))
                contacts.add(contact)
            }
        } catch (ex: Exception) {
            Log.e("Error saving Contact", ex.message.toString())
        }
        return contacts
    }
    fun save(context: Context, name: String, phone: String, email: String) {
        try {
            val sandiaDB = SandiaDB(context, "SandiaDB", null, 1)
            val dataBase: SQLiteDatabase = sandiaDB.writableDatabase
            val values = ContentValues()

            values.put("name", name)
            values.put("phone", phone)
            values.put("email", email)

            dataBase.insert("Contacts", null, values)
        } catch (ex: Exception) {
            Log.e("Error saving Contact", ex.message.toString())
        }
    }

    fun update(context: Context, id: Int, name: String, phone: String, email: String) {
        try {
            val sandiaDB = SandiaDB(context, "SandiaDB", null, 1)
            val dataBase: SQLiteDatabase = sandiaDB.writableDatabase
            val values = ContentValues()

            values.put("name", name)
            values.put("phone", phone)
            values.put("email", email)

            dataBase.update("Contacts", values, "id = ?", arrayOf(id.toString()))
        } catch (ex: Exception) {
            Log.e("Error updating Contact", ex.message.toString())
        }
    }

    fun delete(context: Context, id: Int) {
        try {
            val sandiaDB = SandiaDB(context, "SandiaDB", null, 1)
            val dataBase: SQLiteDatabase = sandiaDB.writableDatabase
            dataBase.delete("Contacts", "id = ?", arrayOf(id.toString()))

        } catch (ex: Exception) {
            Log.e("Error deleting Contact", ex.message.toString())
        }
    }
}