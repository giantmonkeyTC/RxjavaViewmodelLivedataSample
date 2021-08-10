package com.example.myapplication.structures

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.utils.observeEventOnUi
import io.reactivex.rxjava3.functions.Consumer

class MainViewModel : ViewModel() {
    val counterNumLD = MutableLiveData<Int>()
    fun setupEvent() {
        counterNumLD.value = 0
        Client.eventBus.observeEventOnUi<CounterAddEvent>().subscribe(Consumer {
            counterNumLD.value = counterNumLD.value?.plus(it.num)
        })
        Client.eventBus.observeEventOnUi<CounterResetEvent>().subscribe(Consumer {
            if (it.reset)
                counterNumLD.value = 0
        })

    }
}