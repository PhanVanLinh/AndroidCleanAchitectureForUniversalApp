package com.hieupham.absolutecleanarchitecturekt.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import vn.linh.cleanachitectureforuniversalapp.feature.login.LoginActivity
import vn.linh.cleanachitectureforuniversalapp.feature.login.LoginModule

/**
 * The [Module] class declares how to inject an Activity instance into corresponding
 * {@link Module}
 */
@Module
abstract class ActivityBuilderModule {

    @ContributesAndroidInjector(modules = [LoginModule::class])
    @ActivityScope
    internal abstract fun bindLoginActivity(): LoginActivity
}