package com.example.myapplication.structures

open class Event

data class CounterAddEvent(val num: Int) : Event()
data class CounterResetEvent(val reset : Boolean) : Event()