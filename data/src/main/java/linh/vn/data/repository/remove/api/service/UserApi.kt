package linh.vn.data.repository.remove.api.service

import io.reactivex.Single
import linh.vn.data.model.UserData
import retrofit2.http.POST
import retrofit2.http.Path

interface UserApi {

    @POST("/user/login")
    fun login(@Path("username") userName: String, @Path("password") password: String) : Single<UserData>
}