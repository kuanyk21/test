package com.example.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.Sampler
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import com.google.firebase.database.*

class ViewProfile : AppCompatActivity() {

    private lateinit var listStaff: ListView
    private lateinit var reference:DatabaseReference
    private lateinit var staffList: MutableList<Staff>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_profile2)

        reference =FirebaseDatabase.getInstance().getReference("Staff")

        listStaff = findViewById(R.id.lv_staff)
        val actionBar = supportActionBar
        actionBar!!.title = "Profile List"
        actionBar.setDisplayHomeAsUpEnabled(true)

        staffList = mutableListOf()

        reference.addValueEventListener(object :ValueEventListener {
            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

            override fun onDataChange(p0: DataSnapshot) {
                if(p0.exists()){
                    staffList.clear()
                    for(h in p0.children){
                        val staff = h.getValue(Staff::class.java)
                        if (staff != null) {
                            staffList.add(staff)
                        }
                    }

                    val adapter = StaffAdapter(this@ViewProfile,R.layout.item_staff, staffList)
                    listStaff.adapter = adapter
                }
            }

        })
        }


}