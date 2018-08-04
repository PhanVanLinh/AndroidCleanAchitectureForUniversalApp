package vn.linh.cleanachitectureforuniversalapp.feature.login.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import vn.linh.cleanachitectureforuniversalapp.R
import vn.linh.cleanachitectureforuniversalapp.feature.base.BaseFragment

class LoginFragment : BaseFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }
}
