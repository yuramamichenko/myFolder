
public class MainClass {

    public static void main(String[] args) {

        UI ui = new UI();

        Cypher coder = new Cypher();

        FileService fileService = new FileService(ui);

        switch (ui.chooseOperation()) {
            case 0 -> fileService.writeFile(coder.encode(fileService.readFile(), ui.getKey()));

            case 1 -> fileService.writeFile(coder.decode(fileService.readFile(), ui.getKey()));

            case 2 -> fileService.writeFile(coder.brutForce(fileService.readFile()));
        }
    }
}
