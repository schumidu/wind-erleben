package de.wind_erleben;

import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@Path("datavalues")
@RequestScoped
public class DataValuesUffResource {

    @PersistenceContext
    EntityManager em;

    @GET
    public Response getNewest(){
        Query query = em.createNamedQuery("newest").setMaxResults(1);
        return Response.ok(query.getSingleResult()).build();
    }
    
}
