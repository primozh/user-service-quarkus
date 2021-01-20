package si.hrovat.reactive

import java.util.*

open class GenericResponse(val data: DataGeneric, val link: Link)

abstract class DataGeneric

data class Data(val data: ResponseData) : DataGeneric()

data class DataList(val data: List<ResponseData>) : DataGeneric()

data class Link(val self: String, val first: String?, val next: String?, val last: String?, val prev: String?)

data class ResponseData(val version: Long, val id: UUID, val type: String, val attributes: Attributes)

abstract class Attributes

data class UserAttributes(val username: String, val name: String) : Attributes()
