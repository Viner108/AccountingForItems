package by.andrukovich.accounting.entity;

public class DTO {

    private String pressure;

    private String headAche;

    public DTO(String pressure, String headAche) {
        this.pressure = pressure;
        this.headAche = headAche;
    }

    public String getPressure() {
        return pressure;
    }

    public String getHeadAche() {
        return headAche;
    }
}
