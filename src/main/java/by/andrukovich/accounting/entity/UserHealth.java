package by.andrukovich.accounting.entity;


import org.springframework.beans.factory.annotation.Value;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity

@Table(name = "user_health")
public class UserHealth {
    @Id
    private String id;

    public String getPressure() {
        return pressure;
    }

    public void setPressure(String pressure) {
        this.pressure = pressure;
    }

    public String getHeadAche() {
        return headAche;
    }

    public void setHeadAche(String headAche) {
        this.headAche = headAche;
    }

    private String pressure;

    private String headAche;

    public UserHealth() {
    }

    public UserHealth(String name) {
        this.id = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String name) {
        this.id = name;
    }
}
