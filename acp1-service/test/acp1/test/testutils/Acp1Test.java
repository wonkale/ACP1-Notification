package acp1.test.testutils;

import acp1.rest.config.AcpConfig;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;

import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;

/**
 * Created by mohammed al-ani on 1/23/2017.
 */
public class Acp1Test extends JerseyTest {
    @Override
    protected Application configure() {
        return new ResourceConfig(new AcpConfig());
    }
    protected TestRequestContext.TestGetRequestContext get() {
        return new TestRequestContext.TestGetRequestContext(this);
    }

    protected TestRequestContext.TestPostRequestContext post() {
        return new TestRequestContext.TestPostRequestContext(this);
    }

    public static void print(Response res){
        System.out.println(res.readEntity(String.class));
    }
}
