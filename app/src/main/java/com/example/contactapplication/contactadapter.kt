package com.example.contactapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class contactadapter(val contact:ArrayList<contact>) :RecyclerView.Adapter<contactadapter.contactviewholder>(){

    var onContactClick:onContactClick?=null

    class contactviewholder(val view: View ): ViewHolder(view){
        val contactprofile: ImageView= view.findViewById(R.id.imagerecycler)
        val contactname: TextView= view.findViewById(R.id.namerecycler)
        val contactphone: TextView= view.findViewById(R.id.phoneRecycler)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): contactviewholder {
        val layoutInflater =LayoutInflater.from(parent.context)
        val view= layoutInflater.inflate(R.layout.activity_recycler,parent,false)
        return contactviewholder(view)
    }

    override fun getItemCount(): Int {
       return contact.size
    }

    override fun onBindViewHolder(holder: contactviewholder, position: Int) {
        val contct = contact.get(position)
        holder.contactname.setText(contct.name)
        holder.contactphone.setText(contct.phonenum)
        holder.contactprofile.setImageResource(contact.get(position).image ?: R.drawable.shadowprofile)
        holder.view.setOnClickListener{
            onContactClick?.contactclick(contct,position)
        }
    }


}