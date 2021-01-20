package si.hrovat.reactive

import si.hrovat.reactive.boundary.resources.responses.ResponseData
import si.hrovat.reactive.boundary.resources.responses.UserAttributes
import java.util.*
import javax.enterprise.context.RequestScoped

@RequestScoped
class UserServiceImpl : UserService {

    override fun listUsers(page: Long, size: Long): List<ResponseData> {

        return listOf(ResponseData(1, UUID.randomUUID(), "user", UserAttributes("primoz", "primoz")))
    }

    override fun getUser(id: String): ResponseData {

        return ResponseData(1, UUID.randomUUID(), "user", UserAttributes("primoz", "primoz"))
    }


}

interface UserService {

    fun listUsers(page: Long, size: Long): List<ResponseData>

    fun getUser(id: String): ResponseData
}
