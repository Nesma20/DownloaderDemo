package com.nagwa.downloaderdemo.di

import android.content.Context
import com.nagwa.downloaderdemo.ui.MainActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class,AppModule::class])
interface ApplicationComponent {
    fun inject(activity: MainActivity)

//    // Factory to create instances of the AppComponent
//    @Component.Factory
//    interface Factory {
//        // With @BindsInstance, the Context passed in will be available in the graph
//        fun create(@BindsInstance context: Context): ApplicationComponent
//
//    }
}