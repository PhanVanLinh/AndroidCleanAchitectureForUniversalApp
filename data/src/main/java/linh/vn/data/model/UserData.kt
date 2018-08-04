package linh.vn.data.model

import linh.vn.domain.entity.User
import javax.inject.Inject

data class UserData(
        val name: String,
        val password: String,
        val description: String) {

}

class UserDataMapper @Inject constructor() {

    fun mapToDomain(userData: UserData): User = User(
            name = userData.name,
            password = userData.password,
            description = userData.description
    )
}
