package si.hrovat.reactive.boundary.resources

import org.jboss.resteasy.reactive.RestPath
import si.hrovat.reactive.UserServiceImpl
import si.hrovat.reactive.boundary.resources.requests.GenericRequest
import si.hrovat.reactive.boundary.resources.responses.GenericResponse
import si.hrovat.reactive.boundary.resources.responses.GenericResponseList
import si.hrovat.reactive.boundary.resources.responses.Link
import javax.inject.Inject
import javax.ws.rs.*
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response
import javax.ws.rs.core.UriInfo

@Path("users")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
class UserResource @Inject constructor(val userService: UserServiceImpl, val uriInfo: UriInfo) {

    @GET
    fun listUsers(): Response {
        return Response.ok().entity(GenericResponseList(userService.listUsers(1, 10), Link(self = uriInfo.path))).build()
    }

    @GET
    @Path("{id}")
    fun getUser(@RestPath("id") id: String): Response {
        val user = userService.getUser(id)
        return Response.ok(GenericResponse(user, Link(self = uriInfo.path))).build()
    }

    @POST
    fun createUser(request: GenericRequest): Response {
        return Response.noContent().build()
    }
}