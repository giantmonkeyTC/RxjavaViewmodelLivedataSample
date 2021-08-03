package com.example.myapplication.utils

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.kotlin.ofType
import io.reactivex.rxjava3.processors.PublishProcessor

class RxBus : EventBus {

    private val publishProcessor = PublishProcessor.create<Any>()

    override fun postEvent(event: Any) {
        publishProcessor.onNext(event)
    }

    override fun observeEvents(): Flowable<Any> {
        return publishProcessor.serialize().onBackpressureBuffer()
    }

    override fun observeEventsOnUi(): Flowable<Any> {
        return observeEvents().observeOn(AndroidSchedulers.mainThread()).onBackpressureBuffer()
    }
}

interface EventBus {

    fun postEvent(event: Any)

    fun observeEvents(): Flowable<Any>

    fun observeEventsOnUi(): Flowable<Any>
}

inline fun <reified T : Any> EventBus.observeEvent(): Flowable<T> {
    return observeEvents().onBackpressureBuffer().ofType()
}

inline fun <reified T : Any> EventBus.observeEventOnUi(): Flowable<T> {
    return observeEventsOnUi().onBackpressureBuffer().ofType()
}