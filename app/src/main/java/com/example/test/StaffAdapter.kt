package com.example.test

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.google.firebase.database.FirebaseDatabase

class StaffAdapter (val sCtx : Context,val layoutResId : Int, val staffList:List<Staff>) :
    ArrayAdapter<Staff>(sCtx, layoutResId, staffList){

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layoutInflater:LayoutInflater = LayoutInflater.from(sCtx)

        val view:View = layoutInflater.inflate(layoutResId, null )

        val tvName :TextView = view.findViewById(R.id.tv_name)
        val tvEmail:TextView = view.findViewById(R.id.tv_email)
        val tvPhone:TextView = view.findViewById(R.id.tv_phone)
        val tvDate:TextView = view.findViewById(R.id.tv_date)
        val tvEdit:TextView = view.findViewById(R.id.tv_edit)


        val staff :Staff = staffList[position]

        tvEdit.setOnClickListener{
            showUpdateDialog(staff)
        }

        tvName.text = staff.name
        tvEmail.text = staff.email
        tvPhone.text = staff.phone
        tvDate.text = staff.date

        return view
    }

    fun showUpdateDialog(staff: Staff) {
        val builder = AlertDialog.Builder(sCtx)

        builder.setTitle("Edit Profile ")

        val inflater = LayoutInflater.from(sCtx)
        val view = inflater.inflate(R.layout.update_dialog, null)

        val etName = view.findViewById<EditText>(R.id.editTextName)
        val etMail = view.findViewById<EditText>(R.id.editTextEmail)
        val etPhone = view.findViewById<EditText>(R.id.editTextPhone)
        val etDate = view.findViewById<EditText>(R.id.editTextDate)

        etName.setText(staff.name)
        etMail.setText(staff.email)
        etPhone.setText(staff.phone)
        etDate.setText(staff.date)


        builder.setView(view)

        builder.setPositiveButton("Update"){p0,p1 ->
            val dbStaff = FirebaseDatabase.getInstance().getReference("Staff")

            val name = etName.text.toString().trim()
            val email = etMail.text.toString().trim()
            val phone = etPhone.text.toString().trim()
            val date = etDate.text.toString().trim()
            if(name.isEmpty()){
                etName.error = "Please fill in your name!"
                etName.requestFocus()
                return@setPositiveButton
            }
            if(email.isEmpty()){
                etMail.error = "Please fill in your email!"
                etMail.requestFocus()
                return@setPositiveButton
            }
            if(phone.isEmpty()) {
                etPhone.error = "Please fill in your phone number!"
                etPhone.requestFocus()
                return@setPositiveButton
            }
            if(date.isEmpty()) {
                etDate.error = "Please fill in your birth date!"
                etDate.requestFocus()
                return@setPositiveButton
            }
            val staff = Staff(staff.id, name, email, phone, date)

            dbStaff.child(staff.id!!).setValue(staff)

            Toast.makeText(sCtx,"Your profile has benn updated!", Toast.LENGTH_SHORT).show()
        }


        builder.setNeutralButton("No"){p0,p1->

        }
        builder.setNegativeButton("DELETE"){p0,p1 ->
            val dbStaff = FirebaseDatabase.getInstance().getReference("Staff").child(staff.id)
            dbStaff.removeValue()

            Toast.makeText(sCtx,"Your data has been deleted",Toast.LENGTH_SHORT).show()
        }

        val alert  = builder.create()
        alert.show()
    }

}


