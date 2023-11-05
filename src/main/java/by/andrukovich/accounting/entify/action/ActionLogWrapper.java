package by.andrukovich.accounting.entify.action;

import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.List;

public class ActionLogWrapper {
    @XmlElement(name = "log")
    public List<ActionLog> actionLogs = new ArrayList<ActionLog>();

}
