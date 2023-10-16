package accounting.entify.action;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
@Data
@NoArgsConstructor
//@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ActionLog implements Serializable {
    @XmlElement(name = "action")
    private String actions = new String();
    public String getActions() {
        return actions;
    }

    @Override
    public String toString() {
        return "ActionLog{" +
                "История активности=" + actions +
                '}';
    }
}
