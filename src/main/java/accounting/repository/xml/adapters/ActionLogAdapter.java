package accounting.repository.xml.adapters;

import accounting.entify.action.ActionLog;
import accounting.entify.action.ActionLogWrapper;
import accounting.entify.items.Item;
import accounting.entify.items.ItemWrapper;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ActionLogAdapter extends XmlAdapter<ActionLogWrapper, Map<Integer, ActionLog>> {
    @Override
    public Map<Integer, ActionLog> unmarshal(ActionLogWrapper actionLogWrapper) throws Exception {
        Map<Integer, ActionLog> actionLogMap = null;
        if (actionLogWrapper != null && actionLogWrapper.actionLogs != null && !actionLogWrapper.actionLogs.isEmpty()) {
            actionLogMap = new HashMap<Integer, ActionLog>();
            int i=0;
            for (ActionLog item : actionLogWrapper.actionLogs) {
                actionLogMap.put(i,item);
                i++;
            }
        }
        return actionLogMap;
    }

    @Override
    public ActionLogWrapper marshal(Map<Integer, ActionLog> actionLogMap) throws Exception {
        ActionLogWrapper wrapper = new ActionLogWrapper();
        List<ActionLog> elements = new ArrayList<ActionLog>();
        for (Map.Entry<Integer, ActionLog> property : actionLogMap.entrySet()) {
            elements.add(property.getValue());
        }
        wrapper.actionLogs = elements;
        return wrapper;
    }
}
