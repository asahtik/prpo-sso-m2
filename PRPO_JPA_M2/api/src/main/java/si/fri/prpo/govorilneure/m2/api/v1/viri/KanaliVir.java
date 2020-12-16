package si.fri.prpo.govorilneure.m2.api.v1.viri;

import si.fri.prpo.govorilneure.m2.api.v1.dtos.KanalDto;
import si.fri.prpo.govorilneure.m2.data.Kanal;
import si.fri.prpo.govorilneure.m2.zrna.KanaliZrno;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.LinkedHashMap;

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
        Kanal ret = kz.pridobiZId(id);
        if(ret != null) return Response.status(200).entity(ret).build();
        return Response.status(404).build();
    }

    @POST
    @Consumes({"application/si.fri.prpo.govorilneure.m2.data.Kanal+json"})
    public Response dodaj(Kanal k) {
        Kanal ret = kz.dodaj(k);
        if(ret != null) return Response.status(Response.Status.OK).entity(ret).build();
        else return Response.status(500).build();
    }

    @PUT
    @Path("{id}")
    public Response posodobi(@PathParam("id") int id, Object k) {
        Kanal ret = kz.posodobi(id, (Integer) ((LinkedHashMap)k).get("termin"));
        if(ret != null) return Response.status(Response.Status.OK).entity(ret).build();
        else return Response.status(404).build();
    }

    @DELETE
    @Path("{id}")
    public Response odstrani(@PathParam("id") int id) {
        return Response.status(kz.odstrani(id)).build();
    }
}