package by.andrukovich.accounting.entity.items;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.io.Serializable;
@Data
@NoArgsConstructor
//@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Item implements Serializable {
    @XmlAttribute(name = "name")
    private String name;
    @XmlAttribute(name = "id")
    private int id;
    @XmlElement(name = "width")
    private double width;
    @XmlElement(name = "length")
    private double length;
    @XmlElement(name = "height")
    private double height;

    public Item(String name, int id, double width, double length, double height) {
        this.name = name;
        this.id = id;
        this.width = width;
        this.length = length;
        this.height = height;
    }

    public double volume() {
        return this.width * this.length * this.height;
    }

    @Override
    public String toString() {
        return "Item{" +
                "Название предмета='" + name + '\'' +
                ", id=" + id +
                ", Ширина=" + width +
                ", Длина=" + length +
                ", Высота=" + height +
                '}';
    }
}
