package com.example.test

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.*
import com.google.firebase.database.*
import com.google.firebase.database.core.view.View
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*

 class MainActivity : AppCompatActivity(), android.view.View.OnClickListener {

     private lateinit var editTextName: EditText
     private lateinit var editTextEmail: EditText
     private lateinit var editTextPhone:EditText
     private lateinit var editTextDate:EditText
     private lateinit var buttonSave : Button

     private lateinit var reference: DatabaseReference
     private lateinit var staffList:MutableList<Staff>
     
     override fun onCreate(savedInstanceState: Bundle?) {
         super.onCreate(savedInstanceState)
         setContentView(R.layout.activity_main)

         val actionBar = supportActionBar

         actionBar!!.title = "Create Profile"

         actionBar.setDisplayHomeAsUpEnabled(true)

   warehouseBtn.setOnClickListener {
       val intent = Intent(this, WarehouseMap::class.java)
       startActivity(intent)
   }

         val ref: DatabaseReference = FirebaseDatabase.getInstance().getReference("Staff")

         editTextName = findViewById(R.id.editTextName)
         editTextEmail = findViewById(R.id.editTextEmail)
         editTextPhone = findViewById(R.id.editTextPhone)
         editTextDate = findViewById(R.id.editTextDate)
         buttonSave = findViewById(R.id.buttonSave)


         buttonSave.setOnClickListener(this)
         
         var imageView: ImageView = findViewById(R.id.imageView)
         var url: String = "https://img.freepik.com/free-vector/man-avatar-profile-on-round-icon_24640-14044.jpg?size=338&ext=jpg";

         Picasso.get().load(url).into(imageView)

     }

     override fun onClick(v: android.view.View?) {
         saveData()

     }
     private fun saveData() {
         val name: String = editTextName.text.toString().trim()
         val email: String = editTextEmail.text.toString().trim()
         val phone: String = editTextPhone.text.toString().trim()
         val date: String = editTextDate.text.toString().trim()

         if (name.isEmpty()) {
             editTextName.error = "Please enter your name!"
             return
         }

         if (email.isEmpty()) {
             editTextEmail.error = "Please enter your email!"
             return
         }

         if (phone.isEmpty()) {
             editTextPhone.error = "Please enter your phone!"
             return
         }

         if (date.isEmpty()) {
             editTextDate.error = "Please enter your birth date!"
             return
         }

        Toast.makeText(this, "Saved!", Toast.LENGTH_LONG).show()

         val intent = Intent(this,ViewProfile::class.java)
         startActivity(intent)



         val ref: DatabaseReference = FirebaseDatabase.getInstance().getReference("Staff")
         val staffId: String? = ref.push().key

         val staff = Staff(staffId!!, name, email, phone, date)

         if (staffId != null) {
             ref.child(staffId).setValue(staff).addOnCompleteListener{
                 Toast.makeText(applicationContext,"Your profile has added!",Toast.LENGTH_SHORT).show()
             }
         }
     }
 }







