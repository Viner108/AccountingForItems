package by.andrukovich.accounting.entify.items;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.time.LocalDate;
@Data
@NoArgsConstructor
//@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Medicines extends Item {
    @XmlAttribute(name = "name")
    private String name;
    @XmlElement(name = "valid by date")
    private LocalDate validByDate;
    public Medicines(String name, int id, double width, double length, double height, int day,int month,int year) {
        super(name, id, width, length, height);
        this.name = name;
        this.validByDate =LocalDate.of(year,month,day);
    }

    public String getName() {
        return name;
    }


    public LocalDate getValidByDate() {
        return validByDate;
    }
}
