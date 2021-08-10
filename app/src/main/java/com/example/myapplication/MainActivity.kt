package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.myapplication.structures.Client
import com.example.myapplication.structures.CounterAddEvent
import com.example.myapplication.structures.CounterResetEvent
import com.example.myapplication.structures.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homepage)
        val mainViewModel: MainViewModel by viewModels()
        mainViewModel.setupEvent()
        window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR)
//        mainViewModel.counterNumLD.observe(this, Observer {
//            if (it != null) {
//                Main_Counter_TV.text = it.toString()
//            }
//        })
//        Main_Enter_Button.setOnClickListener {
//            if (Main_Counter_Input_ET.text.toString() != "") {
//                Client.eventBus.postEvent(
//                    CounterAddEvent(
//                        Main_Counter_Input_ET.text.toString().toInt()
//                    )
//                )
//                Main_Counter_Input_ET.setText("")
//            }
//        }
//        Main_Reset_Button.setOnClickListener {
//            Client.eventBus.postEvent(
//                CounterResetEvent(true)
//            )
//        }
    }


}