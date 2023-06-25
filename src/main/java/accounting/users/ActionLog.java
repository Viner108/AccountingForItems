package accounting.users;

import java.util.ArrayList;
import java.util.List;

public class ActionLog {

    private List<String> actions = new ArrayList<>();
    public ActionLog(){

    }
    public List<String> getActions() {
        return actions;
    }

    @Override
    public String toString() {
        return "ActionLog{" +
                "История активности=" + actions +
                '}';
    }
}
