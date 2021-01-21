package si.hrovat.reactive.boundary.resources.responses

import java.util.*

class UserResponse(val data: UserResponseData, val link: Link)

class UserResponseList(val data: List<UserResponseData>, val link: Link)

data class Link(val self: String, val first: String? = null, val next: String? = null, val last: String? = null, val prev: String? = null)

data class UserResponseData(val version: Long, val id: UUID, val type: String, val attributes: UserAttributes)

data class UserAttributes(val username: String, val name: String)
