package vn.linh.cleanachitectureforuniversalapp.feature.login

import com.hieupham.absolutecleanarchitecturekt.di.FragmentScope
import dagger.Module
import dagger.android.ContributesAndroidInjector
import vn.linh.cleanachitectureforuniversalapp.feature.login.login.LoginFragment
import vn.linh.cleanachitectureforuniversalapp.feature.login.login.LoginFragmentModule

@Module
abstract class LoginModule {
    @ContributesAndroidInjector(modules = [LoginFragmentModule::class])
    @FragmentScope
    abstract fun bindLoginFragment(): LoginFragment

}