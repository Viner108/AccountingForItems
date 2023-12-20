package by.andrukovich.accounting.entify;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DTO {
    @JsonProperty("pressure")
    private String pressure;
    @JsonProperty("headAche")
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
