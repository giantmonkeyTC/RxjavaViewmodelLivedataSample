package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
        setContentView(R.layout.activity_main)
        val mainViewModel: MainViewModel by viewModels()
        mainViewModel.setupEvent()
        mainViewModel.counterNumLD.observe(this, Observer {
            if (it != null) {
                Main_Counter_TV.text = it.toString()
            }
        })
        Main_Enter_Button.setOnClickListener {
            if (Main_Counter_Input_ET.text.toString() != "") {
                print(Main_Counter_Input_ET.text.toString())
                Client.eventBus.postEvent(
                    CounterAddEvent(
                        Main_Counter_Input_ET.text.toString().toInt()
                    )
                )
                Main_Counter_Input_ET.setText("")
            }
        }
        Main_Reset_Button.setOnClickListener {
            Client.eventBus.postEvent(
                CounterResetEvent(true)
            )
        }
    }


}