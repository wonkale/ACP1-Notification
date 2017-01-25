package acp1.rest.session;

import javax.annotation.Priority;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.*;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

/**
 * Created by mohammed al-ani on 1/25/2017.
 */
@Provider
@Priority(Priorities.AUTHENTICATION)
@PreMatching
public class SessionAuthenticationFilter implements ContainerRequestFilter, ContainerResponseFilter {

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        if(requestContext.getHeaders().getFirst("acp").equals("asdfzxcv")){
            String value = requestContext.getHeaders().getFirst("acp");
            System.out.println("acp : " + value);
        } else {
            requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED)
                    .entity("Wronge Token")
                    .build());
        }

    }

    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) throws IOException {
        System.out.println(requestContext.getHeaders());
        responseContext.getHeaders().add("X-Powred","acp");
    }
}
