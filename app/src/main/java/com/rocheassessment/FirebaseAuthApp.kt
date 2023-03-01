package com.rocheassessment

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import com.rocheassessment.data.AppContainer
import com.rocheassessment.data.AppDataContainer

@HiltAndroidApp
class FirebaseAuthApp : Application(){
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = AppDataContainer(this)
    }
}