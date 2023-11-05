package by.andrukovich.accounting.entify.action;

import by.andrukovich.accounting.repository.xml.adapters.ActionLogAdapter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Map;

@XmlRootElement(name = "ActionLogMap")
public class ActionLogMap {
    Map<Integer, ActionLog> actionLogMap;

    public Map<Integer, ActionLog> getActionLogMap() {
        return actionLogMap;
    }

    @XmlElement(name = "Actions")
    @XmlJavaTypeAdapter(ActionLogAdapter.class)
    public void setActionLogMap(Map<Integer, ActionLog> actionLogMap) {
        this.actionLogMap = actionLogMap;
    }
}
