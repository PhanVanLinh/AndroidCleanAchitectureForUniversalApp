package vn.linh.cleanachitectureforuniversalapp.feature.login

import android.arch.lifecycle.ViewModel
import linh.vn.domain.entity.User
import linh.vn.domain.interactor.LoginUseCase
import linh.vn.domain.interactor.outputport.CustomSingleCustomObserver
import javax.inject.Inject

class LoginViewModel @Inject constructor(private val loginUseCase: LoginUseCase) : ViewModel() {

    fun a() {
        val input = LoginUseCase.Input("1", "2")
        loginUseCase.execute(input, object : CustomSingleCustomObserver<User>() {
            override fun onSuccess(t: User) {

            }

            override fun onError(throwable: Throwable) {

            }

            override fun onSubscribe() {

            }

            override fun doAfterTerminate() {

            }
        })
    }
}