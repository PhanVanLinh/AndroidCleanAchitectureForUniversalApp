package linh.vn.data.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import linh.vn.data.repository.remove.api.service.ServiceGenerator
import linh.vn.data.repository.remove.api.service.UserApi
import javax.inject.Singleton

@Module
class NetworkModule {

    companion object {
        const val API_ENDPOINT = "http://api.openweathermap.org/"
    }

    @Singleton
    @Provides
    fun provideGson(): Gson {
        return GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()
    }

    @Singleton
    @Provides
    fun provideUserApi(gson: Gson): UserApi {
        return ServiceGenerator.createService(API_ENDPOINT, UserApi::class.java, gson)
    }
}