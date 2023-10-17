package accounting.entify.harvest;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
@Data
@NoArgsConstructor
//@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Field {
    @XmlElement(name = "width")
    private double wight;
    @XmlElement(name = "row")
    private int row;
    @XmlElement(name = "plant")
    private ArrayList<Plant> planting=new ArrayList<>();

    public Field(double wight, int row) {
        this.wight = wight;
        this.row = row;
    }
    public void addPlants(Plant plant){
        planting.add(plant);
        this.row-=plant.getRow();
    }
}
