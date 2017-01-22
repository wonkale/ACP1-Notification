package acp1.rest.dao;

import acp1.rest.Model.AcpModel;

import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Collection;

import static javax.ws.rs.core.Response.*;

/**
 * Created by mohammed al-ani on 1/22/2017.
 */
public class AcpDao {

    public AcpDao(){

    }

    public Collection<AcpModel> readData(){
        AcpModel mod1 = new AcpModel();
        mod1.setName("first");
        mod1.setNotificationSettings("on");
        AcpModel mod2 = new AcpModel();
        mod2.setName("second");
        mod2.setNotificationSettings("off");

        ArrayList<AcpModel> arr = new ArrayList<>();
        arr.add(mod1);
        arr.add(mod2);

        return arr;
    }
    public Response postData(AcpModel data){
        return status(Status.CREATED).entity(data).build();
    }
}
