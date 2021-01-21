package si.hrovat.reactive.boundary.resources

import org.eclipse.microprofile.openapi.annotations.media.Content
import org.eclipse.microprofile.openapi.annotations.media.Schema
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses
import si.hrovat.reactive.UserService
import si.hrovat.reactive.boundary.resources.requests.CreateUserRequest
import si.hrovat.reactive.boundary.resources.responses.Link
import si.hrovat.reactive.boundary.resources.responses.UserResponse
import si.hrovat.reactive.boundary.resources.responses.UserResponseList
import javax.inject.Inject
import javax.ws.rs.*
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response
import javax.ws.rs.core.UriInfo

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
class UserResource @Inject constructor(val userService: UserService, val uriInfo: UriInfo) {

    @GET
    fun listUsers(): Response {
        return Response.ok().entity(UserResponseList(userService.listUsers(1, 10), Link(self = uriInfo.path)))
            .build()
    }

    @APIResponses(
        APIResponse(
            responseCode = "200", description = "User",
            content = arrayOf(
                Content(
                    schema = Schema(implementation = UserResponse::class)
                )
            )
        ),
        APIResponse(
            responseCode = "404", description = "User not found"
        )
    )
    @GET
    @Path("/{id}")
    fun getUser(@PathParam("id") id: String): Response {
        val user = userService.getUser(id)
        return Response.ok(UserResponse(user, Link(self = uriInfo.path))).build()
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    fun createUser(request: CreateUserRequest): Response {
        return Response.noContent().build()
    }
}