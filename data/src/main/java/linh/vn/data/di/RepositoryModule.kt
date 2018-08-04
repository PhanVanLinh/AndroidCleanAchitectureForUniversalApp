package linh.vn.data.di

import dagger.Module
import dagger.Provides
import linh.vn.data.model.UserDataMapper
import linh.vn.data.repository.UserRepositoryImpl
import linh.vn.data.repository.local.UserLocalDataSource
import linh.vn.data.repository.remove.UserRemoteDataSource
import linh.vn.domain.repository.UserRepository
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideUserRepo(
            localDataSource: UserLocalDataSource, remoteDataSource: UserRemoteDataSource, userDataMapper: UserDataMapper): UserRepository {
        return UserRepositoryImpl(localDataSource, remoteDataSource, userDataMapper)
    }
}