package si.hrovat.reactive

import java.util.*
import javax.enterprise.context.RequestScoped

@RequestScoped
class UserServiceImpl : UserService {

    override fun listUsers(page: Long, size: Long): DataList {

        val users =
            listOf(ResponseData(1, UUID.randomUUID(), "user", UserAttributes("primoz", "primoz")))

        return DataList(users)
    }

    override fun getUser(id: String): Data {

        return Data(ResponseData(1, UUID.randomUUID(), "user", UserAttributes("primoz", "primoz")))
    }


}

interface UserService {

    fun listUsers(page: Long, size: Long): DataList

    fun getUser(id: String): Data
}
