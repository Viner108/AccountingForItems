package accounting.action;

import accounting.repository.FileRepository;

import java.io.*;
import java.nio.file.Path;
import java.util.stream.Collectors;

public class ActionRepository extends FileRepository {
    public void writeAction(Path path, ActionLog log) throws IOException {
        try (BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(path.toFile(), true))) {
            outputStream.write(log.toString().getBytes());
            outputStream.write(System.lineSeparator().getBytes());
        }
    }
    public void readFile(Path path) {
        try (BufferedReader inputStream = new BufferedReader(new FileReader(path.toFile()))) {
            String collect = inputStream.lines()
                    .collect(Collectors.joining("\n"));
            System.out.println(collect);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}