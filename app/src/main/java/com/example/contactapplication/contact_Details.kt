package com.example.contactapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class contact_Details : AppCompatActivity() {

    lateinit var image:ImageView
    lateinit var name: TextView
    lateinit var phone: TextView
    lateinit var description: TextView
    lateinit var back :Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_details)

        image=findViewById(R.id.profile_details)
        name=findViewById(R.id.Name_details)
        phone=findViewById(R.id.phone_details)
        description=findViewById(R.id.desc_details)
        back=findViewById(R.id.back_button)
        name.text= intent?.getStringExtra("name")
       phone.text= intent?.getStringExtra("phone")
       description.text= intent?.getStringExtra("description")
        image.setImageResource(intent?.getIntExtra("image",R.drawable.shadowprofile)!!)

    back.setOnClickListener{
        finish()
    }
    }
}