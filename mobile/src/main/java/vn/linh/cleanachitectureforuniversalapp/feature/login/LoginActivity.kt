package vn.linh.cleanachitectureforuniversalapp.feature.login

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import vn.linh.cleanachitectureforuniversalapp.R
import vn.linh.cleanachitectureforuniversalapp.feature.base.BaseActivity
import vn.linh.cleanachitectureforuniversalapp.feature.login.login.LoginFragment

class LoginActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        var loginFragment: Fragment? = supportFragmentManager
                .findFragmentById(R.id.contentFrame)
        if (loginFragment == null) {
            loginFragment = LoginFragment()
            addFragmentToActivity(supportFragmentManager, loginFragment, R.id.contentFrame)
        }
    }

    fun addFragmentToActivity(fragmentManager: FragmentManager,
                              fragment: Fragment, frameId: Int) {
        val transaction = fragmentManager.beginTransaction()
        transaction.add(frameId, fragment)
        transaction.commit()
    }

}
