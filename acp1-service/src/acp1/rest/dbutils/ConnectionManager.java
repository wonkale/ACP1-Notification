package acp1.rest.dbutils;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by mohammed al-ani on 1/24/2017.
 */
public class ConnectionManager {

    private static ConnectionManager instance = null;
    private Map<String, HikariDataSource> dataSources;

    private ConnectionManager() {
        dataSources = new HashMap<String, HikariDataSource>();
    }

    static ConnectionManager getInstance() {
        if (instance == null) {
            instance = new ConnectionManager();
        }
        return instance;
    }

    DataSource getDataSource(DatabaseElement info) {

        if (!dataSources.containsKey(info.getUri())) {

            // Add a new data source
            HikariConfig config = new HikariConfig();
            config.setDriverClassName("com.mysql.jdbc.Driver");
            config.setJdbcUrl(info.getUri());
            config.setUsername(info.getUname());
            config.setPassword(info.getPasswd());


            try {
                System.out.println("Creating a new pooled DataSource to " + info.getUname() + "@" + info.getUri());
                dataSources.put(info.getUri(), new HikariDataSource(config));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return dataSources.get(info.getUri());
    }

    void evictMyDataSources() {

        System.out.println("Closing all DataSources");
        for (HikariDataSource ds : dataSources.values()) {
            ds.close();
        }
        dataSources.clear();
    }
}
