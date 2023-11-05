package by.andrukovich.accounting.entify.harvest;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@Data
@NoArgsConstructor
//@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Greenhouses extends Field {
    public Greenhouses(double wight, int row) {
        super(wight, row);
    }

}
