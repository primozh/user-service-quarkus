package si.hrovat.reactive.boundary.resources

import org.jboss.resteasy.reactive.RestPath
import si.hrovat.reactive.UserServiceImpl
import javax.inject.Inject
import javax.ws.rs.Consumes
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

@Path("users")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
class UserResource @Inject constructor(val userService: UserServiceImpl) {

    @GET
    fun listUsers(): Response {
        return Response.ok().entity(userService.listUsers(1, 10)).build()
    }

    @GET
    @Path("{id}")
    fun getUser(@RestPath("id") id: String): Response {
        return Response.ok(userService.getUser(id)).build()
    }
}