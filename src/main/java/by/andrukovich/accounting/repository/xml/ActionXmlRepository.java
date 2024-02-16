package by.andrukovich.accounting.repository.xml;

import by.andrukovich.accounting.entity.action.ActionLogMap;
import by.andrukovich.accounting.entity.action.ActionLog;

import java.nio.file.Path;

public class ActionXmlRepository extends FileXmlRepository<ActionLog, ActionLogMap>{

    public ActionXmlRepository(Path path) {
        super(path);
    }
}
