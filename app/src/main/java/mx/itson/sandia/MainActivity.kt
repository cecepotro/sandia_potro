package mx.itson.sandia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import mx.itson.sandia.entities.Contact

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnContactForm = findViewById<Button>(R.id.button_new_contact)
        btnContactForm.setOnClickListener(this)

        val btnContactList = findViewById<Button>(R.id.button_list_contact)
        btnContactList.setOnClickListener(this)
        //Efectos de prueba
        //Contact().save(this, "Axel", "6221234567", "axel@correo.com")
    }

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.button_new_contact -> {
                val intentFormContact = Intent(this, ContactFormActivity::class.java)
                startActivity(intentFormContact)
            }
            R.id.button_list_contact -> {
                val intentListContact = Intent(this, ContactListActivity::class.java)
                startActivity(intentListContact)
            }
        }
    }
}