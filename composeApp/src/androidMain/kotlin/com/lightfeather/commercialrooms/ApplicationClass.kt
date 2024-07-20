package com.lightfeather.commercialrooms

import android.app.Application
import framework.AndroidContactPicker
import framework.ContactPicker
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.dsl.module

class ApplicationClass : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(
                module {
                    single<ContactPicker> { AndroidContactPicker(it.get()) }
                }
            )
            androidContext(this@ApplicationClass)
        }
    }

}