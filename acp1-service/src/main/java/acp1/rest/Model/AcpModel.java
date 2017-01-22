package acp1.rest.Model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by mohammed al-ani on 1/22/2017.
 */
@XmlRootElement
public class AcpModel {

    String name;
    String notificationSettings;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNotificationSettings() {
        return notificationSettings;
    }

    public void setNotificationSettings(String notificationSettings) {
        this.notificationSettings = notificationSettings;
    }
}
