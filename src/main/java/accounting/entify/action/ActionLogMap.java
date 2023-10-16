package accounting.entify.action;

import accounting.entify.items.Item;
import accounting.repository.xml.adapters.ActionLogAdapter;
import accounting.repository.xml.adapters.ItemAdapter;

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
