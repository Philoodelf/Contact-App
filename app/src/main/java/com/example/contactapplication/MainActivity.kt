package com.example.contactapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    lateinit var contactdata: ArrayList<contact>
    lateinit var adapter: contactadapter
    lateinit var editname: EditText
    lateinit var editphone: EditText
    lateinit var savebutton: Button
    lateinit var editdescription: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        editname = findViewById(R.id.editnameText)
        editphone = findViewById(R.id.editTextPhone)
        savebutton = findViewById(R.id.savebutton)
        editdescription=findViewById(R.id.descriptionedit)
        recyclerView = findViewById(R.id.recyclercontant)
        inisialize()
        adapter = contactadapter(contactdata)
        recyclerView.adapter = adapter

        adapter.onContactClick = object : onContactClick{
            override fun contactclick(contact: contact, position: Int) {
               val intent= Intent(this@MainActivity,contact_Details::class.java)
                intent.putExtra("name",contact.name)
                intent.putExtra("phone",contact.phonenum)
                intent.putExtra("description",contact.description)
                intent.putExtra("image",contact.image)
                startActivity(intent)
            }

        }




        savebutton.setOnClickListener {
            val name = editname.text.toString()
            val phone = editphone.text.toString()
            val descr = editdescription.text.toString()
            if (name.isNotEmpty() && phone.isNotEmpty()) {
                val cont = contact(name, phone,descr)
                contactdata.add(cont)
                adapter.notifyDataSetChanged()
                editname.setText("")
                editphone.setText("")
                editdescription.setText("")




            } else {
                Toast.makeText(this@MainActivity, "Please enter name and phone number", Toast.LENGTH_LONG).show()

            }
        }
    }

    fun inisialize() {
        contactdata = ArrayList()
//        contactdata.add(contact("name","phonenum",R.drawable.ic_launcher_foreground))
//        contactdata.add(contact("name","phone",R.drawable.ic_launcher_foreground))
//        contactdata.add(contact("name","phone",R.drawable.ic_launcher_foreground))
    }
}