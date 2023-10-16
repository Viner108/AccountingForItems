package accounting.entify.action;

import accounting.entify.items.Item;

import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.List;

public class ActionLogWrapper {
    @XmlElement(name = "log")
    public List<ActionLog> actionLogs = new ArrayList<ActionLog>();

}
