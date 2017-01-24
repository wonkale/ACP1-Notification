package acp1.rest.dbutils;

/**
 * Created by mohammed al-ani on 1/24/2017.
 */
public class DatabaseElement {

    @Override
    public String toString() {
        return "DBElement: uri [" + uri + "], user [" + uname + "]";
    }

    public DatabaseElement(String uri, String uname, String passwd) {
        this.uri = uri;
        this.uname = uname;
        this.passwd = passwd;
    }

    private String uri;
    private String uname;
    private String passwd;

    public final String getUri() {
        return uri;
    }
    public final String getUname() {
        return uname;
    }
    public final String getPasswd() {
        return passwd;
    }
}
