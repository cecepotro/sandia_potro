package mx.itson.sandia.adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import mx.itson.sandia.R
import mx.itson.sandia.entities.Contact

class ContactAdapter(context: Context?, contacts : List<Contact>)
    : BaseAdapter() {
        var context : Context? = context
        var contactsList : List<Contact> = contacts
    override fun getCount(): Int {
        return contactsList.size
    }

    override fun getItem(i: Int): Any {
        return contactsList[i]
    }

    override fun getItemId(p0: Int): Long {
        return 0
    }

    override fun getView(i: Int, view: View?, viewGroup: ViewGroup?): View? {
        var element = LayoutInflater.from(context).inflate(R.layout.item_contact, null)
        try{
            val contact = getItem(i) as Contact

            val txtName : TextView = element.findViewById(R.id.text_name)
            txtName.text = contact.name

            val txtPhone: TextView = element.findViewById(R.id.text_phone)
            txtPhone.text = contact.phone

            val txtEmail : TextView = element.findViewById(R.id.text_email)
            txtEmail.text = contact.email

        }catch(ex: Exception){
            Log.e("Error", ex.message.toString())
        }
        return element
    }
}