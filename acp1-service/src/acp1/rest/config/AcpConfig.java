package acp1.rest.config;

import acp1.rest.session.SessionAuthenticationFilter;
import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;

/**
 * Created by mohammed al-ani on 1/22/2017.
 */
@ApplicationPath("/rest")
public class AcpConfig extends ResourceConfig{

   public AcpConfig(){
       packages("acp1.rest.rest");
       register(SessionAuthenticationFilter.class);
    }

}

