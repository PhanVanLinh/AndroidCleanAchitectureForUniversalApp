package linh.vn.data.repository.remove

import io.reactivex.Single
import linh.vn.data.model.UserData
import linh.vn.data.repository.remove.api.service.UserApi
import javax.inject.Inject

class UserRemoteDataSource @Inject constructor(val userApi: UserApi) {

    fun login(userName: String, password: String): Single<UserData> {
        return userApi.login(userName, password)
    }
}