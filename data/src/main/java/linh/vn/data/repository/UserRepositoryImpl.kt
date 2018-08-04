package linh.vn.data.repository

import io.reactivex.Single
import linh.vn.data.model.UserDataMapper
import linh.vn.data.repository.local.UserLocalDataSource
import linh.vn.data.repository.remove.UserRemoteDataSource
import linh.vn.domain.entity.User
import linh.vn.domain.repository.UserRepository

class UserRepositoryImpl(private val localDataSource: UserLocalDataSource,
                         private val remoteDataSource: UserRemoteDataSource,
                         private val userDataMapper: UserDataMapper
) : UserRepository {

    override fun login(userName: String, password: String): Single<User> {
        return remoteDataSource.login(userName, password).map { userDataMapper.mapToDomain(it) }
    }
}