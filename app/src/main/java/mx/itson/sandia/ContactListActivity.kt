package mx.itson.sandia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import mx.itson.sandia.adapters.ContactAdapter
import mx.itson.sandia.entities.Contact

class ContactListActivity : AppCompatActivity() {

    var listContacts : ListView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_list)

        listContacts = findViewById(R.id.list_contacts)

        loadContacts()
    }

    fun loadContacts(){
        val contacts : List<Contact> = Contact().get(this)
        listContacts?.adapter = ContactAdapter(this, contacts)
    }
}