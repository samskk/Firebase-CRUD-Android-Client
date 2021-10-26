package com.example.myapplication.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.data.Contact
import com.example.myapplication.databinding.RecyclerViewContactBinding

class ContactAdapter: RecyclerView.Adapter<ContactAdapter.ViewHolder>() {

    var contacts = mutableListOf<Contact>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(RecyclerViewContactBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return contacts.size
    }
    inner class ViewHolder(val binding: RecyclerViewContactBinding): RecyclerView.ViewHolder(binding.root){

    }
}