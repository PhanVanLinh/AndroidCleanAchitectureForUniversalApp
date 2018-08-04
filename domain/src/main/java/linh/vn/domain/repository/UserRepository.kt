package linh.vn.domain.repository

import io.reactivex.Single
import linh.vn.domain.entity.User

interface UserRepository : Repository {
    fun login(userName: String, password: String): Single<User>
}