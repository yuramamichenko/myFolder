import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileService {

    private final UI ui;

    public FileService(UI ui) {
        this.ui = ui;
    }

    public List<String> readFile() {
        List<String> stringList = new ArrayList<>();
        try (BufferedReader bufferedFileReader = new BufferedReader(new FileReader(ui.getPathToFile("in")))) {
            while (bufferedFileReader.ready()) {
                stringList.add(bufferedFileReader.readLine());
            }
            return stringList;
        } catch (IOException e) {
            ui.wrongPathToFile();
            readFile();
        }
        return stringList;
    }

    public void writeFile(List<String> stringList) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(ui.getPathToFile("out")))) {
            for (String s : stringList) {
                bufferedWriter.write(s + "\n");
            }
            ui.doneMessage();
        } catch (IOException e) {
            ui.wrongPathToFile();
            writeFile(stringList);
        }
    }
}
