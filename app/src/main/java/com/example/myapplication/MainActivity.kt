package com.example.myapplication

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener


class MainActivity : AppCompatActivity() {

    private val ref = FirebaseDatabase.getInstance().getReference("name")
    private val ref1 = FirebaseDatabase.getInstance().getReference("name list")

    private lateinit var nameEditText: EditText
    private lateinit var ageEditText: EditText

    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nameEditText = findViewById(R.id.editTextTextPersonName)
        ageEditText = findViewById(R.id.editTextNumber)

        textView = findViewById(R.id.textView)

        val upButton = findViewById<Button>(R.id.button)
        upButton.setOnClickListener {
            var name = nameEditText.text.toString()
            var age = ageEditText.text.toString()
            var user1 = UserModel(name, age)

//            ref.setValue("hi")
            ref.setValue(name)
            ref1.push().setValue(user1)
        }

        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                val value = dataSnapshot.getValue(String::class.java)
                Log.d(TAG, "Value is: $value")
                textView.text = "Whee! Our new value from firebase is  $value"
            }

            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException())
            }
        })

    }
}