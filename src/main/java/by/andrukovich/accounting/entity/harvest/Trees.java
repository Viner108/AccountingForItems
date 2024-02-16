package by.andrukovich.accounting.entity.harvest;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@Data
@NoArgsConstructor
//@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Trees {
    @XmlElement(name = "number of bushes")
    private int numberOfTrees;
    @XmlElement(name = "average yield in kg")
    private double averageYieldInKg;

    public Trees(int numberOfTrees, double averageYieldInKg) {
        this.numberOfTrees = numberOfTrees;
        this.averageYieldInKg = averageYieldInKg;
    }

    public int getNumberOfTrees() {
        return numberOfTrees;
    }

    public double getAverageYieldInKg() {
        return averageYieldInKg;
    }
}
