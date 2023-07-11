package accounting.action;

import java.util.ArrayList;
import java.util.List;

public class ActionLog {

    private ArrayList<String> actions = new ArrayList<>();
    public ActionLog(){

    }
    public ArrayList<String> getActions() {
        return actions;
    }

    @Override
    public String toString() {
        return "ActionLog{" +
                "История активности=" + actions +
                '}';
    }
}
