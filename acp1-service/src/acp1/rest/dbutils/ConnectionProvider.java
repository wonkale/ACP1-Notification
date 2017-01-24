package acp1.rest.dbutils;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by mohammed al-ani on 1/24/2017.
 */
public class ConnectionProvider {

    private static ConnectionManager mgr;
    private DatabaseElement dbElement;

    public ConnectionProvider(){
        dbElement = getElement();
    }
    private DatabaseElement getElement(){
        String uri = "jdbc:mysql://localhost:3306/acp";
        return new DatabaseElement(uri,"root" ,"");
    }

    public Connection getConnection(){
        DataSource ds = ConnectionManager.getInstance().getDataSource(dbElement);
        try {
            return ds.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

}
