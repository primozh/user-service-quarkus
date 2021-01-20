package si.hrovat.reactive.boundary.resources.responses

import java.util.*

class GenericResponse(val data: ResponseData, val link: Link)

class GenericResponseList(val data: List<ResponseData>, val link: Link)

data class Link(val self: String, val first: String? = null, val next: String? = null, val last: String? = null, val prev: String? = null)

data class ResponseData(val version: Long, val id: UUID, val type: String, val attributes: Attributes)

abstract class Attributes

data class UserAttributes(val username: String, val name: String) : Attributes()
