package vn.linh.cleanachitectureforuniversalapp.di

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import vn.linh.cleanachitectureforuniversalapp.feature.login.LoginViewModel

@Module
abstract class ViewModelModule {
    @Binds
    abstract fun bindViewModelFactory(
            providerFactory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel::class)
    internal abstract fun bindLoginViewModel(loginViewModel: LoginViewModel): ViewModel
}
