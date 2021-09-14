package com.nagwa.downloaderdemo.utils

import android.app.Application
import com.nagwa.downloaderdemo.di.DaggerApplicationComponent

class MyApplication: Application() {
    // Reference to the application graph that is used across the whole app
    val appComponent = DaggerApplicationComponent.create()
}