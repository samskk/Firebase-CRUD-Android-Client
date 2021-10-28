package com.example.myapplication.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.R
import com.example.myapplication.data.Contact
import com.example.myapplication.databinding.FragmentAddContactDialogBinding
import com.example.myapplication.databinding.FragmentUpdateContactDialogBinding

class UpdateContactDialogFragment(private val contact: Contact) : DialogFragment() {

    private var _binding: FragmentUpdateContactDialogBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: ContactViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NO_TITLE, android.R.style.Theme_DeviceDefault_Light_Dialog_MinWidth)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentUpdateContactDialogBinding.inflate(inflater, container, false)

       viewModel = ViewModelProvider(this).get(ContactViewModel::class.java)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        binding.textFullName.setText(contact.FullName)
        binding.editContentNumber.setText(contact.contactNumber)

        binding.buttonUpdate.setOnClickListener {
            val fullName =binding.textFullName.text.toString().trim()
            val contactNumber =binding.editContentNumber.text.toString().trim()

            if (fullName.isEmpty()){
                binding.textFullName.error = "this field is required"
                return@setOnClickListener
            }
            if (contactNumber.isEmpty()){
                binding.editContentNumber.error = "this field is required"
                return@setOnClickListener
            }


            contact.FullName = fullName
            contact.contactNumber= contactNumber

            viewModel.updateContact(contact)
            dismiss()
            Toast.makeText(context, "Contact has been updated", Toast.LENGTH_SHORT).show()

        }
    }

}