package vn.linh.cleanachitectureforuniversalapp

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import vn.linh.cleanachitectureforuniversalapp.di.DaggerAppComponent

class CleanApp : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().application(this).build()
    }
}