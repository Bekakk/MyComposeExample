package com.example.myapp

import android.app.Application
import com.example.myapp.di.loadInsuranceModule
import com.example.myapp.di.loadLoanModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MyApp)
//            modules(AppModules.modules)
        }
        loadLoanModule()
        loadInsuranceModule()
    }
}
