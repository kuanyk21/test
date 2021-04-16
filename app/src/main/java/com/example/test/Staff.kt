package com.example.test

data class Staff(
        val id : String,
        val name: String,
        val email:String,
        val phone:String,
        val date:String
){
        constructor(): this("","","","",""){

        }
}