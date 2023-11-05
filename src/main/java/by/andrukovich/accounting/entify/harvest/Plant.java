package by.andrukovich.accounting.entify.harvest;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@Data
@NoArgsConstructor
//@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Plant {
    @XmlElement(name = "row")
    private int row;
    @XmlElement(name = "average yield in kg")
    private double averageYieldInKg;

    public Plant(int row, double averageYieldInKg) {
        this.row = row;
        this.averageYieldInKg = averageYieldInKg;
    }

    public int getRow() {
        return row;
    }

    public double getAverageYieldInKg() {
        return averageYieldInKg;
    }
}
