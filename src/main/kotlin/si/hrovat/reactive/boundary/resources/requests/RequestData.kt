package si.hrovat.reactive.boundary.resources.requests

import java.util.*

data class CreateUserRequest(val id: UUID, val username: String, val password: String)
