package com.example.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.PopupWindow
import kotlinx.android.synthetic.main.activity_warehouse_map.*


class WarehouseMap : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_warehouse_map)

        val actionBar = supportActionBar
        actionBar!!.title = "Warehouse "
        actionBar.setDisplayHomeAsUpEnabled(true)

        popupBTN.setOnClickListener {
            val window = PopupWindow(this)
            val view = layoutInflater.inflate(R.layout.layout_popup, null)
            window.contentView = view
            val imageView = view.findViewById<ImageView>(R.id.imageView)
            imageView.setOnClickListener{
                window.dismiss()
            }
            window.showAsDropDown(popupBTN)
        }
        popupBTN2.setOnClickListener {
            val window = PopupWindow(this)
            val view = layoutInflater.inflate(R.layout.layout_popup1, null)
            window.contentView = view
            val imageView1 = view.findViewById<ImageView>(R.id.keyboard)
            imageView1.setOnClickListener{
                window.dismiss()
            }
            window.showAsDropDown(popupBTN2)
        }
        popupBTN3.setOnClickListener {
            val window = PopupWindow(this)
            val view = layoutInflater.inflate(R.layout.layout_popup2, null)
            window.contentView = view
            val keyboard = view.findViewById<ImageView>(R.id.keyboard)
            keyboard.setOnClickListener{
                window.dismiss()
            }
            window.showAsDropDown(popupBTN3)
        }
        popupBTN4.setOnClickListener {
            val window = PopupWindow(this)
            val view = layoutInflater.inflate(R.layout.layout_popup3, null)
            window.contentView = view
            val mouse = view.findViewById<ImageView>(R.id.mouse)
            mouse.setOnClickListener{
                window.dismiss()
            }
            window.showAsDropDown(popupBTN4)
        }
        popupBTN5.setOnClickListener {
            val window = PopupWindow(this)
            val view = layoutInflater.inflate(R.layout.layout_popup4, null)
            window.contentView = view
            val headphone = view.findViewById<ImageView>(R.id.headphone)
            headphone.setOnClickListener{
                window.dismiss()
            }
            window.showAsDropDown(popupBTN5)
        }
        popupBTN6.setOnClickListener {
            val window = PopupWindow(this)
            val view = layoutInflater.inflate(R.layout.layout_popup5, null)
            window.contentView = view
            val speaker = view.findViewById<ImageView>(R.id.speaker)
            speaker.setOnClickListener{
                window.dismiss()
            }
            window.showAsDropDown(popupBTN6)
        }
        popupBTN7.setOnClickListener {
            val window = PopupWindow(this)
            val view = layoutInflater.inflate(R.layout.layout_popup6, null)
            window.contentView = view
            val webcam = view.findViewById<ImageView>(R.id.webcam)
            webcam.setOnClickListener{
                window.dismiss()
            }
            window.showAsDropDown(popupBTN7)
        }
        popupBTN8.setOnClickListener {
            val window = PopupWindow(this)
            val view = layoutInflater.inflate(R.layout.layout_popup7, null)
            window.contentView = view
            val cpu = view.findViewById<ImageView>(R.id.cpu)
            cpu.setOnClickListener{
                window.dismiss()
            }
            window.showAsDropDown(popupBTN8)
        }
    }

}

        //var popupBTN: Button? = null
        //var mDialog: Dialog? = null


        //super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        // popupBTN = findViewById(R.id.popupBTN)
         //mDialog = Dialog(this)

         //popupBTN?.setOnClickListener(View.OnClickListener {

          // mDialog!!.setContentView(R.layout.popup)
          // mDialog!!.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
          //mDialog!!.show()
          //})
      //  }

  //  }
