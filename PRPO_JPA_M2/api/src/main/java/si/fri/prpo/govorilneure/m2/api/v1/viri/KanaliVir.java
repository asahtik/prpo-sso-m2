package si.fri.prpo.govorilneure.m2.api.v1.viri;

import si.fri.prpo.govorilneure.m2.zrna.KanaliZrno;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("kanali")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ApplicationScoped
public class KanaliVir {

    @Inject
    KanaliZrno kz;

    @GET
    public Response pridobiVse() {
        return Response.status(200).entity(kz.pridobiVse()).build();
    }

    @GET
    @Path("{id}")
    public Response pridobiEnega(@PathParam("id") int id) {
        return Response.status(200).entity(kz.pridobiZId(id)).build();
    }

}