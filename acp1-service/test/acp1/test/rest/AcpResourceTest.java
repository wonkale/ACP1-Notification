package acp1.test.rest;

import acp1.rest.Model.AcpModel;
import acp1.rest.dao.AcpDao;
import acp1.test.testutils.Acp1Test;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Test;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import static org.junit.Assert.assertEquals;

/**
 * Created by mohammed al-ani on 1/23/2017.
 */
public class AcpResourceTest extends Acp1Test {


    @Test
    public void getData(){
        Response r = get().target("mydata").execute();
        assertEquals(Status.OK,r.getStatusInfo());
        print(r);
    }

    @Test
    public void postData() throws JsonProcessingException {
        AcpModel model = new AcpModel();
        model.setName("AcpTestJersey");
        model.setNotificationSettings("off");

        Response r = post().target("mydata").entity(model).execute();
        print(r);
    }


}
