package si.hrovat.reactive

import si.hrovat.reactive.boundary.resources.responses.UserAttributes
import si.hrovat.reactive.boundary.resources.responses.UserResponseData
import java.util.*
import javax.enterprise.context.RequestScoped

@RequestScoped
class UserServiceImpl : UserService {

    override fun listUsers(page: Long, size: Long): List<UserResponseData> {

        return listOf(UserResponseData(1, UUID.randomUUID(), "user", UserAttributes("primoz", "primoz")))
    }

    override fun getUser(id: String): UserResponseData {

        return UserResponseData(1, UUID.randomUUID(), "user", UserAttributes("primoz", "primoz"))
    }


}

interface UserService {

    fun listUsers(page: Long, size: Long): List<UserResponseData>

    fun getUser(id: String): UserResponseData
}
