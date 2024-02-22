package de.wind_erleben;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@Path("winderlebenrestcfg")
@RequestScoped
public class WindErlebenRestConfigResource {

    @Inject
    WindErlebenRestClient werc;
    
    @POST
    public Response postConfig(final WindErlebenRestClientConfig wercc){
        werc.cfg = wercc;
        return Response.ok().build();
    }

    @GET
    public Response getConfig(){
        return Response.ok(werc.cfg).build();
    }

}
