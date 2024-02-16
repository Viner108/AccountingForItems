package by.andrukovich.accounting.entity.items;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@Data
@NoArgsConstructor
//@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class SpareParts extends Item {
    @XmlElement(name = "parent")
    Item parent;

    public SpareParts(String name, int id, double width, double length, double height,Item parent) {
        super(name, id, width, length, height);
        this.parent=parent;
    }

    public Item getParent() {
        return parent;
    }
}
