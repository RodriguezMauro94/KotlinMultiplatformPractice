package com.maurosergiorodriguez.professionalfeaturesapp

import android.app.Application
import com.maurosergiorodriguez.professionalfeaturesapp.di.initKoin
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger

class ProfessionalFeaturesApp: Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin{
            androidLogger()
            androidContext(this@ProfessionalFeaturesApp)
        }
    }
}