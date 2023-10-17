package accounting.entify.harvest;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@Data
@NoArgsConstructor
//@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Bushes {
    @XmlElement(name = "number of bushes")
    private int numberOfBushes;
    @XmlElement(name = "average yield in kg")
    private double averageYieldInKg;

    public Bushes(int numberOfBushes, double averageYieldInKg) {
        this.numberOfBushes = numberOfBushes;
        this.averageYieldInKg = averageYieldInKg;
    }

    public int getNumberOfBushes() {
        return numberOfBushes;
    }

    public double getAverageYieldInKg() {
        return averageYieldInKg;
    }
}
