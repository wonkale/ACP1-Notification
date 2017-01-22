package acp1.rest.rest;

import acp1.rest.Model.AcpModel;
import acp1.rest.dao.AcpDao;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Collection;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("/mydata")
public class AcpResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<AcpModel> readData() {

        return new AcpDao().readData();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response postData(AcpModel acp){
        return new AcpDao().postData(acp);
    }
}
